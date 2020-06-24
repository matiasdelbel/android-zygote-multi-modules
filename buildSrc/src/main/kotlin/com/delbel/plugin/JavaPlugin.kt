package com.delbel.plugin

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.baseAndroidExtension
import kotlin.contracts.ExperimentalContracts

internal class JavaPlugin : ModulePlugin {

    @ExperimentalContracts
    override fun apply(target: Project) {
        val androidExtension = target.baseAndroidExtension() ?: return

        androidExtension.compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}
