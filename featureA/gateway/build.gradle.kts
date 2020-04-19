plugins {
    id("com.android.library")
    id("project-module-plugin")
}

dependencies {
    implementation(project(path = ":featureA:domain"))
}