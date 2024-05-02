plugins {
    alias(libs.plugins.djvmil.ementor.library)
    alias(libs.plugins.djvmil.ementor.library.compose)
}

android {
    namespace = "com.djvmil.entretienmentor.core.ui"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.constraintlayout)
    api(libs.androidx.material.icons.extended)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
    api(libs.compose.coil)

    api(libs.material)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.graphics.shapes)
    api(libs.androidx.compose.ui.tooling.preview)

    debugApi(libs.androidx.compose.ui.tooling)

    testImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(projects.core.testing)
}