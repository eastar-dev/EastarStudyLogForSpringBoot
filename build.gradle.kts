import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.0.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "dev.eastar"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	//implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("com.google.firebase:firebase-admin:6.13.0")

	implementation("com.squareup.okhttp3:okhttp:4.7.2")


		//compile group: 'com.squareup.retrofit2', name: 'retrofit', version: '2.3.0'
		//compile group: 'com.squareup.retrofit2', name: 'converter-jackson', version: '2.3.0'
		//compile group: 'com.fasterxml.jackson.datatype', name: 'jackson-datatype-jsr310', version: '2.9.3'
		//provided group: 'org.projectlombok', name: 'lombok', version: '1.16.20'
		//testCompile('org.springframework.boot:spring-boot-starter-test')



	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	//testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
