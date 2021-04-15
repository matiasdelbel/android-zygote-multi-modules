package com.delbel

object Kotlin {
    const val stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.32"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3"
}

object Injection {
    const val hilt = "com.google.dagger:hilt-android:2.28-alpha"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"

    const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val viewModelCompiler = "androidx.hilt:hilt-compiler:1.0.0-alpha03"
}

object Navigation {
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.5"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.3.5"
}

object Presentation {
    const val appCompat = "androidx.appcompat:appcompat:1.3.0-rc01"

    const val fragment = "androidx.fragment:fragment-ktx:1.3.2"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"

    const val material = "com.google.android.material:material:1.3.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0"
}

sealed class Test {
    val truth = "androidx.test.ext:truth:1.3.0"
    val core = "androidx.arch.core:core-testing:2.1.0"
}

object UnitTest : Test() {
    const val junit4 = "junit:junit:4.12"
    const val mockitoKtx = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.3"
}

object InstrumentationTest : Test() {
    const val runner = "androidx.test:runner:1.2.0"
    const val rules = "androidx.test:rules:1.2.0"
}
