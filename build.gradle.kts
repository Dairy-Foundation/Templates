plugins {
    id("dev.frozenmilk.android-library") version "11.0.0-1.1.0"
    id("dev.frozenmilk.publish") version "0.0.5"
    id("dev.frozenmilk.doc") version "0.0.5"
    id("dev.frozenmilk.build-meta-data") version "0.0.2"
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

meta {
    // TODO: modify
    packagePath = "com.example"
    // TODO: modify
    name = "Library"
    // TODO: modify
    registerField("name", "String", "\"com.example.Library\"")
    registerField("clean", "Boolean") { "${dairyPublishing.clean}" }
    registerField("gitRef", "String") { "\"${dairyPublishing.gitRef}\"" }
    registerField("snapshot", "Boolean") { "${dairyPublishing.snapshot}" }
    registerField("version", "String") { "\"${dairyPublishing.version}\"" }
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
