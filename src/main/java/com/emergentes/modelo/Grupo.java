
package com.emergentes.modelo;
public class Grupo {
    private int grupo_id;
    private String nombre;
    private String grupo_img;

    public Grupo() {
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo_img() {
        return grupo_img;
    }

    public void setGrupo_img(String grupo_img) {
        this.grupo_img = grupo_img;
    }

    @Override
    public String toString() {
        return "Grupo{" + "grupo_id=" + grupo_id + ", nombre=" + nombre + ", grupo_img=" + grupo_img + '}';
    }
    
}
