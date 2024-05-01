// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    libs.plugins.apply {
        alias(android.application) apply false
        alias(libs.plugins.android.library) apply false
        alias(libs.plugins.android.test) apply false
        alias(kotlin.serialization) apply false
        alias(sqldelight) apply false
        alias(libs.plugins.gms) apply false
        alias(libs.plugins.ksp) apply false
        alias(libs.plugins.dependencyGuard) apply false
        alias(libs.plugins.module.graph) apply true // Plugin applied to allow module graph generation
    }
}

// Task to print all the module paths in the project e.g. :core:data
// Used by module graph generator script
tasks.register("printModulePaths") {
    subprojects {
        if (subprojects.size == 0) {
            println(this.path)
        }
    }
}