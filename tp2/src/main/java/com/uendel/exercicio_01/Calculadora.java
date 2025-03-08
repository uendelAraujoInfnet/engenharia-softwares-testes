package com.uendel.exercicio_01;

import java.util.List;

public class Calculadora {

  public static int somaLista(List<Integer> numeros) {
    return numeros.stream().mapToInt(Integer::intValue).sum();
  }
}
