package plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal class JavaPlugin : ModulePlugin {

    companion object {
        private const val EXTENSION_ANDROID = "android"

        private const val JVM_1_8 = "1.8"
    }

    override fun apply(target: Project) {
        val androidExtension = target.extensions.getByName(EXTENSION_ANDROID)
        if (androidExtension !is BaseExtension) return

        androidExtension.compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        target.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions { jvmTarget = JVM_1_8 }
        }
    }
}