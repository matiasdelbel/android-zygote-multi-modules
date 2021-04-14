import com.delbel.Navigation
import com.delbel.Presentation

plugins {
    id("com.android.application")
    id("com.delbel.android.library")
}

android {
    // TODO - set up applicationId
    defaultConfig.applicationId = "com.delbel.zygote.testapp"

    buildFeatures.viewBinding = true
}

dependencies {
    implementation(Navigation.navigationFragment)
    implementation(Navigation.navigationUi)

    implementation(Presentation.appCompat)
    implementation(Presentation.material)
}
