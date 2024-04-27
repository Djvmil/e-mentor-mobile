import com.djvmil.entretienmentor.EMBuildType

plugins {
    id("djvmil.e-mentor.app")
    id("djvmil.e-mentor.app.compose")
}

android {
    namespace = "com.djvmil.entretienmentor"

    defaultConfig {
        applicationId = "com.djvmil.entretienmentor"
        versionCode = 2
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        //testInstrumentationRunner = "com.djvmil.entretienmentor.core.testing.EMTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = EMBuildType.DEBUG.applicationIdSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = EMBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }
/*        val demo by creating {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks.add("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            isMinifyEnabled = true
            applicationIdSuffix = EMBuildType.DEBUG.applicationIdSuffix
        }*/
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:common"))

    implementation(libs.core.ktx)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.compose.navigation)
 

    implementation(libs.androidx.core.splashscreen)

    //androidTestImplementation(kotlin("test"))
    androidTestImplementation(project(":core:testing"))
    androidTestImplementation(libs.androidx.navigation.testing)
}

// androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
configurations.configureEach {
    resolutionStrategy {
        force(libs.junit4)
        // Temporary workaround for https://issuetracker.google.com/174733673
        force("org.objenesis:objenesis:2.6")
    }
}