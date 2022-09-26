import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.exclude
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
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

configurations{
	all {
		exclude(group = "*", module = "spring-boot-starter-logging")
		exclude(group = "*", module = "ch.qos.*")

	}
//	implementation {
//		resolutionStrategy.failOnVersionConflict()
//	},

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

	// https://mvnrepository.com/artifact/org.hibernate/hibernate-spatial
	implementation("org.hibernate:hibernate-spatial:6.1.3.Final")
	implementation("com.h2database:h2:2.1.214")
	implementation("org.postgresql:postgresql:42.5.0")
	implementation("net.postgis:postgis-jdbc:2021.1.0")
	implementation("org.orbisgis.data:h2gis:2.0.0")

	//https://github.com/data2viz/geojson-kotlin
	implementation("io.data2viz.geojson:core:0.6.4")

	implementation("io.github.dellisd.spatialk:geojson:0.2.1")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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
