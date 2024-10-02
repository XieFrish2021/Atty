dependencies {
    implementation(project(":atty-ext"))
    implementation(project(":atty-core"))
    implementation(project(":atty-buffer"))
}

publishing {
    repositories {
        maven(File(rootProject.rootDir, "target"))
    }

    publications {
        create<MavenPublication>("mavenJava") {
            group = rootProject.group
            version = rootProject.version as String
            artifactId = "atty-all"

            from(components["java"])
        }
    }
}
