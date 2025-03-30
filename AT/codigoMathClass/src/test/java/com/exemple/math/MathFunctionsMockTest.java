package com.exemple.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MathFunctionsMockTest {
    private MathLogger loggerMock;
    private MathFunctions mathFunctions;

    @BeforeEach
    void setup() {
        loggerMock = mock(MathLogger.class);
        mathFunctions = new MathFunctions(loggerMock);
    }

    @Test
    void shouldLogMultiplyByTwo() {
        mathFunctions.MultiplyByTwo(5);
        verify(loggerMock).log(eq("MultiplyByTwo"), eq(new int[]{5}));
    }

    @Test
    void shouldLogGenerateMultiplicationTable() {
        mathFunctions.GenerateMultiplicationTable(4, 6);
        verify(loggerMock).log(eq("GenerateMultiplicationTable"), eq(new int[]{4, 6}));
    }

    @Test
    void shouldLogIsPrime() {
        mathFunctions.IsPrime(11);
        verify(loggerMock).log(eq("IsPrime"), eq(new int[]{11}));
    }

    @Test
    void shouldLogCalculateAverage() {
        int[] arr = {2, 4, 6};
        mathFunctions.CalculateAverage(arr);

        ArgumentCaptor<int[]> captor = ArgumentCaptor.forClass(int[].class);
        verify(loggerMock).log(eq("CalculateAverage"), captor.capture());

        assertArrayEquals(arr, captor.getValue());
    }
}
