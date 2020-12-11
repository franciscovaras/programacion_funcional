package com.francisco.Implementacion;

import com.francisco.interfaces.IFigurasGeometricas;

public class Cuadrado implements IFigurasGeometricas {

    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    @Override
    public double calculoArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return lado * 4;
    }
}
