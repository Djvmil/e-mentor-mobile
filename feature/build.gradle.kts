plugins {
    alias(libs.plugins.djvmil.ementor.core)
    alias(libs.plugins.djvmil.ementor.library.compose)
}

android {
    namespace = "com.djvmil.entretienmentor.feature"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)

    testImplementation(projects.core.testing)
    androidTestImplementation(projects.core.testing)
}