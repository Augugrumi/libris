# libris - Reverse Image Search Library
Java library for reverse image search.
This library gives the possibility to use Google, Azure, Watson and Imagga image recognition services to perform reverse image search and optical character recognition (OCR).

## Continuous Integration
Travis-CI is used to perform builds on every commit. The library is tested against:
- openjdk7
- oraclejdk8
- oraclejdk7

| Branch | Build Status |
| ------ | -------------|
| Master | [![Build Status](https://travis-ci.org/Augugrumi/libris.svg?branch=master)](https://travis-ci.org/Augugrumi/libris) |
| Dev    | [![Build Status](https://travis-ci.org/Augugrumi/libris.svg?branch=dev)](https://travis-ci.org/Augugrumi/libris)    |

## Compilation
This project uses _Maven_ as dependency manager. On the project root in order to compile you need to type:
```
mvn compile
```
N.B.: `libris` needs at least Java v7! Previous versions won't work.

## Testing
To run the unit tests:
```
mvn test
```
Please note that you need valid keys to perform some of the unit-tests (currently for Azure, Watson, Imagga).

## Install the .jar
To install the jar you need to give this command:
```
mvn install
```
## Setup
It's very easy to import libris in your project! Just follow these instruction..
### Manven
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
### Grandle
Gradle configuration:
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.Augugrumi:libris:v1.0.0'
}
```

## License

This library is licensed under GNU LGPLv3. Credit goes to Davide Polonio, Marco Zanella and Federico Tavella.
