
package com.emergentes.dao;

import com.emergentes.modelo.Genero;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAOimpl extends ConexionDB implements GeneroDAO{

    @Override
    public void insert(Genero genero) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO genero (nombre) values (?)");
            ps.setString(1, genero.getNombre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }
    
    

    @Override
    public void update(Genero genero) throws Exception {
          try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE genero SET nombre=? where genero_id = ?");
            ps.setString(1, genero.getNombre());
            ps.setInt(2, genero.getGenero_id());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM genero WHERE genero_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Genero getById(int id) throws Exception {
         Genero gen = new Genero();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM genero WHERE genero_id = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                gen.setGenero_id(rs.getInt("genero_id"));
                gen.setNombre(rs.getString("nombre"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return gen;
    }

    @Override
    public List<Genero> getAll() throws Exception {
         List<Genero> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM genero");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Genero>();
            
            while(rs.next()){
                Genero gen = new Genero();
                
                gen.setGenero_id(rs.getInt("genero_id"));
                gen.setNombre(rs.getString("nombre"));
                
                lista.add(gen);
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
