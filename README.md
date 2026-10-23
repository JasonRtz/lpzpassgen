# LPZ Password Generator

A simple desktop password generator built with Java and JavaFX.

## Overview

LPZ Password Generator allows users to generate randomized passwords with customizable lengths and character types.

The application uses Java's `SecureRandom` class for cryptographically secure random number generation.

## Features

- Generate passwords between 12 and 100 characters.
- Choose between letters, numbers, and special characters.
- Combine multiple character types.
- Include at least one character from each selected category.
- Copy generated passwords to the clipboard.
- Input validation with warning messages.
- Simple JavaFX graphical interface.

## Screenshot

![LPZ Password Generator](https://github.com/user-attachments/assets/8d0c12dd-1d85-4b4b-9b7c-c351038f5a3c)

## Technologies

- Java 25
- JavaFX 25
- Maven
- JUnit 5

## Getting Started

### Requirements

- JDK 25
- Git

### Installation

Clone the repository:

```bash
git clone https://github.com/JasonRtz/lpzpassgen.git
cd lpzpassgen
```

### Running the Application

On Windows:

```powershell
.\mvnw.cmd clean javafx:run
```

Alternatively, open the project in IntelliJ IDEA and run the `App` class.

## Running Tests

Execute the automated tests using Maven:

```powershell
.\mvnw.cmd test
```

The tests verify password length validation and correct password generation.

## Security Notes

- Passwords are generated using Java's `SecureRandom`.
- The application does not store generated passwords.
- Password strength depends on the selected length and character types.

For stronger passwords, select multiple character categories and use longer lengths.
