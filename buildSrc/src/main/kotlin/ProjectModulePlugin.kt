import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.AndroidPlugin
import plugin.TestPlugin
import plugin.JavaPlugin
import plugin.KotlinPlugin
import plugin.ProGuardPlugin

class ProjectModulePlugin : Plugin<Project> {

    private val plugin = KotlinPlugin()
        .appendNext(next = AndroidPlugin())
        .appendNext(next = ProGuardPlugin())
        .appendNext(next = JavaPlugin())
        .appendNext(next = TestPlugin())

    override fun apply(project: Project) = plugin.apply(project)
}