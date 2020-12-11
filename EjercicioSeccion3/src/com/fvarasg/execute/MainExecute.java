package com.fvarasg.execute;

import com.fvarasg.execute.controller.Pelicula;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainExecute {
    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        List<Pelicula> subListado = peliculas.stream()
                                             .filter(p -> p.getEstreno() >=2000)
                                             .collect(Collectors.toList());
        System.out.println("Nombre de películas estrenadas en el siglo XXI");
        for(Pelicula p: subListado){
            System.out.println(p);
        }

        String strPeliculas = peliculas.stream()
                .filter(p -> p.getDirector().startsWith("Steven Spielberg"))
                .map(p -> p.getTitulo())
                .collect(Collectors.joining(", ","",""));
        System.out.println("\nMostrar nombre de películas en una cadena separados por coma");
        System.out.println(strPeliculas);

        List<Pelicula> sortNomPeliculas = peliculas.stream()
                .sorted((p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo()))
                .collect(Collectors.toList());
        System.out.println("\nSublistado con pleiculas ordenadas alfabéticamente");
        for(Pelicula p: sortNomPeliculas){
            System.out.println(p.getTitulo());
        }



        Optional<Pelicula> strenoMax = peliculas.stream().max((p1, p2) -> p1.getEstreno() - p2.getEstreno());
        if(strenoMax.isPresent()){
            System.out.println("\nEl año más reciente del estreno de una pelicula es el año: " + strenoMax.get().getEstreno());
        }else{
            System.out.println("\nNo se han encontrado año de película que cumplan el requicito");
        }
    }
}
