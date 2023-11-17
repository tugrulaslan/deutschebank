plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.deutschebank"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
	testLogging {
		showCauses = false
		showExceptions = false
		showStackTraces = false
		showStandardStreams = false

		val ansiReset = "\u001B[0m"
		val ansiGreen = "\u001B[32m"
		val ansiRed = "\u001B[31m"
		val ansiYellow = "\u001B[33m"

		fun getColoredResultType(resultType: TestResult.ResultType): String {
			return when (resultType) {
				TestResult.ResultType.SUCCESS -> "$ansiGreen $resultType $ansiReset"
				TestResult.ResultType.FAILURE -> "$ansiRed $resultType $ansiReset"
				TestResult.ResultType.SKIPPED -> "$ansiYellow $resultType $ansiReset"
			}
		}

		afterTest(
			KotlinClosure2({ desc: TestDescriptor, result: TestResult ->
				println("${desc.className} | ${desc.displayName} = ${getColoredResultType(result.resultType)}")
			})
		)

		afterSuite(
			KotlinClosure2({ desc: TestDescriptor, result: TestResult ->
				if (desc.parent == null) {
					println("Result: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} passed, ${result.failedTestCount} failed, ${result.skippedTestCount} skipped)")
				}
			})
		)
	}
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}