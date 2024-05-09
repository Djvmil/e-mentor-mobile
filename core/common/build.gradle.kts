plugins {
    alias(libs.plugins.djvmil.ementor.library)
}

android {
    namespace = "com.djvmil.entretienmentor.core.common"
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.tink.android)

    testImplementation(libs.robolectric)
    testImplementation(projects.core.testing)
}