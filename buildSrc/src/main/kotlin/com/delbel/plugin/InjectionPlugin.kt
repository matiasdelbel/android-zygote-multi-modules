package com.delbel.plugin

import com.delbel.Injection
import org.gradle.api.Project
import org.gradle.api.applyPlugin
import org.gradle.api.artifacts.dsl.implementation
import org.gradle.api.artifacts.dsl.kapt
import org.gradle.kotlin.dsl.dependencies

class InjectionPlugin : ModulePlugin {

    override fun apply(target: Project) {
        target.applyPlugin(PLUGIN)

        target.dependencies {
            implementation(Injection.hilt)
            kapt(Injection.hiltCompiler)
        }
    }

    companion object {
        const val PLUGIN = "dagger.hilt.android.plugin"
    }
}
