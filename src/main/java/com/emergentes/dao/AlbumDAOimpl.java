
package com.emergentes.dao;

import com.emergentes.modelo.Album;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAOimpl extends ConexionDB implements AlbumDAO{

    @Override
    public void insert(Album album) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO album (titulo, artista_id, genero_id, fecha_lanzamiento, portada_img) values (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, album.getTitulo());
            ps.setInt(2, album.getArtista_id());
            ps.setInt(3, album.getGenero_id());
            ps.setDate(4, album.getFecha_lanzamiento());
            ps.setString(5, album.getPortada_img());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Album album) throws Exception {
        try {
            this.conectar();
            String sql ="UPDATE album SET titulo=?, artista_id=?, genero_id=?, fecha_lanzamiento=?, portada_img=? where album_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, album.getTitulo());
            ps.setInt(2, album.getArtista_id());
            ps.setInt(3, album.getGenero_id());
            ps.setDate(4, album.getFecha_lanzamiento());
            ps.setString(5, album.getPortada_img());
            ps.setInt(6, album.getAlbum_id());
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
            String sql = "DELETE FROM album WHERE album_id = ?";
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
    public Album getById(int id) throws Exception {
        Album alb = new Album();
        try {
            this.conectar ();
            String sql = "SELECT * FROM album WHERE album_id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alb.setAlbum_id(rs.getInt("album_id"));
                alb.setTitulo(rs.getString("titulo"));
                alb.setArtista_id(rs.getInt("artista_id"));
                alb.setGenero_id(rs.getInt("genero_id"));
                alb.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));
                alb.setPortada_img(rs.getString("portada_img"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return alb;
    }

    @Override
    public List<Album> getAll() throws Exception {
        List<Album> lista = null;
        try {
            this.conectar();
	    String sql = "SELECT al.*,a.nombre as artista,g.nombre as genero FROM album al ";
            sql += "LEFT JOIN artista a ON al.artista_id = a.artista_id ";
            sql += "LEFT JOIN genero g ON al.genero_id = g.genero_id";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Album>();
            while (rs.next()) {
                Album alb = new Album();
                alb.setAlbum_id(rs.getInt("album_id"));
                alb.setTitulo(rs.getString("titulo"));
                alb.setArtista_id(rs.getInt("artista_id"));
                alb.setGenero_id(rs.getInt("genero_id"));
                alb.setFecha_lanzamiento(rs.getDate("fecha_lanzamiento"));
                alb.setPortada_img(rs.getString("portada_img"));
		alb.setArtista(rs.getString("artista"));
                alb.setGenero(rs.getString("genero"));

                lista.add(alb);
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
