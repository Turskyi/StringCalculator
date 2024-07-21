[![Stand With Ukraine](https://raw.githubusercontent.com/vshymanskyy/StandWithUkraine/main/banner-direct-single.svg)](https://stand-with-ukraine.pp.ua)
<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/m/Turskyi/StringCalculator">

# String Calculator

## Project Description

The String Calculator is a simple terminal-based Java program that can
evaluate mathematical expressions provided as strings.
It supports various features such as custom delimiters,
handling new lines, and ignoring numbers larger than 1000.
This project is a great exercise for beginners to practice string manipulation,
exception handling, and test-driven development (TDD) in Java.
This project also includes comprehensive tests to validate the functionality
and ensure the requirements are met.

## Features

Programming language: [Java](https://www.oracle.com/java/);

1. **Basic Addition**: The `add` method can add numbers separated by commas.
   - Example: `"1,2,5"` will return `8`.
2. **Handling New Lines**: The `add` method can handle new lines in the input.
   - Example: `"1\n,2,3"` will return `6`.
3. **Custom Delimiters**: The `add` method supports custom delimiters specified
   at the beginning of the string.
   - Format: `"//[delimiter]\n[numbers]"`
   - Example: `"//;\n1;3;4"` will return `8`.
4. **Negative Numbers**: Calling `add` with a negative number will throw an
   exception with a message listing the negative numbers.
   - Example: `"1,-2,3"` will throw an
     exception: `"Negatives not allowed: [-2]"`.
5. **Ignoring Large Numbers**: Numbers larger than 1000 are ignored.
   - Example: `"2,1001"` will return `2`.
6. **Arbitrary Length Delimiters**: Custom delimiters can be of arbitrary
   length.
   - Example: `"//***\n1***2***3"` will return `6`.
7. **Multiple Delimiters**: The `add` method supports multiple delimiters.
   - Example: `"//$,@\n1$2@3"` will return `6`.

## The goal of the program:

1. Create a simple String calculator with a method "int Add(string numbers)":
   a. The numbers in the string are separated by a comma.
   b. Empty strings should return 0.
   c. The return type should be an integer.
   d. Example input: “1,2,5”—expected result: “8.”
   e. Write tests to prove your input validates.
2. Change the Add method to handle new lines in the input format:
   a. Example: “1\n,2,3” - Result: “6”
   b. Example 2: “1,\n2,4”—Result: “7”
3. Support a custom delimiter:
   a.
   The beginning of your string will now contain a small control code
   that lets you
   set a custom delimiter.
   b. Format: “//[delimiter]\n[delimiter separated numbers]”
   c.
   Example: “//;\n1;3;4” - Result: 8
   d.
   In the above you can see that following the double forward slash we set a
   semicolon, followed by a new line.
   We then use that delimiter to split our
   numbers.
   e.
   e.
   Other examples
   i.
   “//$\n1$2$3” - Result: 6
   ii. “//@\n2@3@8” - Result: 13
4. Calling add with a negative number should throw an exception:
   “Negatives not allowed.”
   The exception should list the number(s) that caused the exception

   ### Bonus:
5. Numbers larger than 1000 should be ignored.
   a.
   Example “2,1001”—Result: 2
6. Delimiters can be arbitrary length
   a. “//\*\*\*\n1\*\*\*2\*\*\*3” - Result 6
7. Allow for multiple delimiters
   a. “//$,@\n1$2@3” - Result 6
8. Combine 2 and 3 bonus questions. Allow multiple delimiters of arbitrary
   length.

## Tests

The String Calculator project includes comprehensive tests to validate the
functionality and ensure the requirements are met.
These tests cover various scenarios such as handling empty strings, custom
delimiters, negative numbers, and more.
To run the tests, use your preferred Java IDE or a build tool like Maven or
Gradle.

### Example Test

```java
public class StringCalculatorTest {

   @Test
   public final void whenEmptyStringIsUsedThenReturnValueIs0() {
      assertEquals (0, StringCalculator.add (""));
   }
}
```

## Usage

To use the String Calculator, call the `add` method with a string containing
the numbers you want to add.
The method will return the sum of the numbers.
You can specify custom delimiters and handle new lines as described in the
features section.

**Educational Value**:
It can serve as a good example for learning and practicing TDD,
string parsing, and basic arithmetic operations in Java.

**Code Reuse**:
The code can be reused or extended for other projects
that require string-based calculations.

### Example Code

```java
public class Main {
   public static void main(String[] args) {
      final int result = StringCalculator.add ("//$,@\n1$2@3");
      System.out.println ("Result: " + result); // Output: Result: 6
   }
}
```

## Installation Instructions

1. Download the project.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run the `Main` class to see the String Calculator in action.
4. Compile and run the `StringCalculatorTest` class to see the tests in action
   and validate the functionality.