plugins {
    alias(libs.plugins.djvmil.ementor.library)
    alias(libs.plugins.djvmil.ementor.library.compose)
}

android {
    namespace = "com.djvmil.entretienmentor.core.testing"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    api(kotlin("test"))
    implementation(projects.core.common)
    implementation(projects.core.data)

    api(libs.androidx.compose.ui.test)

    debugApi(libs.androidx.compose.ui.test.manifest)

    implementation(libs.androidx.test.rules)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlinx.datetime)
}