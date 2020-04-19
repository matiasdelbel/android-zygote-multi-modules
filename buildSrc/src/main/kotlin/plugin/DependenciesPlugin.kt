package plugin

import deps.Core
import deps.InstrumentationTest
import deps.UnitTest
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class DependenciesPlugin : ModulePlugin {

    companion object {
        private const val IMPLEMENTATION = "implementation"
        private const val UNIT_TEST_IMPLEMENTATION = "testImplementation"
        private const val INSTRUMENTATION_TEST_IMPLEMENTATION = "androidTestImplementation"
    }

    override fun apply(target: Project) {
        target.dependencies {
            add(IMPLEMENTATION, Core.stdlibJdk7)

            add(UNIT_TEST_IMPLEMENTATION, UnitTest.junit4)
            add(UNIT_TEST_IMPLEMENTATION, UnitTest.mockitoKtx)
            add(UNIT_TEST_IMPLEMENTATION, UnitTest.truth)

            add(INSTRUMENTATION_TEST_IMPLEMENTATION, InstrumentationTest.runner)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, InstrumentationTest.rules)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, InstrumentationTest.core)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, InstrumentationTest.truth)
        }
    }
}