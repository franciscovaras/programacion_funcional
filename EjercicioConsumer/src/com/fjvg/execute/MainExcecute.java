package com.fjvg.execute;

import com.fjvg.service.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainExcecute {

    public static void main(String[] args) {

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("May", 41));

        Consumer<Persona> imprimir = p -> System.out.println(p);

        for(Persona p: listaPersonas){
            imprimir.accept(p);
        }
    }
}
