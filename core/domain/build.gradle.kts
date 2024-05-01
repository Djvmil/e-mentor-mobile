plugins {
    alias(libs.plugins.djvmil.ementor.library)
}


android {
    namespace = "com.djvmil.entretienmentor.core.domain"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)

    testImplementation(projects.core.testing)

    implementation(libs.koin.android)
    implementation(libs.koin.test.junit4)

}