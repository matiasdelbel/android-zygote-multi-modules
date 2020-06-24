package com.delbel

import com.delbel.plugin.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
@Suppress("unused")
class ProjectModulePlugin : Plugin<Project> {

    private val plugin = KotlinPlugin()
        .appendNext(next = JavaPlugin())
        .appendNext(next = AndroidPlugin())
        .appendNext(next = ProGuardPlugin())
        .appendNext(next = ScaPlugin())
        .appendNext(next = TestPlugin())
        .appendNext(next = CoveragePlugin())
        .appendNext(next = InjectionPlugin())

    override fun apply(project: Project) = plugin.apply(project)
}
