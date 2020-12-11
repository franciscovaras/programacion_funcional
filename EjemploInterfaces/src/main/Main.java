package main;

import figuras.Cuadrado;
import figuras.Rectangulo;
import figuras.FiguraGeometrica;

/**
 * Programa principal para practicar con la implementación de distintas interfaces empleando distintas alternativas
 */

public class Main
{
    static void mostrarInformacion(FiguraGeometrica f)
    {
        System.out.println("Area: " + f.calcularArea());
        System.out.println("Perímetro: " + f.calcularPerimetro());
    }

    public static void main(String[] args)
    {
        // Definición de objetos a partir de las clases "normales"

        Rectangulo r = new Rectangulo(10, 3);
        System.out.println("Datos del rectángulo:");
        mostrarInformacion(r);

        Cuadrado c = new Cuadrado(4);
        System.out.println("Datos del cuadrado:");
        mostrarInformacion(c);

        System.out.println("Datos del círculo:");
        mostrarInformacion(new FiguraGeometrica() {

            int radio = 5;

            @Override
            public double calcularArea() {
                return Math.PI * radio * radio;
            }

            @Override
            public double calcularPerimetro() {
                return 2 * Math.PI * radio;
            }
        });
    }
}





























/*
    public static void mostrarInformacion(FiguraGeometrica f)
    {
        System.out.println("Area: " + f.calcularArea());
        System.out.println("Perímetro: " + f.calcularPerimetro());
    }

    FiguraGeometrica circulo = new FiguraGeometrica() {

        int radio = 5;

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }

        @Override
        public double calcularPerimetro() {
            return 2 * Math.PI * radio;
        }
    };
*/