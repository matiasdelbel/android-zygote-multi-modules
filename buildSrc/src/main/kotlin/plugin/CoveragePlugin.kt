package plugin

import com.android.build.gradle.*
import com.android.build.gradle.api.BaseVariant
import org.gradle.api.DomainObjectSet
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.tasks.JacocoReport

internal class CoveragePlugin : ModulePlugin {

    companion object {
        private const val EXTENSION_ANDROID = "android"
        private const val COVERAGE = "coverage"

        private const val VERSION_DEBUG = "debug"

        private const val SOURCE_DIR = "src/main/kotlin/"
    }

    override fun apply(target: Project) {
        target.extensions.create<CoverageExtension>(COVERAGE)

        applyJacocoPlugin(target)
        enableCoverageOnDebug(target)
    }

    private fun applyJacocoPlugin(target: Project) = target.afterEvaluate {
        val coverageExtension = target.extensions.getByType(CoverageExtension::class.java)
        if (!coverageExtension.isEnabled) return@afterEvaluate

        target.plugins.apply(JacocoPlugin::class.java)
        target.plugins.all {
            if (this is LibraryPlugin) configureLibraryPlugin(target, coverageExtension.excludes)
            else if (this is AppPlugin) configureAppPlugin(target, coverageExtension.excludes)
        }
    }

    private fun configureLibraryPlugin(project: Project, excludes: List<String>) {
        val libraryExtension = project.extensions.getByType(LibraryExtension::class.java)
        configureJacoco(project, libraryExtension.libraryVariants, excludes)
    }

    private fun configureAppPlugin(project: Project, excludes: List<String>) {
        val appExtension = project.extensions.getByType(AppExtension::class.java)
        configureJacoco(project, appExtension.applicationVariants, excludes)
    }

    private fun configureJacoco(
        project: Project,
        variants: DomainObjectSet<out BaseVariant>,
        excludes: List<String>
    ) = variants.all {
        if (!buildType.isDebuggable) return@all

        val dir = project.buildDir
        val variantName = name
        val variantNameCapitalize = name.capitalize()

        project.tasks.register<JacocoReport>("jacoco${variantNameCapitalize}Report") {
            dependsOn(project.tasks["test${variantNameCapitalize}UnitTest"])

            executionData.setFrom(project.fileTree("$dir") {
                setIncludes(listOf("jacoco/test${variantNameCapitalize}UnitTest.exec"))
            })
            setOnlyIf { executionData.files.any { it.exists() } }

            classDirectories.setFrom(
                project.fileTree("${dir}/intermediates/javac/$variantName") { setExcludes(excludes) },
                project.fileTree("${dir}/tmp/kotlin-classes/$variantName") { setExcludes(excludes) }
            )
            sourceDirectories.setFrom(SOURCE_DIR)
            additionalSourceDirs.setFrom(SOURCE_DIR)
            group = COVERAGE

            reports.xml.isEnabled = true
        }
    }

    private fun enableCoverageOnDebug(target: Project) {
        val androidExtension = target.extensions.getByName(EXTENSION_ANDROID)
        if (androidExtension !is BaseExtension) return

        androidExtension.buildTypes { getByName(VERSION_DEBUG) { isTestCoverageEnabled = true } }
    }
}

open class CoverageExtension {

    open var isEnabled: Boolean = true

    open var excludes: ArrayList<String> = arrayListOf()

    open fun excludes(vararg excludes: String) = this.excludes.addAll(excludes)
}