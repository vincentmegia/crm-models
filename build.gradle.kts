plugins {
    id("java")
    id("java-library")
    id("maven-publish")
    signing
}

val releaseType = ""
println("RELEASE TYPE: " + releaseType)
group = "com.stupendousware.crm.models"
version = "1.4.0." + releaseType

repositories {
    mavenCentral()
}

dependencies {
//    implementation("com.fasterxml.jackson.core:jackson-core:2.18.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.3")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "crm-models"
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name = "Crm Models"
                description = "Stupendousware CRM Models"
                url = "http://www.stupendousware.com/crm/models"
                developers {
                    developer {
                        id = "vincentmegia"
                        name = "Vincent Megia"
                        email = "vincent.megia@stupendousware.com"
                    }
                }
            }
        }
    }
    repositories {
        maven {
            name = "snapshotRepository"
            url = uri(layout.buildDirectory.dir("repos/snapshots"))
        }
        maven {
            if (version.toString().endsWith("SNAPSHOT")) {
                name = "snapshotRepository"
                url = uri("https://nexus.stupendousware.com/repository/maven-snapshots/")
                credentials {
                    username = "admin"
                    password = "123"
                }
            } else {
                name = "releaseRepository"
                url = uri("https://nexus.stupendousware.com/repository/maven-releases/")
                credentials {
                    username = "admin"
                    password = "123"
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
tasks.test {
    useJUnitPlatform()
}