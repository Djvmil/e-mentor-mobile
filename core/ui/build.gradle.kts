plugins {
    id("djvmil.e-mentor.library")
    id("djvmil.e-mentor.library.compose")
}

android {
    namespace = "com.djvmil.entretienmentor.core.ui"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.runtime)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.constraintlayout)
    api(libs.compose.ui)
    api(libs.material)
    api(libs.androidx.compose.material3)
    api(libs.compose.ui.graphics)
    api(libs.compose.coil)
    api(libs.androidx.graphics.shapes)
    api(libs.compose.ui.tooling.preview)
    api(libs.androidx.material.icons.extended)
    debugApi(libs.compose.ui.tooling)
}