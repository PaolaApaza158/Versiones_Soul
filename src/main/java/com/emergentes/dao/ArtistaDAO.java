
package com.emergentes.dao;
import com.emergentes.modelo.Artista;
import java.util.List;
public interface ArtistaDAO {
    public void insert(Artista artista) throws Exception;
    public void update(Artista artista) throws Exception;
    public void delete(int id) throws Exception;
    public Artista getById(int id) throws Exception;
    public List<Artista> getAll() throws Exception;
}
