// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    libs.plugins.apply {
        alias(com.android.application) apply false
        alias(org.jetbrains.kotlin.android) apply false
        alias(kotlin.serialization) apply false
        alias(sqldelight) apply false
    }
}
true // Needed to make the Suppress annotation work for the plugins block