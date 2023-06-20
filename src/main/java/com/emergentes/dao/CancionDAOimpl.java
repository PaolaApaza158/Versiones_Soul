package com.emergentes.dao;

import com.emergentes.modelo.Cancion;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CancionDAOimpl extends ConexionDB implements CancionDAO {

    @Override
    public void insert(Cancion cancion) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO cancion (titulo, duracion, fecha, artista_id, album_id, genero_id, grupo_id, cancion_img) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cancion.getTitulo());
            ps.setString(2, cancion.getDuracion());
            ps.setString(3, cancion.getFecha());
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
            ps.setString(3, cancion.getFecha());
            ps.setInt(4, cancion.getArtista_id());
            ps.setInt(5, cancion.getAlbum_id());
            ps.setInt(6, cancion.getGenero_id());
            ps.setInt(7, cancion.getGrupo_id());
            ps.setString(8, cancion.getCancion_img());
            ps.setInt(9, cancion.getCancion_id());
            ps.executeUpdate();
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
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cancion getById(int id) throws Exception {
        Cancion can = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM cancion WHERE cancion_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                can = new Cancion();
                can.setCancion_id(rs.getInt("cancion_id"));
                can.setTitulo(rs.getString("titulo"));
                can.setDuracion(rs.getString("duracion"));
                can.setFecha(rs.getString("fecha"));
                can.setArtista_id(rs.getInt("artista_id"));
                can.setAlbum_id(rs.getInt("album_id"));
                can.setGenero_id(rs.getInt("genero_id"));
                can.setGrupo_id(rs.getInt("grupo_id"));
                can.setCancion_img(rs.getString("cancion_img"));
            }
        } finally {
            this.desconectar();
        }
        return can;
    }

    @Override
    public List<Cancion> getAll() throws Exception {
        List<Cancion> canciones = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT c.*, a.nombre AS artista, al.titulo AS album, g.nombre AS genero\n"
                    + "FROM cancion c\n"
                    + "LEFT JOIN artista a ON c.artista_id = a.artista_id\n"
                    + "LEFT JOIN album al ON c.album_id = al.album_id\n"
                    + "LEFT JOIN genero g ON c.genero_id = g.genero_id;";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setCancion_id(rs.getInt("cancion_id"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setDuracion(rs.getString("duracion"));
                cancion.setFecha(rs.getString("fecha"));
                cancion.setArtista_id(rs.getInt("artista_id"));
                cancion.setAlbum_id(rs.getInt("album_id"));
                cancion.setGenero_id(rs.getInt("genero_id"));
                cancion.setGrupo_id(rs.getInt("grupo_id"));
                cancion.setCancion_img(rs.getString("cancion_img"));
                cancion.setArtista(rs.getString("artista"));
                cancion.setAlbum(rs.getString("album"));
                cancion.setGenero(rs.getString("genero"));
                cancion.setGrupo(rs.getString("grupo"));

                canciones.add(cancion);
            }

        } finally {
            this.desconectar();
        }
        return canciones;
    }

}
