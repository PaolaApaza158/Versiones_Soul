
package com.emergentes.dao;

import com.emergentes.modelo.Grupo;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAOimpl extends ConexionDB implements GrupoDAO{

    @Override
    public void insert(Grupo grupo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO grupo (nombre, grupo_img) values (?,?)");
            ps.setString(1, grupo.getNombre());
            ps.setString(2, grupo.getGrupo_img());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Grupo grupo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE grupo SET nombre=?, grupo_img=? where grupo_id = ?");
            ps.setString(1, grupo.getNombre());
            ps.setString(2, grupo.getGrupo_img());
            ps.setInt(3, grupo.getGrupo_id());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM grupo WHERE grupo_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Grupo getById(int id) throws Exception {
        Grupo gru = new Grupo();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM grupo WHERE grupo_id = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                gru.setGrupo_id(rs.getInt("grupo_id"));
                gru.setNombre(rs.getString("nombre"));
                gru.setGrupo_img(rs.getString("grupo_img"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return gru;
    }

    @Override
    public List<Grupo> getAll() throws Exception {
        List<Grupo> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM grupo");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Grupo>();
            
            while(rs.next()){
                Grupo gru = new Grupo();
                
                gru.setGrupo_id(rs.getInt("grupo_id"));
                gru.setNombre(rs.getString("nombre"));
                gru.setGrupo_img(rs.getString("grupo_img"));
                
                lista.add(gru);
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
