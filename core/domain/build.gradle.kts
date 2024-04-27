plugins {
    id("djvmil.e-mentor.library")
}


android {
    namespace = "com.djvmil.entretienmentor.core.domain"
}

dependencies {
    implementation(libs.core.ktx)

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    testImplementation(project(":core:testing"))

    implementation(libs.koin.android)
    implementation(libs.koin.test.junit4)

}