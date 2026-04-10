package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Welcome & menu print
        System.out.printf("Welcome to the Sandwich Shop!%n%n");
        System.out.printf(
                        "Menu:%n" +
                        "1: Regular: base price $5.45%n" +
                        "2: Large: base price $8.95%n%n");

        // Sandwich size input
        int sandwichSize;
        while (true) {
            System.out.print("Enter the size of your sandwich (1 or 2): ");

            if (!scanner.hasNextInt()) {
                System.out.printf("Invalid input. Please enter a valid number.%n%n");
                scanner.next();
                continue;
            }

            sandwichSize = scanner.nextInt();

            if (sandwichSize == 1 || sandwichSize == 2) {
                break;
            }

            System.out.printf("Invalid input. Please enter a valid number.%n%n");
        }

        // Loaded sandwich input
        boolean loaded;
        System.out.printf(
                        "%nLoaded Prices:%n" +
                        "Regular: +$1.00%n" +
                        "Large: +$1.75%n%n");
        while (true) {
            System.out.print("Would you like your sandwich loaded (yes/no): ");
            String loadedInput = scanner.next().toLowerCase();
            if (loadedInput.equals("yes")) {
                loaded = true;
                break;
            } else if (loadedInput.equals("no")) {
                loaded = false;
                break;
            }
            else {
                System.out.printf("Invalid input. Please enter a valid response.%n%n");
            }
        }

        // Age input
        System.out.print("Enter your age: ");
        while (!scanner.hasNextInt()) {
            System.out.printf("Invalid input. Please enter a valid number.%n%n");
            scanner.next();
            System.out.print("Enter your age: ");
        }
        int age = scanner.nextInt();

        // Discount calculator
        float discount = 0;
        if (age <= 17) {
            System.out.printf("%nStudent! 10%% Discount!%n%n");
            discount = .9f;
        }
        else if (age >= 65) {
            System.out.printf("%nSenior! 20%% Discount!%n%n");
            discount = .8f;
        }

        // Prints order
        System.out.printf("Order:%n");

        float basePrice;

        // Checks sandwich size and creates discount based off that
        if (sandwichSize == 1) {
            basePrice = 5.45f;
            System.out.println("1: Regular: base price $5.45");
        }
        else {
            basePrice = 8.95f;
            System.out.println("2: Large: base price $8.95");
        }

        // Checks if loaded
        if (loaded) {
            if (sandwichSize == 1) {
                basePrice += 1;
                System.out.println("Loaded: Regular: $1.00");
            }
            else {
                basePrice += 1.75f;
                System.out.println("Loaded: Large: $1.75");
            }
        }

        System.out.printf("Discount: -$%.2f%n", basePrice * (1 - discount));

        System.out.printf("Total: $%.2f", discount * basePrice);
    }
}
