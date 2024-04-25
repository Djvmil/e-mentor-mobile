plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqldelight)
}

android {
    namespace = "com.djvmil.entretienmentor.core.data"
}

sqldelight {
    databases {
        create("DatabaseSource") {
            packageName.set("com.djvmil.entretienmentor")
        }
    }
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    testImplementation(libs.sqldelight.sqlite.driver)

    implementation(libs.koin.android)
    implementation(libs.koin.test.junit4)

    implementation(libs.kotlinx.serialization)

    implementation(libs.ktor.core)
    implementation(libs.ktor.android)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.client.auth)
    //implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

    //datastore
    implementation(libs.androidx.datastore.proto)
    implementation(libs.kotlinx.serialization.protobuf)

    //database
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
    implementation(libs.primitive.adapters)
    implementation(libs.androidx.paging3.extensions)
    testImplementation(libs.sqldelight.sqlite.driver)
}