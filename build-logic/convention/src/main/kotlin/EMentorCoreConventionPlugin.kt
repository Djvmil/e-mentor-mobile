import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class EMentorCoreConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("djvmil.e-mentor.library")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:data"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:domain"))


                add("implementation", libs.findLibrary("compose.coil").get())

                add("implementation", libs.findLibrary("androidx.compose.runtime").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("activity.compose").get())
                add("implementation", libs.findLibrary("compose.navigation").get())

                add("implementation", libs.findLibrary("koin.android").get())
                add("implementation", libs.findLibrary("koin.compose").get())
                add("implementation", libs.findLibrary("koin.compose.navigation").get())
                add("implementation", libs.findLibrary("koin.test.junit4").get())


                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))
                add("androidTestImplementation", libs.findLibrary("androidx.test.ext.junit").get())
                add("androidTestImplementation", libs.findLibrary("espresso.core").get())


                add("androidTestImplementation", platform(libs.findLibrary("compose.bom").get()))
                add("androidTestImplementation", libs.findLibrary("ui.test.junit4").get())
                add("androidTestImplementation", libs.findLibrary("ui.tooling").get())
                add("androidTestImplementation", libs.findLibrary("test.manifest").get())

            }
        }
    }
}
