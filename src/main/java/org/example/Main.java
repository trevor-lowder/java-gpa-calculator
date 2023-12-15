package org.example;

import java.util.Scanner;
class InvalidGradeException extends Exception {
    public InvalidGradeException (String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of classes: ");
        int numClasses = scanner.nextInt();
        scanner.nextLine();

        int totalCredits = 0;
        int totalPoints = 0;

        for (int i = 1; i <= numClasses; i++) {
            System.out.println("\nClass "+i+":");
            System.out.println("Enter number of credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter letter grade: ");
            String letterGrade = scanner.nextLine().toUpperCase();

            try {
                validateGrade(letterGrade);

                int gradeValue = switch (letterGrade) {
                    case "A" -> 4;
                    case "B" -> 3;
                    case "C" -> 2;
                    case "D" -> 1;
                    default -> 0;
                };

                int points = gradeValue * credits;

                totalCredits += credits;
                totalPoints += points;
            } catch (InvalidGradeException e) {
                System.out.println("Error in Class "+i+": "+e.getMessage());
                i--;
            }
        }

        if (totalCredits > 0) {
            double overallGPA = (double) totalPoints / totalCredits;
            System.out.println("\nYour GPA is: "+overallGPA);
        } else {
            System.out.println("Invalid total number of credits. Please enter a valid number of credits for at least one class.");
        }

        scanner.close();
    }

    private static void validateGrade(String letterGrade) throws InvalidGradeException {
        if(!letterGrade.matches("[ABCDF]")){
            throw new InvalidGradeException("Grade must be A, B, C, D, or F");
        }
    }
}