import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.coverage(configuration: plugin.CoverageExtension.() -> Unit) = configure(configuration)