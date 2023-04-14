plugins {
	id("com.android.application") version "8.0.0"
	id("net.twisterrob.gradle.plugin.quality") version "0.15.1"
}

android {
	compileSdk = 33
	defaultConfig {
		minSdk = 14
		targetSdk = 33

		namespace = "net.twisterrob.quality.examples.release"
		versionCode = 1
		versionName = "1.0"
	}
}
