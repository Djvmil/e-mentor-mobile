plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.djvmil.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

sqldelight {
    databases {
        create("DatabaseSource") {
            packageName.set("com.djvmil")
        }
    }
}


dependencies {

    implementation(project(":core"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.koin.android)
    implementation(libs.koin.test.junit4)

    implementation(libs.kotlinx.serialization)

    implementation(libs.ktor.core)
    implementation(libs.ktor.android)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.logging)
    //implementation("com.squareup.moshi:moshi-kotlin:1.15.1")

    //implementation("androidx.datastore:datastore-preferences-core:1.1.0")
    //implementation("androidx.datastore:datastore-core:1.1.0")
    implementation(libs.androidx.datastore.core)

    implementation  ("androidx.datastore:datastore:1.0.0")
    // Starting from Protobuf 3.8.0, use the lite runtime library
    implementation  ("com.google.protobuf:protobuf-javalite:3.18.0")

    implementation ("com.google.code.gson:gson:2.8.7")
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
}
