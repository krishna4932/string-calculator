# String Calculator

A simple Kotlin application that provides a string calculator with various functionalities:

- Sum of numbers separated by commas or new lines.
- Custom delimiters.
- Ignores numbers greater than 1000.
- Throws exceptions for negative numbers.

## Requirements

- **Java Version:** 17

## Setup

### 1. Clone the Repository

Clone the repository to your local machine:

```sh
git clone https://github.com/krishna4932/string-calculator.git
cd string-calculator
```

### 2. Setup Java
Ensure you have Java 17 installed. You can check your Java version with:
```sh
java -version
```

### 3. [_Optional_] Build the Project
You can build the project using Gradle with the following command:

```sh
./gradlew build
```

### 4. Run the Application - it will run the `Main` Function
To run the application, use:

```sh
./gradlew run
```
### 5. Run Tests
To run the unit tests, use:

```sh
./gradlew test
```

### [_Info_] 6. Project Structure
The project structure:
```
string-calculator/
│
├── src/
│   ├── main/
│   │   └── kotlin/
│   │       └── Main.kt
│   │       └── StringCalculator.kt
│   │           
│   └── test/
│       └── kotlin/
│           └── StringCalculatorTest.kt
│
├── build.gradle
├── settings.gradle
└── README.md
```

### [_Info_] 7. Example Usage
Here's an example of how you might use the StringCalculator class in this Kotlin application:

```kotlin
fun main() {
    val calculator = StringCalculator()
    println(calculator.add("1,2,3")) // Output: 6
    println(calculator.add("1\n2,3")) // Output: 6
}
```