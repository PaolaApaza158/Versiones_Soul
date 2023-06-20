
package com.emergentes.dao;

import com.emergentes.modelo.Grupo;
import java.util.List;

public interface GrupoDAO {
    public void insert(Grupo cliente) throws Exception;
    public void update(Grupo cliente) throws Exception;
    public void delete(int id) throws Exception;
    public Grupo getById(int id) throws Exception;
    public List<Grupo> getAll() throws Exception;
}
