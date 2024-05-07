plugins {
    alias(libs.plugins.djvmil.ementor.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqldelight)
}

android {
    namespace = "com.djvmil.entretienmentor.core.data"

    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
}

sqldelight {
    databases {
        create("DatabaseSource") {
            packageName.set("com.djvmil.entretienmentor")
        }
    }
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.ktor.core)
    implementation(libs.ktor.android)
    implementation(libs.ktor.okHttp)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.client.auth)
    implementation(libs.koin.android)

    //datastore
    implementation(libs.androidx.datastore.proto)
    implementation(libs.kotlinx.serialization.protobuf)

    //database
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
    implementation(libs.primitive.adapters)
    implementation(libs.androidx.paging3.extensions)


    //test
    testImplementation(projects.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
    testImplementation(libs.sqldelight.sqlite.driver)
    testImplementation(libs.sqldelight.sqlite.driver)
}