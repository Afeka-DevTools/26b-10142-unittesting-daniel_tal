# Java Unit Testing Project

## Team Members

- **Daniel Krichevsky**
- **Tal Kliot**

---

## Project Overview

This project demonstrates comprehensive unit testing practices in Java, focusing on identifying and implementing edge case tests for utility methods. The project includes a utility class (`App.java`) with 11 different methods covering mathematical operations, string manipulations, and data processing algorithms.

The primary goal is to create a robust test suite that covers not only happy-path scenarios but also edge cases, error conditions, boundary values, and null safety considerations.

---

## Project Objectives

✅ **Comprehensive Test Coverage** — Test all methods with extensive edge cases  
✅ **Edge Case Identification** — Systematically discover missing test scenarios  
✅ **Error Handling** — Verify behavior with invalid inputs (null, overflow, etc.)  
✅ **Best Practices** — Demonstrate JUnit 5 testing patterns and conventions  
✅ **Documentation** — Provide clear, maintainable test code with comments  

---

## Methods Tested

### Utility Methods in App.java

1. **`add(int a, int b)`** — Integer addition with overflow testing
2. **`isPrime(int n)`** — Prime number detection
3. **`reverse(String s)`** — String reversal with null safety
4. **`factorial(int n)`** — Factorial calculation with overflow handling
5. **`isPalindrome(String s)`** — Palindrome detection with character filtering
6. **`fibonacciUpTo(int n)`** — Fibonacci sequence generation up to a limit
7. **`charFrequency(String input)`** — Character frequency mapping
8. **`isAnagram(String s1, String s2)`** — Anagram detection
9. **`average(int[] arr)`** — Array average calculation
10. **`filterEvens(List<Integer> list)`** — Even number filtering
11. **`mostCommonWord(String text)`** — Most frequent word identification

---

## Test Coverage

### Test Statistics
- **Total Tests**: 82 tests
- **Test Status**: ✅ All passing
- **Test Framework**: JUnit 5
- **Build Tool**: Gradle

### Coverage Categories
- **Basic Functionality**: Happy path scenarios (41 original tests)
- **Edge Cases**: Boundary values, special conditions (41 new tests added)
- **Error Handling**: Null inputs, exceptions, overflow conditions
- **Type Handling**: Mixed types (numbers, special characters, spaces)
- **State Testing**: Empty, single, and large collections

---

## Key Features

### Comprehensive Edge Case Testing
- **Null Input Safety** — Tests for null parameters across all methods
- **Integer Overflow/Underflow** — Documents behavior at `Integer.MAX_VALUE` and `Integer.MIN_VALUE`
- **String Edge Cases** — Empty strings, special characters, whitespace, case sensitivity
- **Collection Edge Cases** — Empty lists, single elements, duplicates
- **Boundary Values** — Zero, negative, maximum, minimum values

### Well-Organized Test Structure
```java
// Tests organized by method with clear naming
@Test
void testMethodName_ScenarioDescription() {
    // Arrange
    // Act
    // Assert
}
```

### Documentation
- Clear test method names describing what is being tested
- Comments explaining expected behavior for edge cases
- `logs/LEARNING.md` — Comprehensive learning session documentation

---

## Project Structure

```
agents-java-unit-tests-explained/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/org/example/
│   │   │       └── App.java          # Utility methods to test
│   │   └── test/
│   │       └── java/org/example/
│   │           └── AppTest.java      # Comprehensive unit tests (82 tests)
│   └── build.gradle.kts              # Gradle build configuration
├── logs/
│   └── LEARNING.md                   # Detailed learning session documentation
├── README.md                          # This file
└── settings.gradle.kts                # Gradle settings
```

---

## Getting Started

### Prerequisites
- Java 11 or higher
- Gradle (included via Gradle wrapper - no separate installation needed)

### Quick Start

#### 1. Clone/Open the Project
```bash
cd agents-java-unit-tests-explained
```

#### 2. Build the Project
```bash
# On Windows
gradlew build

# On Linux/macOS
./gradlew build
```

#### 3. Run the Tests
```bash
# On Windows
gradlew test

# On Linux/macOS
./gradlew test
```

---

## Building and Running Tests

### Build the Project
```bash
./gradlew build
```

### Run All Tests
```bash
./gradlew test
```

### Run Specific Test Class
```bash
./gradlew test --tests AppTest
```

### Run Specific Test Method
```bash
./gradlew test --tests AppTest.testAddPositiveNumbers
```

### Run Tests with Verbose Output
```bash
./gradlew test --info
```

