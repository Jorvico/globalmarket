
package com.globalmarket.services;


import com.globalmarket.entities.Rol;
import com.globalmarket.repositories.IRolRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicio {
    
    @Autowired
    private IRolRepositorio repo;
    
    public Rol crearNuevoRol(Rol c){
        Rol cat =repo.save(c);
        return cat;
    }
    
    public List<Rol> consultarRol(String criterio){
        List<Rol> lista =repo.findByNombreRolContaining(criterio);
        return lista;
    }
    
    public List<Rol> consultarRoles(){
        List<Rol> lista = repo.findAll();
        return lista;
    }
    
    public Rol consultarRol (int id){
 
        Rol c =repo.findById(id).get();
        return c;
    }
    
    public Rol actualizarRol(Rol c){
        Rol cat =repo.save(c);
        return cat;
    }
    
    public void eliminarRol(Rol c){
        repo.deleteById(c.getIdRol());
        
    }
}

