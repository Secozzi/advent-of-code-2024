plugins {
    kotlin("jvm") version "2.1.0"
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xmulti-dollar-interpolation")
    }
}

dependencies {
    implementation("com.michael-bull.kotlin-itertools:kotlin-itertools:1.0.0")
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.11.1"
    }
}