### View Test Report
After running tests, view the detailed HTML report:
```
app/build/reports/tests/test/index.html
```

Open this file in your web browser to see:
- Test summary and statistics
- Detailed results for each test class
- Pass/fail status for all 82 tests
- Execution time for each test

---

## Running from IDE

### Using VS Code / IntelliJ IDEA / Eclipse

1. **Open the project folder** in your IDE
2. **Install Java and Gradle extensions** (if using VS Code)
3. **Right-click on AppTest.java** → Select "Run Tests" or "Debug Tests"
4. **Or use the Terminal** within your IDE and run the gradle commands above

---

## Compiling and Running the Application Code

### Compile Only
```bash
./gradlew compileJava
```

### Compile Tests
```bash
./gradlew compileTestJava
```

### Using the App.java Methods

The `App.java` file contains 11 utility methods. To use them in your own code:

1. The compiled classes will be in `app/build/classes/java/main/`
2. You can import and use the methods like this:

```java
import org.example.App;

public class Main {
    public static void main(String[] args) {
        // Example: Using the methods from App.java
        int sum = App.add(5, 3);  // Returns 8
        boolean prime = App.isPrime(17);  // Returns true
        String reversed = App.reverse("hello");  // Returns "olleh"
    }
}
```

---

## Troubleshooting

### "Permission denied" error
```bash
# Make the gradle wrapper executable on Linux/macOS
chmod +x gradlew
```

### Clean and Rebuild
```bash
./gradlew clean build
```

### See All Available Gradle Tasks
```bash
./gradlew tasks
```

---

## Test Examples

### Example 1: Boundary Testing
```java
@Test
void testAddIntegerOverflow() {
    // Integer overflow: silently wraps around
    int result = App.add(Integer.MAX_VALUE, 1);
    assertEquals(Integer.MIN_VALUE, result);
}
```

### Example 2: Null Safety Testing
```java
@Test
void testReverseNull() {
    assertThrows(NullPointerException.class, () -> App.reverse(null));
}
```

### Example 3: Edge Case Testing
```java
@Test
void testFactorialIntegerOverflow() {
    // factorial(13) exceeds Integer.MAX_VALUE
    int result = App.factorial(13);
    assertNotEquals(App.factorial(12), result);
}
```

### Example 4: Multiple Conditions Testing
```java
@Test
void testIsAnagramNull() {
    assertThrows(NullPointerException.class, () -> App.isAnagram(null, "test"));
    assertThrows(NullPointerException.class, () -> App.isAnagram("test", null));
}
```

---

## Learning Outcomes

This project demonstrates:

1. **Systematic Edge Case Identification** — How to find gaps in test coverage
2. **Null Safety** — Importance of testing null inputs and null handling
3. **Boundary Value Analysis** — Testing at limits and edges of ranges
4. **JUnit 5 Best Practices** — Proper assertion usage and test organization
5. **Test-Driven Quality** — How comprehensive tests improve code reliability
6. **Exception Testing** — Verifying expected exceptions are thrown correctly

---

## Key Discoveries

### Potential Improvements to App.java
1. **Null Validation** — Methods should validate null inputs or document behavior
2. **Overflow Handling** — Consider using `long` or `BigInteger` for numeric operations
3. **Error Messages** — Provide meaningful exceptions instead of silent failures
4. **Empty Collection Handling** — Explicitly handle empty inputs

### Testing Best Practices Applied
- ✅ One concept per test (clear failure messages)
- ✅ Descriptive test names (describes what is being tested)
- ✅ Arrange-Act-Assert pattern
- ✅ Test both success and failure paths
- ✅ Document expected behavior for edge cases

---

## Related Documentation

- **[LEARNING.md](logs/LEARNING.md)** — Detailed learning session with concepts, strategies, and analysis
- **[App.java](app/src/main/java/org/example/App.java)** — Utility methods implementation
- **[AppTest.java](app/src/test/java/org/example/AppTest.java)** — Comprehensive test suite

---

## Technology Stack

- **Language**: Java 11+
- **Testing Framework**: JUnit 5 (Jupiter)
- **Build Tool**: Gradle 8.0+
- **IDE**: VS Code with Gradle extension

---

## Conclusion

This project serves as a practical guide to comprehensive unit testing in Java. By systematically identifying and implementing edge case tests, we've created a robust test suite that demonstrates best practices and provides a foundation for high-quality software development.

The 82-test suite covers not just the happy path but also error conditions, boundary values, and null safety—essential for production-ready code.

---

## License

Educational Project - Afeka College Unit Testing Course

---

**Last Updated**: June 17, 2026
