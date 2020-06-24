package com.delbel.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.baseAndroidExtension
import kotlin.contracts.ExperimentalContracts

internal class ProGuardPlugin : ModulePlugin {

    @ExperimentalContracts
    override fun apply(target: Project) {
        val androidExtension = target.baseAndroidExtension() ?: return

        when (androidExtension) {
            is LibraryExtension -> applyConfiguration(androidExtension)
            is AppExtension -> applyConfiguration(androidExtension)
        }
    }

    private fun applyConfiguration(extension: LibraryExtension) = extension.defaultConfig {
        consumerProguardFiles(PROGUARD_FILE)
    }

    private fun applyConfiguration(extension: AppExtension) = extension.buildTypes {
        getByName(VERSION_RELEASE) {
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(extension.getDefaultProguardFile(PROGUARD_ANDROID_FILE), PROGUARD_FILE)
        }
    }

    companion object {
        private const val VERSION_RELEASE = "release"

        private const val PROGUARD_FILE = "proguard-rules.pro"
        private const val PROGUARD_ANDROID_FILE = "proguard-android-optimize.txt"
    }
}
