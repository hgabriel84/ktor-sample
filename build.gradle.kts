import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val kodein_version: String by project
val hikari_version: String by project
val postgresql_version: String by project

plugins {
    application
    kotlin("jvm") version "1.4.21"
}

group = "com.hgabriel"
version = "0.0.1"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version") // kotlin
    implementation("io.ktor:ktor-server-netty:$ktor_version") // netty server
    implementation("io.ktor:ktor-server-core:$ktor_version") // ktor server
    implementation("io.ktor:ktor-gson:$ktor_version") // JSON serialize / deserialize
    implementation("ch.qos.logback:logback-classic:$logback_version") // logging

    // ORM
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    implementation("org.kodein.di:kodein-di-framework-ktor-server-jvm:$kodein_version") // DI
    implementation("com.zaxxer:HikariCP:$hikari_version") // JDBC Connection Pool
    implementation("org.postgresql:postgresql:$postgresql_version") // JDBC Connector for PostgreSQL

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}