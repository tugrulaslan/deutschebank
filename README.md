# Getting Started

## Technical Requirements
The following setup must exist in the development environment in order for execution and testing.
- Java 17
- Gradle 3

The nix systems have gradle as gradlew, the binary executable may be different for other OSes.
This project has been formed in a Mac OS.

## Signal Implementation
Each signal is unique and mapped by Signal enum. Whenever a new number of Signal is required to be implemented,
it is a seamless process to do so by:
1. Adding a new value in Signal enum under the package com.deutschebank.tradingapplication.dto
2. Create a new class that extends the AbstractSignalProcessor under the package com.deutschebank.tradingapplication.service.signalprocessor

## Running the Project
in the command line issue the following command.
```bash
./gradlew bootRun
```

## Running the Tests
The project has sufficient tests to cover all the functionality. 
Tests are located underneath src/test/java which can be fun from the preferred IDE or the command line

```bash
./gradlew clean test
```

## Project Information
The project is responsible for receiving signals via REST endpoint, process by the signal category
and delegate it to a down stream external party.