plugins {
    id("org.graalvm.buildtools.native") version "0.9.16"
}

graalvmNative {
    binaries {
        named("main") {
            javaLauncher.set(javaToolchains.launcherFor {
                imageName.set("app")
                mainClass.set("HelloWorld")
            })
        }
    }
}

