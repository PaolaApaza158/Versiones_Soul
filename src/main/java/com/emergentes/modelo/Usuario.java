
package com.emergentes.modelo;

public class Usuario {
    private int usuario_id;
    private String email;
    private String password;

    public Usuario() {
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usuario_id=" + usuario_id + ", email=" + email + ", password=" + password + '}';
    }
    
}
