package com.cejv416.cejv416a_assignment00;

import java.util.Scanner;

/**
 * Calculate one of three financial formula chosen from a menu
 *
 * @author Ken Fogel
 */
public class CEJV416A_Assignment00 {
    
    public void doAllInOne() {
        Scanner sc = new Scanner(System.in);
        double loanAmount = 0.0;
        double savingsAmount = 0.0;
        double futureValue = 0.0;
        double interestRate = 0.0;
        double term = 0.0;

        char choice;

        do {
            // Menu 
            do {
                System.out.println("Please enter the letter for one of the following:");

                System.out.println("A. Loan Payment");
                System.out.println("B. Future Value");
                System.out.println("C. Savings Goal");
                System.out.println("D. Exit");
                // Validate with a regular expression for a range of characters,                 
                // upper and lower case
                if (sc.hasNext("[a-dA-D]")) { // Accept only a single letter String
                    // Retrieve the string from the keyboard buffer, convert it to 
                    // upper case, and retrieve the first letter as a char
                    choice = sc.next().toUpperCase().charAt(0);
                } else {
                    // Did not match the regular expression. Inform user and set 
                    // choice to the character z
                    System.out.println("Invalid choice");
                    choice = 'z'; // Indicates invalid input
                }
                // Clear out the keyboard buffer
                sc.nextLine();
            } while (choice == 'z'); // Keep asking until choice is not wrequal to z

            // Menu choice
            switch (choice) {
                case 'A' -> { // Loan payment
                    boolean inCorrect; // If value is not a double or out of range
                    do {
                        inCorrect = false;                        
                        System.out.println("Enter loan amount, maximum: " + 1_000_000.00 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            loanAmount = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (loanAmount < 0.0 || loanAmount >= 1_000_000.00) {
                                System.out.printf("%.2f is out of range.", loanAmount);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);
                    do {
                        inCorrect = false;                        
                        System.out.println("Enter interest rate as a decimal (5% -> 0.05), maximum: " + 1.0 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            interestRate = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (interestRate < 0.0 || interestRate >= 1.0) {
                                System.out.printf("%.2f is out of range.", interestRate);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);

                    do {
                        inCorrect = false;                        
                        System.out.println("Enter the term in months: " + 120.0 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            term = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (term < 0.0 || term >= 120) {
                                System.out.printf("%.2f is out of range.", term);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);

                    var ir = interestRate / 12.0;
                    double result = loanAmount * ((ir) / (1 - Math.pow(1 + ir, -term)));
                    result = Math.round(result * 100);
                    result /= 100; // result = result / 100
                    System.out.printf("Monthly payment will be %.2f.\n\n", result);
                }

                case 'B' -> { // Future Value
                    boolean inCorrect; // If value is not a double or out of range
                    do {
                        inCorrect = false;                        
                        System.out.println("Enter monthly savings amount, maximum " + 1_000.00 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            savingsAmount = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (savingsAmount < 0.0 || savingsAmount >= 1_000.00) {
                                System.out.printf("%.2f is out of range.", savingsAmount);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);
                    do {
                        inCorrect = false;                        
                        System.out.println("Enter interest rate as a decimal (5% -> 0.05), maximum: " + 1.0 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            interestRate = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (interestRate < 0.0 || interestRate >= 1.0) {
                                System.out.printf("%.2f is out of range.", interestRate);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);

                    do {
                        inCorrect = false;                        
                        System.out.println("Enter the term in months: " + 120.0 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            term = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (term < 0.0 || term >= 120) {
                                System.out.printf("%.2f is out of range.", term);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);

                    var ir = interestRate / 12.0;
                    double result = savingsAmount * ((1 - Math.pow(1 + ir, term))/ir);
                    result = Math.round(result * 100);
                    result /= 100;

                    System.out.printf("Savings goal %.2f.\n\n", Math.abs(result));
                    
                }
                case 'C' -> { // Savings Goal
                    boolean inCorrect; // If value is not a double or out of range
                    do {
                        inCorrect = false;                        
                        System.out.println("Enter savings goal amount, maximum: " + 1_000_000.00 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            futureValue = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (futureValue < 0.0 || futureValue >= 1_000_000.00) {
                                System.out.printf("%.2f is out of range.", futureValue);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);
                    do {
                        inCorrect = false;                        
                        System.out.println("Enter interest rate as a decimal (5% -> 0.05), maximum: " + 1.0 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            interestRate = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (interestRate < 0.0 || interestRate >= 1.0) {
                                System.out.printf("%.2f is out of range.", interestRate);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);

                    do {
                        inCorrect = false;                        
                        System.out.println("Enter the term in months: " + 120.0 + ": ");
                        if (sc.hasNextDouble()) { // Check that there is a double in the keyboard buffer
                            term = sc.nextDouble(); // 
                            // Check if the number is in range
                            if (term < 0.0 || term >= 120) {
                                System.out.printf("%.2f is out of range.", term);
                                inCorrect = true;
                            }
                        } else { // There was not a double in the keyboard buffer
                            inCorrect = true;
                            System.out.println("You have not entered a number");
                        }
                        sc.nextLine(); // Clean out the buffer
                    } while (inCorrect);

                    var ir = interestRate / 12.0;
                    double result = futureValue * (ir / (1 - Math.pow(1 + ir, term)));
                    result = Math.round(result * 100);
                    result /= 100;
                    System.out.printf("Save %.2f each month.\n\n", Math.abs(result));
                }
                case 'D' ->
                    System.out.println("Thank you for using the CEJV416A calculator");
                default -> {
                    System.out.println(">>>>>> Something has gone wrong. Call IT department. <<<<<<");
                    System.exit(0);
                }

            }
        } while (choice != 'D');
    }

    /**
     * Every Java program requires a main method. You want to do as little as
     * possible in this method. You should just instantiate the class that will
     * take control and then call upon a method in that class to start the work.
     *
     * @param args You can pass values when the program is run from the command
     * line.
     */
    public static void main(String[] args) {
        new CEJV416A_Assignment00().doAllInOne();
        // or
        // CEJV416A_Assignment00 calculator = new CEJV416A_Assignment00();
        // calculator.doAllInOne();
    }
}
