plugins {
    alias(libs.plugins.djvmil.ementor.library)
}

android {
    namespace = "com.djvmil.entretienmentor.core.common"
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.tink.android)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.androidx.test.rules)

    testImplementation(projects.core.testing)
}