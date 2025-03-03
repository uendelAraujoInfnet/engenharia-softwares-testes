package com.uendel.calculoimc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImcRequest {
    private double peso;
    private double altura;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
