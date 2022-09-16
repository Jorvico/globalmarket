
package com.globalmarket.services;

import com.globalmarket.entities.Producto;
import com.globalmarket.entities.Usuario;
import com.globalmarket.repositories.IProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoServicio {
    
    @Autowired
    private IProductoRepositorio repo;
    
    public List<Producto> consultarProductos(){
        return repo.findAll();
    }
    
    public List<Producto> consultarProductos(String criterio){
        return repo.findByNombreProductoContainingOrMarcaProductoContainingOrPresentacionProductoContaining(criterio, criterio, criterio);
    }

    public List<Producto> consultarProductoPorCategoria(String categoria){
        return repo.findByCategoriaNombreCategoriaIs(categoria);
    }
    public Producto crearProducto(Producto p){
        return repo.save(p);
    }
    
    public Producto consultarProducto(int id){
        return repo.findById(id).orElse(null);
    }
    
    public void eliminarProducto(Producto p){
        repo.deleteById(p.getIdProducto());
        
    }
    
}
