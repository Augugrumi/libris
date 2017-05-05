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
| Master | [![Build Status](https://travis-ci.com/Polpetta/libris.svg?token=ci1gnGXmpJTvBk4nzckq&branch=master)](https://travis-ci.com/Polpetta/libris) |
| Dev    | [![Build Status](https://travis-ci.com/Polpetta/libris.svg?token=ci1gnGXmpJTvBk4nzckq&branch=dev)](https://travis-ci.com/Polpetta/libris)    |

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

## License

This library is licensed under GNU LGPLv3. Credit goes to Davide Polonio and Marco Zanella.
