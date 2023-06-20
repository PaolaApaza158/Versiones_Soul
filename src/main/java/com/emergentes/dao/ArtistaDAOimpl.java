package com.emergentes.dao;

import com.emergentes.modelo.Artista;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDAOimpl extends ConexionDB implements ArtistaDAO {

    @Override
    public void insert(Artista artista) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO artista (nombre, genero, fecha_nacimiento, nacionalidad, artista_img) values (?,?,?,?,?)");
            ps.setString(1, artista.getNombre());
            ps.setString(2, artista.getGenero());
            ps.setString(3, artista.getFecha_nacimiento());
            ps.setString(4, artista.getNacionalidad());
            ps.setString(5, artista.getArtista_img());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Artista artista) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE artista SET nombre=?, genero=?, fecha_nacimiento=?, nacionalidad=?, artista_img=? where artista_id = ?");
            ps.setString(1, artista.getNombre());
            ps.setString(2, artista.getGenero());
            ps.setString(3, artista.getFecha_nacimiento());
            ps.setString(4, artista.getNacionalidad());
            ps.setString(5, artista.getArtista_img());
            ps.setInt(6, artista.getArtista_id());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM artista WHERE artista_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Artista getById(int id) throws Exception {
        Artista art = new Artista();
        try {
            this.conectar ();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM artista WHERE artista_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                art.setArtista_id(rs.getInt("artista_id"));
                art.setNombre(rs.getString("nombre"));
                art.setGenero(rs.getString("genero"));
                art.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                art.setNacionalidad(rs.getString("nacionalidad"));
                art.setArtista_img(rs.getString("artista_img"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return art;
    }

    @Override
    public List<Artista> getAll() throws Exception {
        List<Artista> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM artista");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Artista>();

            while (rs.next()) {
                Artista art = new Artista();

                art.setArtista_id(rs.getInt("artista_id"));
                art.setNombre(rs.getString("nombre"));
                art.setGenero(rs.getString("genero"));
                art.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                art.setNacionalidad(rs.getString("nacionalidad"));
                art.setArtista_img(rs.getString("artista_img"));

                lista.add(art);
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
