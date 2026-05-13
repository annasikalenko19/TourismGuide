# Tourism Guide

Tourism Guide is a JavaFX desktop application for planning trips across Ukraine. The app lets a user sign up or log in, choose a starting city and a tourist destination, select useful stops for the road, and view the generated route on an interactive map.

## Features

- User registration and login.
- Destination selection from Ukrainian tourist places.
- Route visualization on a map of Ukraine.
- Optional road stops:
  - cafes;
  - hotels;
  - gas stations;
  - emergency rooms.
- Animated trip marker that moves along the selected route.
- Basic admin classes for managing station data.

## Tech Stack

- Java 18
- JavaFX 18
- Maven
- FXML
- Serialized local user storage (`users.bin`)

## Project Structure

```text
src/main/java/com/example/oop
|-- HelloApplication.java          # JavaFX application entry point
|-- GUI                            # JavaFX controllers and map UI
|-- logic
|   |-- database                   # User storage utilities
|   |-- exception                  # Custom exceptions
|   |-- map                        # Graph, path and station logic
|   `-- user                       # User and admin domain classes
`-- module-info.java

src/main/resources
|-- com/example/oop                # FXML screens
|-- images                         # Map and station images
|-- style                          # CSS styles
|-- centers.txt                    # City coordinates
`-- destinations.txt               # Destination coordinates
```

## How to Run

Make sure Java 18 and Maven are installed.

```bash
mvn clean javafx:run
```

If you prefer using the Maven wrapper and the wrapper files are present:

```bash
./mvnw clean javafx:run
```

## Notes

- The application starts from `com.example.oop.HelloApplication`.
- User accounts are stored locally in `src/main/resources/users.bin`. This file is ignored by git because it contains local application data.
- The project contains optional MySQL-related code in `Utils`. Database connection values can be provided through `TOURISM_DB_URL`, `TOURISM_DB_USER`, and `TOURISM_DB_PASSWORD`.
- The route graph and available destinations are defined in the Java code and resource files.
