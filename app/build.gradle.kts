import com.delbel.Presentation

plugins {
    id("com.android.application")
    id("project-module-plugin")
}

android {
    // TODO - set up applicationId
    defaultConfig.applicationId = "com.delbel.zygote.testapp"

    buildFeatures.viewBinding = true
}

dependencies {
    implementation(Presentation.appCompat)
    implementation(Presentation.material)
}
