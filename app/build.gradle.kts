plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.yelloyew.tcl.sleep"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.yelloyew.tcl.sleep"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {}
