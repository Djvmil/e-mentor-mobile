package com.djvmil.entretienmentor.core.data.source.remote

import com.djvmil.entretienmentor.core.data.model.ApiOperation
import com.djvmil.entretienmentor.core.data.model.auth.AuthRequest
import com.djvmil.entretienmentor.core.data.model.auth.RequestResult
import com.djvmil.entretienmentor.core.data.model.auth.ResponseAuthData
import com.djvmil.entretienmentor.core.data.model.mapSuccess
import com.djvmil.entretienmentor.core.data.model.onFailure
import com.djvmil.entretienmentor.core.data.model.onSuccess
import com.djvmil.entretienmentor.core.data.common.ApiResponseType
import com.djvmil.entretienmentor.core.data.common.readFile
import com.djvmil.entretienmentor.core.data.source.remote.api.ApiService
import com.djvmil.entretienmentor.core.data.source.remote.api.ApiServiceImpl
import com.google.common.truth.Truth.assertThat
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.junit.Test

class ApiServiceTest {

    private val dispatcher = StandardTestDispatcher()
    private lateinit var apiService: ApiService
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun login_Assert_Response_Success() = runTest {
        //GIVEN
        apiService = ApiServiceFake.build(ApiResponseType.RESPONSE_DATA_VALID)
        val bodyRequest = AuthRequest(username = "admin@em.com", password = "1234")

        //WHEN
        val result = apiService.login(bodyRequest).mapSuccess { it }

        //THEN
        assertThat(result).isNotNull()
        assertThat(result.mapSuccess { it.code }).isEqualTo(ApiOperation.Success( data = 200))
        assertThat(result.mapSuccess { it.data}).isNotNull()
        assertThat(result.mapSuccess { it.data?.accessToken }).isNotNull()
    }

    @Test
    fun login_Assert_Response_Unauthorized() = runTest {
        //GIVEN
        apiService = ApiServiceFake.build(ApiResponseType.RESPONSE_UNAUTHORIZED)
        val bodyRequest = AuthRequest(username = "admin@em.com", password = "1234")

        //WHEN
        val result = apiService.login(bodyRequest)
        println("result => $result")

        //THEN
        assertThat(result).isInstanceOf(ApiOperation.Failure::class.java)
        result.onFailure {
            assertThat(it.error?.code).isEqualTo( 401)
        }

    }

    @After
    fun close() {
        Dispatchers.resetMain()
    }

}