package com.francisco.Implementacion;

import com.francisco.interfaces.IFigurasGeometricas;

public class Rectangulo implements IFigurasGeometricas {

    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculoArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * base + 2 * altura;
    }
}
