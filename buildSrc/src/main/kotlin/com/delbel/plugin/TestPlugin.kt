package com.delbel.plugin

import com.delbel.InstrumentationTest
import com.delbel.UnitTest
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.androidTestImplementation
import org.gradle.api.artifacts.dsl.testImplementation
import org.gradle.api.baseAndroidExtension
import org.gradle.kotlin.dsl.dependencies
import kotlin.contracts.ExperimentalContracts

internal class TestPlugin : ModulePlugin {

    @ExperimentalContracts
    override fun apply(target: Project) {
        val androidExtension = target.baseAndroidExtension() ?: return
        androidExtension.defaultConfig { testInstrumentationRunner = TEST_RUNNER }

        target.dependencies {
            testImplementation(UnitTest.junit4)
            testImplementation(UnitTest.mockitoKtx)
            testImplementation(UnitTest.truth)

            androidTestImplementation(InstrumentationTest.runner)
            androidTestImplementation(InstrumentationTest.rules)
            androidTestImplementation(InstrumentationTest.core)
            androidTestImplementation(InstrumentationTest.truth)
        }
    }

    companion object {
        private const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }
}
