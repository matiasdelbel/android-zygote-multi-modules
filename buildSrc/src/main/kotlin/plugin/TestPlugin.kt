package plugin

import deps.InstrumentationTest
import deps.UnitTest
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class TestPlugin : ModulePlugin {

    companion object {
        private const val UNIT_TEST_IMPLEMENTATION = "testImplementation"
        private const val INSTRUMENTATION_TEST_IMPLEMENTATION = "androidTestImplementation"
    }

    override fun apply(target: Project) {
        target.dependencies {
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