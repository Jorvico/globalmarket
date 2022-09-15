
package com.globalmarket.repositories;

import com.globalmarket.entities.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepositorio extends JpaRepository<Rol, Integer>{
    
   public List <Rol> findByNombreRolContaining(String criterio);
    
}

