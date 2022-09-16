
package com.globalmarket.services;

import com.globalmarket.entities.Categoria;
import com.globalmarket.repositories.ICategoriaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio {
    
    @Autowired
    private ICategoriaRepositorio repo;
    
    public Categoria crearNuevaCategoria(Categoria c){
        Categoria cat =repo.save(c);
        return cat;
    }
    
    public List<Categoria> consultarCategoria(String criterio){
        List<Categoria> lista =repo.findByNombreCategoriaContaining(criterio);
        return lista;
    }
    
    public List<Categoria> consultarCategoriaHab(){
        List<Categoria> lista =repo.findByEstadoCategoriaTrue();
        return lista;
    }
    
    public List<Categoria> consultarCategorias(){
        List<Categoria> lista = repo.findAll();
        return lista;
    }
    
    public Categoria consultarCategoria (int id){
 
        Categoria c =repo.findById(id).get();
        return c;
    }
    
    public Categoria actualizarCategoria(Categoria c){
        Categoria cat =repo.save(c);
        return cat;
    }
    
    public void eliminarCategoria(Categoria c){
        repo.deleteById(c.getIdCategoria());
        
    }
    
}
