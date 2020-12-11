package ejemplolambdas;

/**
 * Clase Persona para definir objetos de tipo Persona para las pruebas que haremos
 */

public class Persona
{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    @Override
    public String toString()
    {
        return nombre + " (" + edad + " años)";
    }
}
