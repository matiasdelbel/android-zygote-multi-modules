plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("com.delbel.android.library") {
            id = "com.delbel.android.library"
            implementationClass = "com.delbel.ProjectModulePlugin"
        }
    }
}

repositories {
    google()
    jcenter()

    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:4.0.1")

    implementation(kotlin("gradle-plugin", "1.3.61"))

    implementation("org.jacoco:org.jacoco.core:0.8.5")

    implementation("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")

    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")

    implementation("org.jlleitschuh.gradle:ktlint-gradle:9.2.1")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.10.0-RC1")
}

sourceSets {
    this["main"].java.srcDirs("src/main/kotlin-ext", "src/main/kotlin")
}