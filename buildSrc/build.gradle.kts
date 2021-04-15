plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    jcenter()
    maven("https://plugins.gradle.org/m2/") // Needed for deteckt
}

sourceSets["main"].java.srcDirs("src/main/kotlin-ext", "src/main/kotlin")

gradlePlugin {
    plugins.register(CustomPlugin.PLUGIN_NAME) {
        id = CustomPlugin.PLUGIN_NAME
        implementationClass = CustomPlugin.PLUGIN_IMPLEMENTATION_CLASS
    }
}

dependencies {
    compileOnly(gradleApi())
    implementation(kotlin(Dependencies.GRADLE_PLUGIN))
    implementation(Dependencies.ANDROID_GRADLE_PLUGIN)
    implementation(Dependencies.JACOCO_PLUGIN)
    implementation(Dependencies.HILT_PLUGIN)
    implementation(Dependencies.SAFE_NAV_PLUGIN)
    implementation(Dependencies.K_LINT_PLUGIN)
    implementation(Dependencies.DETECKT_PLUGIN)
}

object Dependencies {
    const val GRADLE_PLUGIN = "gradle-plugin"
    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:4.1.2"
    const val JACOCO_PLUGIN = "org.jacoco:org.jacoco.core:0.8.5"
    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.33-beta"
    const val SAFE_NAV_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5"
    const val K_LINT_PLUGIN = "org.jlleitschuh.gradle:ktlint-gradle:9.2.1"
    const val DETECKT_PLUGIN = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.10.0-RC1"
}

object CustomPlugin {
    const val PLUGIN_NAME = "com.delbel.android.library"
    const val PLUGIN_IMPLEMENTATION_CLASS = "com.delbel.ProjectModulePlugin"
}