plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.djvmil.entretienmentor.core.common"
}

dependencies {
    val composeBom = platform(libs.compose.bom)

    implementation(libs.core.ktx)
    implementation(composeBom)
    implementation(libs.compose.constraintlayout)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.tink.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
}