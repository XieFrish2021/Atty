dependencies {
    implementation(project(":atty-buffer"))
    implementation("org.apache.mina:mina-core:2.2.3")
    implementation("org.slf4j:slf4j-simple:1.7.26")
}

publishing {
    repositories {
        maven(File(rootProject.rootDir, "target"))
    }

    publications {
        create<MavenPublication>("mavenJava") {
            group = rootProject.group
            version = rootProject.version as String
            artifactId = "atty-core"

            from(components["java"])
        }
    }
}
