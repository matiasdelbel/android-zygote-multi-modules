package com.delbel.plugin

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.applyPlugin
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class ScaPlugin : ModulePlugin {

    override fun apply(target: Project) {
        target.applyPlugin(PLUGIN_KTLINT)
        target.applyPlugin(PLUGIN_DETEKT)

        target.extensions.configure(EXTENSION_KT_LINT, Action<KtlintExtension> { debug.set(true) })
    }

    companion object {
        private const val PLUGIN_KTLINT = "org.jlleitschuh.gradle.ktlint"
        private const val PLUGIN_DETEKT = "io.gitlab.arturbosch.detekt"

        private const val EXTENSION_KT_LINT = "ktlint"
    }
}
