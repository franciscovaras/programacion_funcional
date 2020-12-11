package com.fjvarasg.service;

public class Persona {

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

    public String aFichero(){
        return nombre +":"+edad;
    }
}
