package exercicio_02_Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.*;

import com.uendel.exercicio_02.MathFunctions;

public class MathFunctionsTest {

  // Teste 1 - O dobro de um numero sempre é maior ou igual ao próprio número
  @Property
  void multiplyByTwoShouldBeGreaterOrEqual(@ForAll @IntRange(min = 1 / 2, max = Integer.MAX_VALUE / 2) int number){
    int result = MathFunctions.multiplyByTwo(number);
    assertTrue(result >= number, "multiplyByTwo(" + number + ") deveria ser >= " + number);
  }

  // Teste 2 - Se x for par, então multiplyByTwo(x) tambem sera par
  @Property
  void multiplyByTwoShouldReturnEvenForEvenNumbers(@ForAll @IntRange(min = -1000, max = 1000) int evenNumber){
    Assume.that(evenNumber % 2 == 0);
    int result = MathFunctions.multiplyByTwo(evenNumber);
    assertEquals(0, result % 2, "multiplyByTwo(" + evenNumber + ") deveria ser par, mas retornou " + result);
  }
}
