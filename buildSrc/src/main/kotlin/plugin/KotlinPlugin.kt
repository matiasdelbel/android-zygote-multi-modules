package plugin

import org.gradle.api.Project

internal class KotlinPlugin : ModulePlugin {

    companion object {
        private const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
        private const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"
    }

    override fun apply(target: Project) {
        target.plugins.apply(PLUGIN_KOTLIN_ANDROID)
        target.plugins.apply(PLUGIN_KOTLIN_KAPT)
    }
}