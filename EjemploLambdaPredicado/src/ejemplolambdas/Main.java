package ejemplolambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Programa principal para probar distintos tipos de predicados a la hora de filtrar personas de un listado
 */

public class Main
{
    static List<Persona> filtrar(List<Persona> personas, Predicate<Persona> predicado)
    {
        List<Persona> resultado = new ArrayList<>();

        for(Persona p: personas)
        {
            if (predicado.test(p))
            {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public static void main(String[] args)
    {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("May", 41));

        Predicate<Persona> pAdulto = p -> p.getEdad() >= 18;
        Predicate<Persona> pNombreM = p -> p.getNombre().startsWith("M");

        List<Persona> adultos = filtrar (listaPersonas, pAdulto.and(pNombreM));
        System.out.println("Listado de personas adultas cuyo nombre empieza por M:");

        for(Persona p: adultos)
        {
            System.out.println(p);
        }
    }
}
