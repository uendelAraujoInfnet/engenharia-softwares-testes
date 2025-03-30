package com.exemple.math;

import java.util.Arrays;

public class MathFunctions {
    private final MathLogger logger;

    public MathFunctions(MathLogger logger) {
        this.logger = logger;
    }

    public int MultiplyByTwo(int number) {
        int result = number * 2;
        logger.log("MultiplyByTwo", new int[]{number});
        return result;
    }

    public int[] GenerateMultiplicationTable(int number, int limit){
        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = number * (i + 1);
        }
        logger.log("GenerateMultiplicationTable", new int[]{number, limit});
        return result;
    }

    public boolean IsPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        logger.log("IsPrime", new int[]{number});
        return true;
    }

    public double CalculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("Array não pode ser nulo ou vazio.");
        logger.log("CalculateAverage", numbers);
        return Arrays.stream(numbers).average().orElseThrow();
    }
}
