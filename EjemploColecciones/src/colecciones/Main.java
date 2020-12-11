package colecciones;

/**
 * Programa principal, donde se trabaja con distintos tipos de colecciones de Personas: arrays, listas, mapas,
 * para comprobar similitudes y diferencias en la gestión de cada tipo.
 */

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Persona[] arrayPersonas = new Persona[5];
        arrayPersonas[0] = new Persona("Nacho", 42);
        arrayPersonas[1] = new Persona("Juan", 70);
        arrayPersonas[2] = new Persona("Mario", 7);
        arrayPersonas[3] = new Persona("Laura", 4);
        arrayPersonas[4] = new Persona("May", 41);

        System.out.println("Array de personas:");

        for (int i = 0; i < arrayPersonas.length; i++)
        {
            System.out.println(arrayPersonas[i].getNombre());
        }

        for (Persona p: arrayPersonas)
        {
            System.out.println(p.getNombre());
        }

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Nacho", 42));
        listaPersonas.add(new Persona("Juan", 70));
        listaPersonas.add(new Persona("Mario", 7));
        listaPersonas.add(new Persona("Laura", 4));
        listaPersonas.add(new Persona("May", 41));

        listaPersonas.remove(0);    // Borra el primer elemento ("Nacho")

        System.out.println("Lista de personas:");

        for (int i = 0; i < listaPersonas.size(); i++)
        {
            System.out.println(listaPersonas.get(i).getNombre());
        }

        for (Persona p: listaPersonas)
        {
            System.out.println(p.getNombre());
        }

        Map<String, Persona> mapaPersonas = new HashMap<>();
        mapaPersonas.put("11111111A", new Persona("Nacho", 42));
        mapaPersonas.put("22222222B", new Persona("Juan", 70));
        mapaPersonas.put("33333333C", new Persona("Mario", 7));
        mapaPersonas.put("44444444D", new Persona("Laura", 4));
        mapaPersonas.put("55555555E", new Persona("May", 41));

        mapaPersonas.remove("11111111A");

        System.out.println("Mapa de personas:");

        for (String clave: mapaPersonas.keySet())
        {
            Persona p = mapaPersonas.get(clave);
            System.out.println(p.getNombre());
        }
    }
}
