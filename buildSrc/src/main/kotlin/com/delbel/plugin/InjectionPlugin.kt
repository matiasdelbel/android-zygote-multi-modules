package com.delbel.plugin

import org.gradle.api.Project
import org.gradle.api.applyPlugin

class InjectionPlugin : ModulePlugin {

    override fun apply(target: Project) {
        target.applyPlugin(PLUGIN)
    }

    companion object {
        const val PLUGIN = "dagger.hilt.android.plugin"
    }
}
