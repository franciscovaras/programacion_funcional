package com.fvaras.predicate.controller;

public class Persona {

        private String nombre;
        private int edad;
        private String sexo;
        private String apellidos;

    public Persona(String nombre, String apellidos, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String toString(){

        return nombre + " (" + edad + " años)";
    }
}
