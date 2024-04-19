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

    //datastore
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore.proto)
    //implementation(libs.protobuf.kotlin.lite)
    implementation(libs.protobuf.java.lite)

    implementation (libs.gson)
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.coroutines)
}
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.24.4"
    }

    // Generates the kotlin Protobuf-lite code for the Protobufs in this project. See
    // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
    // for more information.
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}