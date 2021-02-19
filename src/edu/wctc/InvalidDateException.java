package edu.wctc;

public class InvalidDateException extends Exception {
    public InvalidDateException(int year, int month, int day) {
        super(String.format("%d/%d/%d is not a valid date.", month, day, year));
    }
}
