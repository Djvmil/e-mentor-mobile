plugins {
    id("djvmil.e-mentor.library")
    id("djvmil.e-mentor.library.compose")
}

android {
    namespace = "com.djvmil.entretienmentor.ui"
}

dependencies {
    val composeBom = platform(libs.compose.bom)

    implementation(libs.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)

    api(composeBom)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.compose.constraintlayout)
    api(libs.compose.coil)
    api(libs.ui)
    api(libs.ui.graphics)
    api(libs.ui.tooling.preview)
    api(libs.material3)
    api(libs.material)
    api(libs.androidx.graphics.shapes)
    api(libs.androidx.material.icons.extended)
    debugApi(libs.ui.tooling)
    debugApi(libs.ui.test.manifest)

}