package plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

internal class AndroidPlugin : ModulePlugin {

    companion object {
        private const val EXTENSION_ANDROID = "android"

        private const val SDK_COMPILE_VERSION = 29
        private const val SDK_TARGET_VERSION = SDK_COMPILE_VERSION
        private const val SDK_MIN_VERSION = 15

        private const val VERSION_CODE = 1
        private const val VERSION_NAME = "1.0.0"
    }

    override fun apply(target: Project) {
        val androidExtension = target.extensions.getByName(EXTENSION_ANDROID)
        if (androidExtension !is BaseExtension) return

        androidExtension.compileSdkVersion(SDK_COMPILE_VERSION)
        androidExtension.defaultConfig {

            targetSdkVersion(SDK_TARGET_VERSION)
            minSdkVersion(SDK_MIN_VERSION)

            versionCode = VERSION_CODE
            versionName = VERSION_NAME

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
}