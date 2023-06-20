
package com.emergentes.dao;
import com.emergentes.modelo.Cancion;
import java.util.List;
public interface CancionDAO {
    public void insert(Cancion cancion) throws Exception;
    public void update(Cancion cancion) throws Exception;
    public void delete(int id) throws Exception;
    public Cancion getById(int id) throws Exception;
    public List<Cancion> getAll() throws Exception;
}