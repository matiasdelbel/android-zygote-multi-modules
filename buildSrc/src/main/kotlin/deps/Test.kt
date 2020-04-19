package deps

sealed class Test {

    val truth = "com.google.truth:truth:1.0"
    val core = "android.arch.core:core-testing:1.1.1"
}

object UnitTest : Test() {

    const val junit4 = "junit:junit:4.12"
    const val mockitoKtx = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
}

object InstrumentationTest : Test() {

    const val runner = "androidx.test:runner:1.2.0"
    const val rules = "androidx.test:rules:1.2.0"
}