plugins {
    id("com.android.library")
    id("project-module-plugin")
}

android { viewBinding { isEnabled = true } }

dependencies {
    implementation(project(path = ":featureA:domain"))
}