
package com.emergentes.modelo;


public class Genero {
    
    private int genero_id;
    private String nombre;

    public Genero() {
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Genero{" + "genero_id=" + genero_id + ", nombre=" + nombre + '}';
    }
    
}
