package ejemplolambdas;

/**
 * Programa principal donde se aplican distintos tipos de funciones (simples y compuestas) para procesar
 * un listado de personas
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main
{
    public static void main(String[] args)
    {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("May", 41));

        // Bifunción que filtra personas por edad mínima

        BiFunction<List<Persona>, Integer, List<Persona>> minEdad = (lista, edad) ->
        {
            List<Persona> resultado = new ArrayList<>();
            for(Persona p: lista)
            {
                if (p.getEdad() >= edad)
                {
                    resultado.add(p);
                }
            }

            return resultado;
        };

        // Función que muestra nombres de personas separados por coma

        Function<List<Persona>, String> listaAString = lista ->
        {
            String resultado = "";
            for(int i = 0; i < lista.size(); i++)
            {
                if (i < lista.size() - 1)
                    resultado += lista.get(i).getNombre() + ", ";
                else
                    resultado += lista.get(i).getNombre();
            }

            return resultado;
        };

        // Resultados simples

        List<Persona> mayoresDe5 = minEdad.apply(listaPersonas, 5);
        System.out.println("Personas con al menos 5 años:");
        for(Persona p: mayoresDe5)
        {
            System.out.println(p);
        }

        System.out.println("Nombres separados por comas:");
        System.out.println(listaAString.apply(listaPersonas));

        // Combinación de funciones

        BiFunction<List<Persona>, Integer, String> nombresAdultos = minEdad.andThen(listaAString);
        System.out.println("Nombres de personas adultas:");
        System.out.println(nombresAdultos.apply(listaPersonas, 18));
    }
}
