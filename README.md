# libris - Reverse Image Search Library
Java library for reverse image search.
This library gives the possibility to use Google and Clarifai image services to perform reverse image search.

## Continuous Integration
Travis-CI is used to perform builds on every commit. The library is tested against:
- openjdk7
- oraclejdk8
- oraclejdk7

| Branch | Build Status |
| ------ | -------------|
| Master | [![Build Status](https://travis-ci.org/Polpetta/libris.svg?branch=master)](https://travis-ci.org/Polpetta/libris) |
| Dev    | [![Build Status](https://travis-ci.org/Polpetta/libris.svg?branch=dev)](https://travis-ci.org/Polpetta/libris)    |

## Compilation
This project uses _Maven_ to build the project. In the project root in order to compile type:
```
mvn compile
```
N.B.: `libris` needs at least Java v7 in order to compile! Previous versions won't work.

## Testing
To run the unit tests:
```
mvn test
```

## Install the .jar
To install the jar you need to give this command:
```
mvn install
```
## Setup

Maven configuration:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.Polpetta</groupId>
    <artifactId>libris</artifactId>
    <version>v1.0.0</version>
</dependency>
```

Gradle configuration:
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.Polpetta:libris:v1.0.0'
}
```

## License

This library is licensed under GNU LGPLv3. Credit goes to Davide Polonio and Marco Zanella.
