plugins {
    id("djvmil.e-mentor.library")
    id("djvmil.e-mentor.library.compose")
}

android {
    namespace = "com.djvmil.entretienmentor.core.ui"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.androidx.compose.runtime)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.compose.constraintlayout)
    api(libs.ui)
    api(libs.material)
    api(libs.material3)
    api(libs.ui.graphics)
    api(libs.compose.coil)
    api(libs.ui.tooling.preview)
    api(libs.androidx.graphics.shapes)
    api(libs.androidx.material.icons.extended)
    debugApi(libs.ui.tooling)
}