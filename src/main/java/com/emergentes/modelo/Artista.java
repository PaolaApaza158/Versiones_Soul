
package com.emergentes.modelo;



public class Artista {
    private int artista_id;
    private String nombre;
    private String genero;
    private String fecha_nacimiento;
    private String nacionalidad;
    private String artista_img;
    
    public Artista() {
    }

    public int getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(int artista_id) {
        this.artista_id = artista_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getArtista_img() {
        return artista_img;
    }

    public void setArtista_img(String artista_img) {
        this.artista_img = artista_img;
    }

    @Override
    public String toString() {
        return "Artista{" + "artista_id=" + artista_id + ", nombre=" + nombre + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", nacionalidad=" + nacionalidad + ", artista_img=" + artista_img + '}';
    }
    
    
    
}
