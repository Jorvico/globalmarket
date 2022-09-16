
package com.globalmarket.services;

import com.globalmarket.entities.Usuario;
import com.globalmarket.repositories.IUsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    
    @Autowired
    private IUsuarioRepositorio repo;
    
    public List<Usuario> consultarUsuarios(){
        return repo.findAll();
    }
    
    public List<Usuario> consultarUsuarios(String criterio){
        return repo.findByNombreUsuarioContaining(criterio);
    }
    
    public List<Usuario> consultarUsuariosPorRol(String criterio){
        return repo.findByRolNombreRolIs(criterio);
    }
    
    public List<Usuario> consultarUsuarios(Integer criterio){
        return repo.findByDocumentoUsuario(criterio);
    }
    
    public Usuario crearUsuario(Usuario u){
        return repo.save(u);
    }
    
    public Usuario consultarUsuario(int id){
        return repo.findById(id).orElse(null);
    }
    
    public void eliminarUsuario(Usuario u){
        repo.deleteById(u.getIdUsuario());
        
    }
    

}
