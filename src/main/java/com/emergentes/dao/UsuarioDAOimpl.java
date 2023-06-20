package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO {

    @Override
    public void insert(Usuario usr) throws Exception {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios (email, password) values (?,sha1(?))");
        ps.setString(1, usr.getEmail());
        ps.setString(2, usr.getPassword());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario usr) throws Exception {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET email=?, password=sha1(?) where usuario_id = ?");
        ps.setString(1, usr.getEmail());
        ps.setString(2, usr.getPassword());
        ps.setInt(3, usr.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios WHERE usuario_id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usr = new Usuario();
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE usuario_id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usr.setUsuario_id(rs.getInt("usuario_id"));
            usr.setEmail(rs.getString("email"));
            usr.setPassword(rs.getString("password"));
        }
        this.desconectar();
        return usr;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Usuario>();

        while (rs.next()) {
            Usuario usr = new Usuario();
            usr.setUsuario_id(rs.getInt("usuario_id"));
            usr.setEmail(rs.getString("email"));
            usr.setPassword(rs.getString("password"));

            lista.add(usr);
        }
        rs.close();
        ps.close();
        
        this.desconectar();
        return lista;
    }
}
