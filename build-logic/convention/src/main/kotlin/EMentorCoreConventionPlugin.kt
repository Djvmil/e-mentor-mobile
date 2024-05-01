import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class EMentorCoreConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("djvmil.e-mentor.library")
            }
            /*extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "com.djvmil.entretienmentor.core.testing.EMTestRunner"
                }
            }*/

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:data"))
                add("implementation", project(":core:common"))
                add("implementation", project(":core:domain"))
                //add("testImplementation", kotlin("test"))
                add("testImplementation", project(":core:testing"))

                //add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                //add("implementation", libs.findLibrary("androidx.compose.runtime").get())
                add("implementation", libs.findLibrary("kotlinx.collections.immutable").get())
                add("implementation", libs.findLibrary("androidx.navigation.compose").get())

                add("implementation", libs.findLibrary("koin.android").get())
                add("implementation", libs.findLibrary("koin.compose").get())
                //add("implementation", libs.findLibrary("koin.compose.navigation").get())
                //add("implementation", libs.findLibrary("koin.test.junit4").get())


            }
        }
    }
}
