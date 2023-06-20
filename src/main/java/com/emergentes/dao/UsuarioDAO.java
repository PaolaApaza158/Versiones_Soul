/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.util.List;

/**
 *
 * @author HP
 */
public interface UsuarioDAO {
public void insert(Usuario usuario) throws Exception;
    public void update(Usuario usuario) throws Exception;
    public void delete(int id) throws Exception;
    public Usuario getById(int id) throws Exception;
    public List<Usuario> getAll() throws Exception;
}
