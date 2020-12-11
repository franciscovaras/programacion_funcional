package com.francisco.main;

import com.francisco.Implementacion.Cuadrado;
import com.francisco.Implementacion.Rectangulo;
import com.francisco.interfaces.IFigurasGeometricas;

public class Main {

    static void mostrarInformacion(IFigurasGeometricas f){
        System.out.println("El área es: " + f.calculoArea());
        System.out.println("El perímetro es: " + f.calcularPerimetro()+"\n");
    }

    public static void main(String [] arg){
        Cuadrado cuadrado = new Cuadrado(4);
        Rectangulo rectangulo = new Rectangulo(2, 4);

        System.out.println("Datos para el cuadrado\n");
        mostrarInformacion(cuadrado);

        System.out.println("Datos para el rectágulo\n");
        mostrarInformacion(rectangulo);

        /*IFigurasGeometricas figuras = new IFigurasGeometricas() {

            final int radio = 5;

            @Override
            public double calculoArea() {
                return Math.PI * radio * radio;
            }

            @Override
            public double calcularPerimetro() {
                return 2 *  Math.PI * radio;
            }
        };
        System.out.println("Datos para el círculo");
        mostrarInformacion(figuras);*/

        System.out.println("Datos para el círculo\n");
        mostrarInformacion(new IFigurasGeometricas() {

            final int radio = 5;

            @Override
            public double calculoArea() {
                return Math.PI * radio * radio;
            }

            @Override
            public double calcularPerimetro() {
                return 2 *  Math.PI * radio;
            }
        });

    }
}
