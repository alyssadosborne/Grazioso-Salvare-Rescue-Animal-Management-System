# Grazioso Salvare Rescue Animal Management System

A Java console application for tracking rescue animals and managing their availability for service. Users can register dogs and monkeys, view animal records, and reserve eligible animals by type and service country.

Developed as an academic programming project at Southern New Hampshire University (SNHU).

## Features

- **Animal intake:** Add new dogs and monkeys with identifying details, training status, and reservation status.
- **Object-oriented design:** Store common animal attributes in the `RescueAnimal` parent class; `Dog` and `Monkey` extend it with their own attributes.
- **Animal records:** Maintain separate in-memory `ArrayList` collections for dogs and monkeys.
- **Reservations:** Reserve the first matching animal that is trained (`in service`), not already reserved, and assigned to the requested country.
- **Availability reports:** List dogs, monkeys, or all currently available in-service animals.
- **Basic validation:** Reject duplicate names within each animal type, unsupported monkey species, nonnumeric monkey measurements, and invalid menu options.

## Technologies and concepts

- Java
- Object-oriented programming (inheritance, encapsulation, constructors, getters, and setters)
- `ArrayList` collections
- `Scanner` for console input
- Loops, conditional logic, and methods

## Project structure

```text
Grazioso-Salvare/
├── grazioso/
│   ├── RescueAnimal.java    # Shared animal fields and accessors
│   ├── Dog.java             # Dog-specific breed information
│   ├── Monkey.java          # Monkey species and measurements
│   └── Driver.java          # Menu, intake, reservation and reports
├── .gitignore
└── README.md
```

## How to run

Requires a Java Development Kit (JDK). From the repository root, compile the source files into an output folder:

```bash
javac -d out grazioso/RescueAnimal.java grazioso/Dog.java grazioso/Monkey.java grazioso/Driver.java
```

Run the program:

```bash
java -cp out grazioso.Driver
```

## Menu

```text
Rescue Animal System Menu
[1] Intake a new dog
[2] Intake a new monkey
[3] Reserve an animal
[4] Print a list of all dogs
[5] Print a list of all monkeys
[6] Print all in-service animals that are not reserved
[q] Quit application
```

### Example workflow

1. Run the application to load its sample animal records.
2. Choose `5` to display the monkey records.
3. Choose `3`, enter `monkey`, and enter `India` as the service country to reserve an eligible sample animal.
4. Choose `6` to review the remaining animals that are in service and not reserved.
5. Choose `q` to exit.

> **Note:** The current version stores records in memory. Changes do not persist after the application closes.

## What I learned

This project provided practice designing related Java classes through inheritance, storing objects in collections, accepting console input, and applying business rules to animal intake and reservation workflows. It also highlighted the importance of keeping method signatures and data types consistent across classes.

## Possible improvements

- Save animal records to a file or database so changes persist between sessions.
- Expand validation of dates, numeric fields, and reservation input.
- Introduce automated tests for animal intake and reservation rules.
- Add a graphical user interface.

## Author

Alyssa Osborne
