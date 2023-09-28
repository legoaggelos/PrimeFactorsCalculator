package com.legoaggelos.app;

import java.util.ArrayList;

public class PrimeFactorCalculator {
    private static int amountOfFactorsInAnInt(int integerToGetFactorsFrom) {
        if (integerToGetFactorsFrom == 0) return 1;
        if (integerToGetFactorsFrom <= 0) return -1;
        int amount = 0;
        for (int i = 1; i < integerToGetFactorsFrom + 1; i++) {
            if (integerToGetFactorsFrom % i == 0) {
                amount++;
            }
        }
        return amount;
    }

    public static boolean checkIfIntegerFactorsAreOne(int number) {
        return amountOfFactorsInAnInt(number) == 1;
    }

    public static boolean checkIfAnIntegerCanBeDividedByAIntegerInAnArrayList(ArrayList<Integer> integers, int integer) {
        for (int tempInt : integers) {
            if (integer % tempInt == 0) return true;
        }
        return false;
    }

    public static String calculatePrimeFactors(int number) {
        StringBuilder primeFactor = new StringBuilder();
        double utilNumber = number;
        int numberToDivide = 2;
        ArrayList<Integer> alreadyUsedInts = new ArrayList<>();
        boolean isFirstTime = false;
        while (!checkIfIntegerFactorsAreOne((int) utilNumber)) {
            if (utilNumber == (int) utilNumber) {
                if (!checkIfAnIntegerCanBeDividedByAIntegerInAnArrayList(alreadyUsedInts, (int) utilNumber)) {
                    if (utilNumber / numberToDivide == (int) utilNumber / numberToDivide) {
                        utilNumber = utilNumber / numberToDivide;
                        if (!isFirstTime) {
                            primeFactor.append(numberToDivide);
                            isFirstTime = true;
                        } else {
                            primeFactor.append("x").append(numberToDivide);
                        }
                    } else {
                        numberToDivide++;
                    }
                } else {
                    numberToDivide++;
                }
            } else {
                numberToDivide++;
            }
        }
        return primeFactor.toString();
    }
}
