plugins {
    `kotlin-dsl`
}

group = "com.djvmil.entretienmentor.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "djvmil.e-mentor.app"
            implementationClass = "EMentorAppConventionPlugin"
        }
        register("androidAppCompose") {
            id = "djvmil.e-mentor.app.compose"
            implementationClass = "EMentorAppComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "djvmil.e-mentor.library"
            implementationClass = "EMentorLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "djvmil.e-mentor.library.compose"
            implementationClass = "EMentorLibraryComposeConventionPlugin"
        }
        register("androidCore") {
            id = "djvmil.e-mentor.core"
            implementationClass = "EMentorCoreConventionPlugin"
        }
    }
}