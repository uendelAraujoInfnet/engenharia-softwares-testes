package com.uendel.calculoimc.service;

import org.springframework.stereotype.Service;

@Service
public class ImcService {
    public double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");
        }
        return peso / (altura * altura);
    }

    public String classificarIMC(double imc) {
        if (imc < 18.5) return "Baixo peso";
        if (imc < 24.9) return "Peso normal";
        if (imc < 29.9) return "Sobrepeso";
        if (imc < 34.9) return "Obesidade Grau I";
        if (imc < 39.9) return "Obesidade Grau II";
        return "Obesidade Grau III";
    }
}
