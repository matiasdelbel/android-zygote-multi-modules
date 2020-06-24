package com.delbel.plugin

import org.gradle.api.Project
import org.gradle.api.baseAndroidExtension
import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
internal class AndroidPlugin : ModulePlugin {

    override fun apply(target: Project) {
        val androidExtension = target.baseAndroidExtension() ?: return

        androidExtension.compileSdkVersion(SDK_COMPILE_VERSION)
        androidExtension.defaultConfig {
            targetSdkVersion(SDK_TARGET_VERSION)
            minSdkVersion(SDK_MIN_VERSION)

            versionCode = VERSION_CODE
            versionName = VERSION_NAME
        }
    }

    companion object {
        private const val SDK_COMPILE_VERSION = 29
        private const val SDK_TARGET_VERSION = SDK_COMPILE_VERSION
        private const val SDK_MIN_VERSION = 15

        private const val VERSION_CODE = 1
        private const val VERSION_NAME = "1.0.0"
    }
}
