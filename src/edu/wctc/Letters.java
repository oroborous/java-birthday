package edu.wctc;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Letters {
    private static final long WI_POPULATION = 5_726_398;
    private static final long CA_POPULATION = 38_041_430;
    private static final long TX_POPULATION = 26_059_203;
    private static final double COPY_PRICE = 3.23;

    public static void main(String[] args) {

        System.out.println("USING PRIMITIVE NUMBERS");
        usingPrimitives();

        System.out.println("USING BIG NUMBERS");
        usingBigNumbers();

    }

    private static void usingBigNumbers() {
        BigInteger wisco = BigInteger.valueOf(WI_POPULATION);
        BigInteger cali = BigInteger.valueOf(CA_POPULATION);
        BigInteger texas = BigInteger.valueOf(TX_POPULATION);
        BigDecimal price = BigDecimal.valueOf(COPY_PRICE);

        BigInteger wiscoToCali = wisco.multiply(cali);

        System.out.printf("Wisconsin letters written to California: %d%n", wiscoToCali);

        BigInteger copiesForTexas = wiscoToCali.multiply(texas);

        System.out.printf("Copies for Texans: %d%n", copiesForTexas);

        // Can only do operations on same type, so create BigDecimal from BigInteger
        BigDecimal priceForCopies = price.multiply(new BigDecimal(copiesForTexas));

        System.out.printf("Cost of copies at $%.2f each: $%,.2f%n", COPY_PRICE, priceForCopies);
    }

    public static void usingPrimitives() {
        long wiscoToCali = WI_POPULATION * CA_POPULATION;

        System.out.printf("Wisconsin letters written to California: %d%n", wiscoToCali);

        long copiesForTexas = wiscoToCali * TX_POPULATION;

        System.out.printf("Copies for Texans: %d%n", copiesForTexas);

        double priceForCopies = copiesForTexas * COPY_PRICE;

        System.out.printf("Cost of copies at $%.2f each: $%,.2f%n", COPY_PRICE, priceForCopies);
    }
}
