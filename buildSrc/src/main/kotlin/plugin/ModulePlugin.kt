package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

internal interface ModulePlugin : Plugin<Project> {

    fun appendNext(next: ModulePlugin) = object : ModulePlugin {

        override fun apply(target: Project) {
            this@ModulePlugin.apply(target)
            next.apply(target)
        }
    }
}
