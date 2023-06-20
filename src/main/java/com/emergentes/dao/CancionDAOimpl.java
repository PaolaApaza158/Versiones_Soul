package com.emergentes.dao;

import com.emergentes.modelo.Cancion;
import com.emergentes.utiles.ConexionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CancionDAOimpl extends ConexionDB implements CancionDAO {

    @Override
    public void insert(Cancion cancion) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO cancion (titulo, duracion, fecha, artista_id, album_id, genero_id, grupo_id, cancion_img) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getDuracion());
            ps.setDate (3, (java.sql.Date) cancion.getFecha());/*Verificarrrr*/
            ps.setInt(4, cancion.getArtista_id());
            ps.setInt(5, cancion.getAlbum_id());
            ps.setInt(6, cancion.getGenero_id());
            ps.setInt(7, cancion.getGrupo_id());
            ps.setString(8, cancion.getCancion_img());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cancion cancion) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE cancion SET titulo = ?, duracion = ?, fecha = ?, artista_id = ?, album_id = ?, genero_id = ?, grupo_id = ?, cancion_img = ? "
                    + "WHERE cancion_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getDuracion());
            ps.setDate (3, (java.sql.Date) cancion.getFecha());/*Verificarrrr*/
            ps.setInt(4, cancion.getArtista_id());
            ps.setInt(5, cancion.getAlbum_id());
            ps.setInt(6, cancion.getGenero_id());
            ps.setInt(7, cancion.getGrupo_id());
            ps.setString(8, cancion.getCancion_img());
            ps.setInt(9, cancion.getCancion_id());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM cancion WHERE cancion_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cancion getById(int id) throws Exception {
        Cancion cancion = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM cancion WHERE cancion_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cancion = new Cancion();
                cancion.setCancion_id(rs.getInt("cancion_id"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setDuracion(rs.getString("duracion"));
                cancion.setFecha(rs.getDate("fecha"));
                cancion.setArtista_id(rs.getInt("artista_id"));
                cancion.setAlbum_id(rs.getInt("album_id"));
                cancion.setGenero_id(rs.getInt("genero_id"));
                cancion.setGrupo_id(rs.getInt("grupo_id"));
                cancion.setCancion_img(rs.getString("cancion_img"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cancion;
    }

    @Override
    public List<Cancion> getAll() throws Exception {
        List<Cancion> lista = null;
        try {
            this.conectar();
            String sql = "SELECT c.*, a.nombre AS artista, al.titulo AS album, g.nombre AS genero, gr.nombre AS grupo FROM cancion c ";
            sql += "LEFT JOIN artista a ON c.artista_id = a.artista_id ";
            sql += "LEFT JOIN album al ON c.album_id = al.album_id ";
            sql += "LEFT JOIN genero g ON c.genero_id = g.genero_id ";
            sql += "LEFT JOIN grupo gr ON c.grupo_id = gr.grupo_id";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setCancion_id(rs.getInt("cancion_id"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setDuracion(rs.getString("duracion"));
                cancion.setFecha(rs.getDate("fecha"));
                cancion.setArtista_id(rs.getInt("artista_id"));
                cancion.setAlbum_id(rs.getInt("album_id"));
                cancion.setGenero_id(rs.getInt("genero_id"));
                cancion.setGrupo_id(rs.getInt("grupo_id"));
                cancion.setCancion_img(rs.getString("cancion_img"));

                // Agregar propiedades adicionales si están presentes en la clase Cancion
                cancion.setArtista(rs.getString("artista"));
                cancion.setAlbum(rs.getString("album"));
                cancion.setGenero(rs.getString("genero"));
                cancion.setGrupo(rs.getString("grupo"));
                lista.add(cancion);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}

