import deps.Injection
import deps.Presentation

plugins {
    id("com.android.application")
    id("project-module-plugin")
}

android {

    defaultConfig.applicationId = "com.delbel.zygote.testapp"

    viewBinding { isEnabled = true }
}

dependencies {
    implementation(project(path = ":featureA:domain"))
    implementation(project(path = ":featureA:gateway"))
    implementation(project(path = ":featureA:presentation"))

    implementation(Injection.dagger)
    implementation(Injection.daggerSupport)
    kapt(Injection.daggerProcessor)
    kapt(Injection.daggerCompiler)

    implementation(Presentation.appCompat)
    implementation(Presentation.material)
}