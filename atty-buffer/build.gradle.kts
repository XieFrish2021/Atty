publishing {
    repositories {
        maven(File(rootProject.rootDir, "target"))
    }

    publications {
        create<MavenPublication>("mavenJava") {
            group = rootProject.group
            version = rootProject.version as String
            artifactId = "atty-buffer"

            from(components["java"])
        }
    }
}
