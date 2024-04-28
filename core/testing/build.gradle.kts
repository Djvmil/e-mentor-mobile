plugins {
    id("djvmil.e-mentor.library")
    id("djvmil.e-mentor.library.compose")
}

android {
    namespace = "com.djvmil.entretienmentor.core.testing"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))

    api(libs.junit4)
    api(libs.turbine)
    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.ext.junit)

    debugApi(libs.ui.test.manifest)
}