package plugin

import deps.Injection
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class InjectionPlugin : ModulePlugin {

    override fun apply(target: Project) {
        target.plugins.apply(Injection.plugin)

        target.dependencies {
            add(IMPLEMENTATION, Injection.hilt)
            add(KAPT, Injection.hiltCompiler)
        }
    }

    companion object {
        private const val IMPLEMENTATION = "implementation"
        private const val KAPT = "kapt"
    }
} 