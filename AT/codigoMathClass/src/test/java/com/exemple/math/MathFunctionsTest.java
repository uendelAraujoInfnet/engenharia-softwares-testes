package com.exemple.math;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MathFunctionsTest {

    private final MathFunctions mathFunctions = new MathFunctions((op, in) -> {});

    @Property
    boolean multiplyByTwoReturnsEven(@ForAll int number) {
        int result = mathFunctions.MultiplyByTwo(number);
        return result % 2 == 0;
    }

    @Property
    boolean tableHasOnlyMultiples(@ForAll @IntRange(min = 1, max = 1_000_000) int number, @ForAll @IntRange(min = 1, max = 100) int limit) {

        Assume.that((long) number * limit < Integer.MAX_VALUE);

        int[] result = mathFunctions.GenerateMultiplicationTable(number, limit);
        return Arrays.stream(result).allMatch(val -> val % number == 0);
    }

    @Property
    boolean isPrimeHasNoDivisors(@ForAll("primeNumbers") int prime) {
        return mathFunctions.IsPrime(prime) &&
                IntStream.rangeClosed(2, (int) Math.sqrt(prime))
                        .noneMatch(i -> prime % i == 0);
    }

    @Provide
    Arbitrary<Integer> primeNumbers() {
        List<Integer> primes = IntStream.range(2, 1000)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0))
                .boxed().toList();
        return Arbitraries.of(primes);
    }

    @Property
    boolean averageWithinRange(@ForAll("nonEmptyArray") int[] arr) {
        double avg = mathFunctions.CalculateAverage(arr);
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);
        return avg >= min && avg <= max;
    }

    @Provide
    Arbitrary<int[]> nonEmptyArray() {
        return Arbitraries.integers().between(-1000, 1000)
                .array(int[].class).ofMinSize(1).ofMaxSize(100);
    }
}
