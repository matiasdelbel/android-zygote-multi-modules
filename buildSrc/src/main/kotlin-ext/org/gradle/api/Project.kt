package org.gradle.api

import com.android.build.gradle.BaseExtension
import com.delbel.plugin.CoverageExtension
import org.gradle.kotlin.dsl.configure
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

fun Project.coverage(configuration: CoverageExtension.() -> Unit) = configure(configuration)

internal fun Project.applyPlugin(plugin: String) = plugins.apply(plugin)

/**
 * Obtain the base android extension from the project
 *
 * @return the extension, or null if the project does not have one
 */
@ExperimentalContracts
internal fun Project.baseAndroidExtension(): BaseExtension? {
    contract { returns(true) implies (this@baseAndroidExtension is BaseExtension) }

    return extensions.getByName(EXTENSION_ANDROID) as? BaseExtension
}

private const val EXTENSION_ANDROID = "android"