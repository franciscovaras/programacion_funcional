package com.fjvarasg.main;

import com.fjvarasg.service.Persona;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainExcecute {

    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("May", 41));

        Stream<Persona> streamPersona = listaPersonas.stream();
        Stream<Persona> adultos = streamPersona.filter(p -> p.getEdad() >= 18);
        System.out.println("Filtrado de personas mayores de 18 años");
        adultos.forEach(p-> System.out.println(p));

        System.out.println("\nForma más optima de sacar personas mayores de 18 años");

        listaPersonas.stream()
                     .filter(p -> p.getEdad() >= 18 && p.getNombre().startsWith("M"))
                     .forEach(p -> System.out.println(p));

        /*
        * segunda clases; stream() map. obtiene dato o transforma datos
        * */
        System.out.println("\n segunda clase\n");

        System.out.println("primer ejercicio listar todas los nombre");
        listaPersonas.stream()
                     .map(p -> p.getNombre())
                     .forEach(p -> System.out.println(p));

        List<String> datosPersonas = new ArrayList<>();
        datosPersonas.add("Stevens:48");
        datosPersonas.add("Adrian:40");
        datosPersonas.add("Flavia:18");
        datosPersonas.add("Camaleon:14");
        datosPersonas.add("Fabiola:13");
        datosPersonas.add("Maicol:34");
        datosPersonas.add("Mercedes:64");
        datosPersonas.add("Chela:74");
        datosPersonas.add("Mono:15");
        datosPersonas.add("Joaquin:23");
        datosPersonas.add("ViejaJuliá:78");

        System.out.println("\nConstruir nuevas Persona");
        datosPersonas.stream().map(s -> {
                        String nombre = s.split(":")[0];
                        int edad = Integer.parseInt(s.split(":")[1]);
                        return new Persona(nombre, edad);
                      })
                      .forEach(System.out::println);
        System.out.println("\nMétodo abreviado para Construir nuevas Persona");
        datosPersonas.stream()
                .map(s -> new Persona(s.split(":")[0], Integer.parseInt(s.split(":")[1])))
                .forEach(System.out::println);
        /*
        * Tercera clase, método sorted
        * */
        System.out.println("\nPersonas oredenadas de menor a mayor");
        listaPersonas.stream()
                     .sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
                     .forEach(System.out::println);

        System.out.println("\nPersonas oredenadas de mayor a menor");
        listaPersonas.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad()))
                .forEach(System.out::println);

        System.out.println("\nComparaciones complejas");
        Comparator<Persona> cEdad = ((p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad()));
        Comparator<Persona> cNombre = ((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        listaPersonas.stream().sorted(cEdad.thenComparing(cNombre)).forEach(System.out::println);

        /*
        * Cuarta clase funciones enlasadas
        * */
        System.out.println("\nimprimir las 3 primeras personas con mayor edad");

        listaPersonas.stream()
                     .sorted((p1, p2)-> p2.getEdad() - p1.getEdad())
                     .map(p -> p.getNombre())
                     .limit(3)
                     .forEach(System.out::println);
        /*
        * Quinta Clase: operaciones finales, método collect
        * el ejercicio consiste en crear una lista de una lista ya existente
        * */

        List<Persona> adultoss = listaPersonas.stream()
                                             .filter(p-> p.getEdad() > 18)
                                             .collect(Collectors.toList());
        System.out.println("\nimprimir nueva lista adultoss con las personas mayores a 18");
        for(Persona a: adultoss){
            System.out.println(a);
        }

        /*
        * sexta clase: método collect.joining
        * Se creará una cadena de texto a partir de la lista excistente.
        * */

        String adulteros = listaPersonas.stream()
                                        .filter(p -> p.getEdad() > 18)
                                        .map(p -> p.getNombre())
                                        .collect(Collectors.joining(", ","Nombres: ",".fin"));
        System.out.println("\nimprimir la cadena adulteros");
        System.out.println(adulteros);

        /*
        * Septima Clase reduce.
        * el primer parametro del reduce, es el valor inicial. en este caso es 0
        * */

        int sumaEdades = listaPersonas.stream()
                                      .map(p -> p.getEdad())
                                      .reduce(0, (p1, p2) -> p1 + p2);
        System.out.println("\nmostrar la suma de las edades: " + sumaEdades);

        //método anyMacth: Devuelve si algún elemento de esta secuencia coincide con el predicado proporcionado
        if(listaPersonas.stream().anyMatch(p -> p.getEdad()>= 18)){
            System.out.println("Hay adultos en la lista");
        }

        /*
        * Octaba Clase: maximo, minimo , media
        * */

        Optional<Persona> mayor = listaPersonas.stream()
                                     .max((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));

        if(mayor.isPresent()){
            System.out.println("\nLa persona con más edad es: " + mayor.get());
        }else{
            System.out.println("\nNo se han encontrado personas que cumplan el requicito");
        }

        Optional<Persona> menor = listaPersonas.stream()
                .min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
        if(menor.isPresent()){
            System.out.println("\nLa persona con más edad es: " + menor.get());
        }else{
            System.out.println("\nNo se han encontrado personas que cumplan el requicito");
        }

        OptionalDouble media = listaPersonas.stream().mapToInt(p -> p.getEdad()).average();
        if(media.isPresent()){
            System.out.println("\nLa persona con más edad es: " + media.getAsDouble());
        }else{
            System.out.println("\nNo se han encontrado personas que cumplan el requicito");
        }

        //Sacar la media de las edades de las personas mayores de edad
        OptionalDouble mediaAdulta = listaPersonas.stream()
                                                  .filter(p -> p.getEdad() >= 18)
                                                  .mapToDouble(p -> p.getEdad()).average();
        if(mediaAdulta.isPresent()){
            System.out.println("\nLa persona con más edad es: " + mediaAdulta.getAsDouble());
        }else{
            System.out.println("\nNo se han encontrado personas que cumplan el requicito");
        }

        /*
        * Novena Clase arrays aarayTo
        * */

        List<Persona> adultitos = listaPersonas.stream()
                                               .filter(p-> p.getEdad() >=18)
                                               .collect(Collectors.toList());

        System.out.println("\nmostrar new lista con personas adultas");
        for(Persona p: adultitos){
            System.out.println(p);
        }

        //metodo toArray
        Persona[] adultosArray = listaPersonas.stream()
                .filter(p-> p.getEdad() >=18)
                .toArray(tam -> new Persona[tam]);

        System.out.println("\nmostrar lista convertida en arreglo con personas adultas");
        for(Persona p: adultosArray){
            System.out.println(p);
        }

        //Ejemplo con mapas
        Map<String, Persona> mapaPersona = new HashMap<>();
        mapaPersona.put("1111A", new Persona("Nacho", 42));
        mapaPersona.put("1111B", new Persona("Juan", 70));
        mapaPersona.put("1111C", new Persona("Mario", 7));
        mapaPersona.put("1111D", new Persona("Laura", 4));
        mapaPersona.put("1111E", new Persona("May", 41));

        //El método values permite trabajar con los valores del mapa
        List<Persona> adiltosMapa = mapaPersona.values()
                                               .stream()
                                               .filter(p -> p.getEdad() > 18)
                                               .collect(Collectors.toList());
        System.out.println("\nmostrar Mapa convertida en Lista con personas adultas");
        for(Persona p: adiltosMapa){
            System.out.println(p);
        }

        //método entrySet permite trabajar con las claves.
        //Método getValue permite al filtro acceder a los valores si se está trabajando con la clave

        List<String> claveMapa = mapaPersona.entrySet()
                .stream()
                .filter(p -> p.getValue().getEdad() > 18)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("\nmostrar en una lista las claves de las personas adultas");
        for(String p: claveMapa){

            System.out.println(p);
        }

        /*
        * Décima Clase trabajando con Files
        * */

        try {
            List<Persona> adultosFichero = Files.lines(Paths.get("personas.txt"))
                                                .map(l -> new Persona(l.split(":")[0], Integer.parseInt(l.split(":")[1])))
                                                .collect(Collectors.toList());
            System.out.println("\nPersonas Leidas de Fichero");
            for(Persona p: adultosFichero){
                System.out.println(p);
            }

            Files.write(Paths.get("personas2.txt"), adultosFichero.stream()
                                                                       .map(p -> p.aFichero())
                                                                       .collect(Collectors.toList()));

        } catch (IOException e) {
            System.out.println("no encontró archivo");
        }


    }
}
