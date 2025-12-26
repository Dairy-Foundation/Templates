plugins {
    id("dev.frozenmilk.android-library") version "11.0.0-1.0.0"
    id("dev.frozenmilk.publish") version "0.0.5"
    id("dev.frozenmilk.doc") version "0.0.5"
}

// TODO: modify
android.namespace = "com.example.library"

ftc {
    // adds support for kotlin
    kotlin()

    sdk {
        // adds the most common ftc library dependencies,
        // you may need more
        compileOnly(FtcCommon)
        testImplementation(FtcCommon)

        compileOnly(RobotCore)
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            // TODO: modify
            groupId = "com.example"
            // TODO: modify
            artifactId = "Library"

            artifact(dairyDoc.dokkaHtmlJar)
            artifact(dairyDoc.dokkaJavadocJar)

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
