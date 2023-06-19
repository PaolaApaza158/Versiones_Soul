
package com.emergentes.dao;

import com.emergentes.modelo.Genero;
import java.util.List;

public interface GeneroDAO {
    public void insert(Genero genero) throws Exception;
    public void update(Genero cliente) throws Exception;
    public void delete(int id) throws Exception;
    public Genero getById(int id) throws Exception;
    public List<Genero> getAll() throws Exception;
}
