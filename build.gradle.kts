import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"

}

group = "io.github.ritter4u"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    //https://github.com/data2viz/geojson-kotlin
    maven { url = uri("https://maven.pkg.jetbrains.space/data2viz/p/maven/public") }
}

configurations {
    all {
        exclude(group = "*", module = "spring-boot-starter-logging")
        exclude(group = "*", module = "ch.qos.*")

    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")

    // https://mvnrepository.com/artifact/com.bedatadriven/jackson-datatype-jts
    implementation("org.locationtech.jts:jts-core:1.19.0")

    // https://mvnrepository.com/artifact/org.hibernate/hibernate-spatial
    implementation("org.hibernate:hibernate-spatial:5.4.28.Final")
    implementation("net.postgis:postgis-jdbc:2021.1.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

noArg {
    annotation("javax.persistence.Entity")
}
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
