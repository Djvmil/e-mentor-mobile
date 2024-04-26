plugins {
    id("djvmil.e-mentor.library")
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

    implementation(project(":core:common"))

    implementation(libs.kotlinx.serialization)

    implementation(libs.koin.android)
    implementation(libs.koin.test.junit4)


    implementation(libs.ktor.core)
    implementation(libs.ktor.android)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.client.auth)

    //datastore
    implementation(libs.androidx.datastore.proto)
    implementation(libs.kotlinx.serialization.protobuf)

    //database
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
    implementation(libs.primitive.adapters)
    implementation(libs.androidx.paging3.extensions)
    testImplementation(project(":core:testing"))

    //test
    testImplementation(libs.sqldelight.sqlite.driver)
    testImplementation(libs.sqldelight.sqlite.driver)
}