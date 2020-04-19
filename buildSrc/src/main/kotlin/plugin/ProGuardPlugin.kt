package plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project

internal class ProGuardPlugin : ModulePlugin {

    companion object {
        private const val EXTENSION_ANDROID = "android"

        private const val VERSION_RELEASE = "release"

        private const val PROGUARD_FILE = "proguard-rules.pro"
        private const val PROGUARD_ANDROID_FILE = "proguard-android-optimize.txt"
    }

    override fun apply(target: Project) {
        val androidExtension = target.extensions.getByName(EXTENSION_ANDROID)
        if (androidExtension !is BaseExtension) return

        when (androidExtension) {
            is LibraryExtension -> applyConfiguration(androidExtension)
            is AppExtension -> applyConfiguration(androidExtension)
        }
    }

    private fun applyConfiguration(extension: LibraryExtension) =
        extension.defaultConfig { consumerProguardFiles(PROGUARD_FILE) }

    private fun applyConfiguration(extension: AppExtension) = extension.buildTypes {
        getByName(VERSION_RELEASE) {
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(extension.getDefaultProguardFile(PROGUARD_ANDROID_FILE), PROGUARD_FILE)
        }
    }
}