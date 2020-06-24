package com.delbel.plugin

import com.android.build.gradle.BaseExtension
import com.delbel.Kotlin
import org.gradle.api.Project
import org.gradle.api.applyPlugin
import org.gradle.api.artifacts.dsl.implementation
import org.gradle.api.baseAndroidExtension
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlin.contracts.ExperimentalContracts

internal class KotlinPlugin : ModulePlugin {

    @ExperimentalContracts
    override fun apply(target: Project) {
        target.applyPlugin(PLUGIN_KOTLIN_ANDROID)
        target.applyPlugin(PLUGIN_KOTLIN_KAPT)

        target.tasks.withType(KotlinCompile::class.java).configureEach { kotlinOptions { jvmTarget = JVM_1_8 } }
        applyKotlinSourceSets(androidExtension = target.baseAndroidExtension())

        target.dependencies {
            implementation(Kotlin.stdlibJdk7)
            implementation(Kotlin.coroutines)
        }
    }

    private fun applyKotlinSourceSets(androidExtension: BaseExtension?) = androidExtension?.sourceSets {
        SOURCE_SETS.forEach { (source, folders) -> named(source) { java.setSrcDirs(folders) } }
    }

    companion object {
        private const val PLUGIN_KOTLIN_ANDROID = "kotlin-android"
        private const val PLUGIN_KOTLIN_KAPT = "kotlin-kapt"

        private const val JVM_1_8 = "1.8"

        private val SOURCE_SETS = mapOf(
            "main" to listOf("src/main/kotlin/", "src/main/kotlin-ext/"),
            "test" to listOf("src/test/kotlin/", "src/test/mocks/"),
            "androidTest" to listOf("src/test/androidTest/")
        )
    }
}
