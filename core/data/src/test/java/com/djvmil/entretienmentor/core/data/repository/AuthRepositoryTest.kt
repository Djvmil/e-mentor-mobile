package com.djvmil.entretienmentor.core.data.repository

import com.djvmil.entretienmentor.core.common.model.map
import com.djvmil.entretienmentor.core.data.common.FAKE_DATA
import com.djvmil.entretienmentor.core.data.model.ApiOperation
import com.djvmil.entretienmentor.core.data.model.auth.AuthRequest
import com.djvmil.entretienmentor.core.data.model.auth.RequestResult
import com.djvmil.entretienmentor.core.data.model.auth.ResponseAuthData
import com.djvmil.entretienmentor.core.data.repository.testDouble.FakeAppSettingsDataStoreSource
import com.djvmil.entretienmentor.core.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.entretienmentor.core.data.source.datastore.model.StepsStarting
import com.djvmil.entretienmentor.core.data.source.remote.api.ApiService
import com.djvmil.entretienmentor.core.data.source.remote.model.UserApiModel
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AuthRepositoryTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    private val dispatcher = StandardTestDispatcher()
    @MockK private lateinit var apiService: ApiService
    @MockK private lateinit var dataStoreSource: AppSettingsDataStoreSource
    private lateinit var authRepository: AuthRepository
    private val bodyRequest = AuthRequest(username = "admin@em.com", password = "1234")

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)

        coEvery {
            apiService.login(bodyRequest)
        } returns ApiOperation.Success(FAKE_DATA.requestResult)

        dataStoreSource = FakeAppSettingsDataStoreSource()
        authRepository = AuthRepositoryImpl(apiService = apiService, dataStoreSource = dataStoreSource)
    }


    @Test
    fun login_Assert_Response_Success() = runTest {
        //GIVEN
        val expectedUserResponse = FAKE_DATA.requestResult.data?.user
        val expectedAccessToken = FAKE_DATA.requestResult.data?.accessToken

        //WHEN
        val result = authRepository.login(bodyRequest)

        //THEN
        val  actualData = result.toList()

        //Assertion
        actualData.last().map { result ->
            Truth.assertThat(result.data).isNotNull()
            Truth.assertThat(result.data?.accessToken).isNotNull()
            Truth.assertThat(result.data?.accessToken).isEqualTo(expectedAccessToken)
            Truth.assertThat(result.data?.user).isEqualTo(expectedUserResponse)

        }

    }

    @Test
    fun login_Assert_Saved_Token_OnDataStore() = runTest {
        //GIVEN
        val expectedAccessToken = FAKE_DATA.requestResult.data?.accessToken
        val expectedStepsStarting = StepsStarting.ON_HOME_USER

        //WHEN
        dataStoreSource.setLogin(
            status = true,
            accessToken = expectedAccessToken!!,
            steps = StepsStarting.ON_HOME_USER
        )

        //THEN
        val  actualDataStore = dataStoreSource.appSetting().toList()

        //Assertion
        actualDataStore.map {
            Truth.assertThat(it?.isLogin).isEqualTo(true)
            Truth.assertThat(it?.accessToken).isEqualTo(expectedAccessToken)
            Truth.assertThat(it?.stepsStarting).isEqualTo(expectedStepsStarting)

        }

    }


    @After
    fun close() {
        Dispatchers.resetMain()
    }

}