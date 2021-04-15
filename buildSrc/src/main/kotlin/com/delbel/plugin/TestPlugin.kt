package com.delbel.plugin

import org.gradle.api.Project
import org.gradle.api.baseAndroidExtension
import kotlin.contracts.ExperimentalContracts

internal class TestPlugin : ModulePlugin {

    @ExperimentalContracts
    override fun apply(target: Project) {
        val androidExtension = target.baseAndroidExtension() ?: return
        androidExtension.defaultConfig { testInstrumentationRunner = TEST_RUNNER }
    }

    companion object {
        private const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }
}
