group = "io.atty"
version = "1.0.0-SNAPSHOT"

allprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
    }

    tasks.withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }

    tasks.getByPath("clean").doLast {
        delete(File(rootDir, "target"))
    }
}
