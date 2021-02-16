package edu.wctc;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Please begin by entering your birthday.");
            LocalDate birthday = getDate();

            int choice;
            do {
                choice = doMenu();

                switch (choice) {
                    case 1:
                        calculateAge(birthday);
                        break;
                    case 2:
                        System.out.println("Enter your friend's birthday.");
                        LocalDate friend = getDate();
                        calculateDifference(birthday, friend);
                        break;
                    case 3:
                        calculateRetirement(birthday);
                        break;
                }

            } while (choice != 4);
        } catch (InvalidDateException ide) {
            System.out.println(ide.getMessage());
            System.out.println("Program must exit. Goodbye.");
        }

    }

    private static void calculateRetirement(LocalDate birthday) {
        System.out.print("At what age would you like to retire? ");
        int age = Integer.parseInt(keyboard.nextLine());

        LocalDate retirementDate = birthday.plusYears(age);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        System.out.printf("You will retire on %s.%n", retirementDate.format(formatter));
    }

    private static void calculateDifference(LocalDate birthday, LocalDate friend) {
        String formatString;
        Period difference;

        if (birthday.isBefore(friend)) {
            difference = Period.between(birthday, friend);

            formatString = "You are %d years, %d months, %d days older than your friend.%n";
        } else {
            difference = Period.between(friend, birthday);

            formatString = "Your friend is %d years, %d months, %d days older than you.%n";
        }


        System.out.printf(formatString,
                difference.getYears(),
                difference.getMonths(),
                difference.getDays());
    }

    public static int doMenu() {
        System.out.println("1. Calculate your current age");
        System.out.println("2. Age difference between you and friend");
        System.out.println("3. Plan retirement");
        System.out.println("4. Exit");

        System.out.print("Enter choice >> ");
        int choice = Integer.parseInt(keyboard.nextLine());

        return choice;
    }

    public static LocalDate getDate() throws InvalidDateException {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter month (1 - 12): ");
        int month = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter day: ");
        int day = Integer.parseInt(keyboard.nextLine());

        try {
            LocalDate date = LocalDate.of(year, month, day);
            return date;
        } catch (DateTimeException dte) {
            throw new InvalidDateException(year, month, day);
        }

    }

    public static void calculateAge(LocalDate birthday) {

        LocalDate now = LocalDate.now();

        Period periodUntilNow = Period.between(birthday, now);

        System.out.printf("You are %d years, %d months, and %d days old.%n",
                periodUntilNow.getYears(),
                periodUntilNow.getMonths(),
                periodUntilNow.getDays());
    }

}
