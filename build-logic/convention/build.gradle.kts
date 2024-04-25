plugins {
    `kotlin-dsl`
}

group = "com.djvmil.entretienmentor.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidFeature") {
            id = "com.djvmil.entretienmentor.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}