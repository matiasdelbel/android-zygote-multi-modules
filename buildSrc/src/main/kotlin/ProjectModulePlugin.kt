import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.*

class ProjectModulePlugin : Plugin<Project> {

    private val plugin = KotlinPlugin()
        .appendNext(next = AndroidPlugin())
        .appendNext(next = ProGuardPlugin())
        .appendNext(next = JavaPlugin())
        .appendNext(next = TestPlugin())
        .appendNext(next = CoveragePlugin())
        .appendNext(next = InjectionPlugin())

    override fun apply(project: Project) = plugin.apply(project)
}