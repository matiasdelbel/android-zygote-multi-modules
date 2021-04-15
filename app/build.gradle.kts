import com.delbel.Injection
import com.delbel.InstrumentationTest
import com.delbel.Kotlin
import com.delbel.Navigation
import com.delbel.Presentation
import com.delbel.UnitTest

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
    implementation(Kotlin.stdlibJdk7)
    implementation(Kotlin.coroutines)

    implementation(Injection.hilt)
    kapt(Injection.hiltCompiler)

    implementation(Navigation.navigationFragment)
    implementation(Navigation.navigationUi)

    implementation(Presentation.appCompat)
    implementation(Presentation.material)

    testImplementation(UnitTest.junit4)
    testImplementation(UnitTest.mockitoKtx)
    testImplementation(UnitTest.truth)

    androidTestImplementation(InstrumentationTest.runner)
    androidTestImplementation(InstrumentationTest.rules)
    androidTestImplementation(InstrumentationTest.core)
    androidTestImplementation(InstrumentationTest.truth)
}
