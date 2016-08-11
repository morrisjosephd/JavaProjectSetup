# Thursdays with RJ

#### Required Tools
IntelliJ
JVM - java virtual machine
JDK - java developer kit
SKDMAN - package manager
* $ sdk install package version
Gradle - build tool (Ant, maven, gulp, grunt)

#### Create a project
1.  gradle init
1.  ./gradlew tasks (see available gradle tasks)
1.  update build.gradle wit this build script

`build.gradle`
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.0.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'spring-boot'

repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    // tag::jetty[]
    compile("org.springframework.boot:spring-boot-starter-web") {
        exclude module: "spring-boot-starter-tomcat"
    }
    compile("org.springframework.boot:spring-boot-starter-jetty")
    // end::jetty[]
    // tag::actuator[]
    compile("org.springframework.boot:spring-boot-starter-actuator")
    // end::actuator[]
    testCompile("junit:junit")
}
```
