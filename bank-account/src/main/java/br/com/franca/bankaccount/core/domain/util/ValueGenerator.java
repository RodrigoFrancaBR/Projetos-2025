package br.com.franca.bankaccount.core.domain.util;

import java.util.Random;

public class ValueGenerator {

    private static ValueGenerator instance;
    private static Random randomNUmber;

    private ValueGenerator() {
    }

    public static ValueGenerator getInstance() {
        if (instance == null) {
            instance = new ValueGenerator();
            randomNUmber = new Random();
        }
        return instance;
    }

    public String getNumber(long  numberOfToGenerate, int originNumber, int BoundNumber) {
        return randomNUmber.ints(numberOfToGenerate, originNumber, BoundNumber).toString();
    }
}
