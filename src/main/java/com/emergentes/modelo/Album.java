
package com.emergentes.modelo;

import java.sql.Date;

public class Album {
    private int album_id;
    private String titulo;
    private String artista_id;
    private String genero_id;
    private Date fecha_lanzamiento;
    private String portada_img;

    public Album() {
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(String artista_id) {
        this.artista_id = artista_id;
    }

    public String getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(String genero_id) {
        this.genero_id = genero_id;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getPortada_img() {
        return portada_img;
    }

    public void setPortada_img(String portada_img) {
        this.portada_img = portada_img;
    }

    @Override
    public String toString() {
        return "Album{" + "album_id=" + album_id + ", titulo=" + titulo + ", artista_id=" + artista_id + ", genero_id=" + genero_id + ", fecha_lanzamiento=" + fecha_lanzamiento + ", portada_img=" + portada_img + '}';
    }
    
}
