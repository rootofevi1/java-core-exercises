plugins { base }

subprojects {
    apply(plugin = "application")
    extensions.configure<JavaPluginExtension> {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }
    extensions.configure<JavaApplication> {
        mainClass.set(if (project.name == "exercise1") "exercise1.Main" else "exercise.Main")
    }
    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }
    tasks.named<JavaExec>("run") {
        standardInput = System.`in`
        workingDir = projectDir
    }
}

tasks.named("build") { dependsOn(subprojects.map { "${it.path}:build" }) }
tasks.named("clean") { dependsOn(subprojects.map { "${it.path}:clean" }) }
