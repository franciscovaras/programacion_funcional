package com.fvaras.predicate;

import com.fvaras.predicate.controller.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExcecuteMain {

    static List<Persona> filtrar(List<Persona> presonas, Predicate<Persona> predicado){

        List<Persona> resultado = new ArrayList<>();

        for(Persona p: presonas){

            if(predicado.test(p)){
                resultado.add(p);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {

        List<Persona> listaPersona = new ArrayList<>();
        listaPersona.add(new Persona("Nacho", "Gonzalez", 41, "m"));
        listaPersona.add(new Persona("Pepa", "Muñoz", 15, "f"));
        listaPersona.add(new Persona("Ramona", "Parra", 17, "f"));
        listaPersona.add(new Persona("Pancho", "Fernandez", 37, "m"));
        listaPersona.add(new Persona("Carol", "Faundez", 13, "f"));
        listaPersona.add(new Persona("Fidel", "prieto", 30, "m"));

        List<String> ejemploLista = new ArrayList<String>();
        ejemploLista.add("Claudio");

        System.out.println("Imprimir Persona");
        for(Persona p: listaPersona){
            System.out.println(p);
        }

        //Predicate<Persona> adulto = p -> p.getEdad() >= 18;
        //System.out.println(adulto.test(listaPersona.get(0)));

        List<Persona> adulto = filtrar(listaPersona, p -> p.getEdad() >= 18);
        System.out.println("\nListado de personas mayores a 18 años");
        for(Persona p: adulto){
            System.out.println(p);
        }

        List<Persona> nombre = filtrar(listaPersona, p -> p.getNombre().startsWith("N"));
        System.out.println("\nListado de personas con nombres que empiezan con N");
        for(Persona p: nombre){
            System.out.println(p);
        }

        Predicate<Persona> pAdulto = p -> p.getEdad() <= 18;
        Predicate<Persona> pNombre = p -> p.getNombre().startsWith("P");
        List<Persona> menores = filtrar(listaPersona, pAdulto.and(pNombre));
        System.out.println("\nListado de personas con nombres que empiezan con N y menores a 18 años");
        for(Persona p: menores){
            System.out.println(p);
        }



    }
}
