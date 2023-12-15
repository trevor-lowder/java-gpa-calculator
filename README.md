# GPA Calculator

The GPA Calculator is a Java program designed to calculate a student's Grade Point Average (GPA) based on the grades and credits of multiple classes. The user inputs the number of classes, the credits for each class, and the corresponding letter grades. The program then validates the input and computes the overall GPA.

## Usage:
Run the program and input the number of classes.
For each class, input the number of credits and the corresponding letter grade.
The program will calculate and display the overall GPA.

## Program Logic

The GPA calculation follows a simple formula:

GPA = Total Points / Total Credits

Where:
- Total Points = Sum of (Grade Value * Credits) for each class.
- Grade Value is determined by the letter grade (A, B, C, D, F).

## Custom Exception: InvalidGradeException

The program uses a custom exception, `InvalidGradeException`, to handle cases where the user enters an invalid letter grade. This exception is thrown by the `validateGrade` method.

## Method: `validateGrade(String letterGrade) throws InvalidGradeException`

The `validateGrade` method ensures that the user-entered letter grade is valid. It throws an `InvalidGradeException` if the grade is not one of the accepted values (A, B, C, D, F).

Example:

```java
private static void validateGrade(String letterGrade) throws InvalidGradeException {
    if (!letterGrade.matches("[ABCDF]")) {
        throw new InvalidGradeException("Grade must be A, B, C, D, or F");
    }
}
```
