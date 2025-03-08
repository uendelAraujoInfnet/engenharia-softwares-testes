package exercicio_01_Test;

import net.jqwik.api.*;
import java.util.List;

import com.uendel.exercicio_01.Calculadora;

import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

  // Teste 1 - Propriedade Comutativa -> soma(A, B) == soma(B, A)
  @Property
  void somaDeveSerComutativa(@ForAll List<Integer> numeros){
    List<Integer> invertida = new ArrayList<>(numeros);
    Collections.reverse(invertida);
    assertEquals(Calculadora.somaLista(numeros), Calculadora.somaLista(invertida));
  }

  //Teste 2 - Propriedade Neutra -> soma(A, 0) == soma(A)
  @Property
  void somaDeveManterElementoNeutro(@ForAll List<Integer> numeros){
    List<Integer> novaLista = new ArrayList<>(numeros);
    novaLista.add(0);
    assertEquals(Calculadora.somaLista(numeros), Calculadora.somaLista(novaLista));
  }

  //Teste 3 - Propriedade Associatividade -> soma(A, (B + C)) == soma((A + B), C)
  @Property
  void somaDeveSerAssociativa(@ForAll("listaComTresElementos") List<Integer> numeros){
    int a = numeros.get(0);
        int b = numeros.get(1);
        int c = numeros.get(2);

        int resultado1 = Calculadora.somaLista(List.of(a, b + c));
        int resultado2 = Calculadora.somaLista(List.of(a + b, c));

        assertEquals(resultado1, resultado2);
  }

  // Geração de listas com pelo menos 3 números
  @Provide
  Arbitrary<List<Integer>> listaComTresElementos() {
      return Arbitraries.integers().list().ofMinSize(3);
  }
}
