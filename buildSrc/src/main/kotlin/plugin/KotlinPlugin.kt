package plugin

import com.android.build.gradle.BaseExtension
import deps.Core
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class KotlinPlugin : ModulePlugin {

    companion object {
        private const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
        private const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"

        private const val IMPLEMENTATION = "implementation"

        private const val EXTENSION_ANDROID = "android"
        private val SOURCE_SETS = mapOf(
            "main" to "src/main/kotlin/",
            "test" to "src/test/kotlin/",
            "androidTest" to "src/androidTest/kotlin/"
        )
    }

    override fun apply(target: Project) {
        target.plugins.apply(PLUGIN_KOTLIN_ANDROID)
        target.plugins.apply(PLUGIN_KOTLIN_KAPT)

        applyKotlinSourceSets(target)

        target.dependencies { add(IMPLEMENTATION, Core.stdlibJdk7) }
    }

    private fun applyKotlinSourceSets(target: Project) {
        val androidExtension = target.extensions.getByName(EXTENSION_ANDROID)
        if (androidExtension !is BaseExtension) return

        androidExtension.sourceSets { SOURCE_SETS.forEach { named(it.key) { java.srcDir(it.value) } } }
    }
}