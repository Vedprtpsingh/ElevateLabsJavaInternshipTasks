# Java Console Calculator - Task 1

## Overview
This is a simple console-based calculator application built with Java that performs basic arithmetic operations. The calculator provides a user-friendly command-line interface for performing mathematical calculations.

## Features
- **Addition**: Add two numbers
- **Subtraction**: Subtract one number from another
- **Multiplication**: Multiply two numbers
- **Division**: Divide one number by another (with zero-division handling)
- **User-friendly interface**: Clear prompts and error messages
- **Input validation**: Handles invalid inputs gracefully
- **Continuous operation**: Perform multiple calculations until user chooses to exit

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

## How to Run

### Compilation
```bash
javac Calculator.java
```

### Execution
```bash
java Calculator
```

## Usage Example
```
=== Java Console Calculator ===
1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit
Enter your choice (1-5): 1
Enter first number: 15
Enter second number: 25
Result: 15.0 + 25.0 = 40.0
```

## Code Structure
- **Calculator.java**: Main calculator class containing all functionality
- **Methods**:
  - `displayMenu()`: Shows operation options
  - `performCalculation()`: Executes selected operation
  - `getNumberInput()`: Validates numeric input
  - `add()`, `subtract()`, `multiply()`, `divide()`: Arithmetic operations

## Error Handling
- Invalid menu choices are handled gracefully
- Non-numeric inputs are rejected with clear error messages
- Division by zero is prevented with appropriate feedback

## Learning Objectives
- Practice Java fundamentals (variables, methods, loops)
- Implement switch-case statements for menu navigation
- Handle user input and validation
- Understand exception handling basics
- Create a complete, runnable Java application

## Extension Ideas
- Add more operations (power, square root, modulus)
- Implement memory functions (store/recall)
- Add support for decimal precision control
- Create a history of calculations
- Add unit conversion features

## Troubleshooting
- **"javac not recognized"**: Ensure JDK is installed and added to PATH
- **"Could not find or load main class"**: Check that you're in the correct directory when running
- **Compilation errors**: Verify Java syntax and file naming conventions

## Author
Created as part of ElevateLabs Java Internship Tasks
