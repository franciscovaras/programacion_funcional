package execution;

import lambda.ISerie;
import lambda.SerieImpl;

public class Main {

    public static void main(String[] arg){
        int n = 0;
        SerieImpl serie = new SerieImpl();

        System.out.println("Primera iteracion usando el OBJETO\n");
        for(int i = 0; i<10; i++ ){
            System.out.println(n);
            n = serie.siguiente(n);
        }

        ISerie serie1 = new ISerie() {
            @Override
            public int siguiente(int n) {
                return n + 5;
            }
        };
        System.out.println("\nSegunda iteracion usando el CLASE ANONIMA\n");
        n = 0;
        for(int i = 0; i<10; i++ ){
            System.out.println(n);
            n = serie1.siguiente(n);
        }

        //Expresion lambda

        /*ISerie lambda = (num) -> {
            return num + 5;
        };*/

        ISerie lambda = num -> num + 5;

        System.out.println("\nTercera iteracion usando el expresion LAMBDA\n");
        n = 0;
        for(int i = 0; i<10; i++ ){
            System.out.println(n);
            n = lambda.siguiente(n);
        }

    }
}
