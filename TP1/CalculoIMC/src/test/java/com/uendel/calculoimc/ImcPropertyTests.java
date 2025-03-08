package com.uendel.calculoimc;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.Positive;

import static org.assertj.core.api.Assertions.*;

class ImcPropertyTests {

    @Property
    void imcNuncaDeveSerNegativo(@ForAll @Positive double peso, @ForAll @Positive double altura) {
        double imc = peso / (altura * altura);
        assertThat(imc).isGreaterThanOrEqualTo(0);
    }

    @Provide
    Arbitrary<Double> alturasExtremas() {
        return Arbitraries.of(1.0, 1.9, 2.5);  // Testa alturas incomuns
    }

    @Provide
    Arbitrary<Double> pesosExtremos() {
        return Arbitraries.of(40.0, 500.0, 800.0);  // Testa pesos extremos
    }

    @Property
    void testValoresExtremos(@ForAll("pesosExtremos") double peso,
                             @ForAll("alturasExtremas") double altura) {
        double imc = peso / (altura * altura);
        assertThat(imc).isBetween(5.0, 1550.0);
    }

    @Property
    void testIMCComValoresAleatorios(@ForAll @DoubleRange(min = 0.1, max = 500.0) double peso,
                                     @ForAll @DoubleRange(min = 0.5, max = 3.0) double altura) {
        double imc = peso / (altura * altura);
        assertThat(imc).isGreaterThanOrEqualTo(0);
    }


}
