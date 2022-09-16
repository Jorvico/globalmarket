
package com.globalmarket.repositories;

import com.globalmarket.entities.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepositorio extends JpaRepository<Categoria, Integer>{
    
   public List <Categoria> findByNombreCategoriaContaining(String criterio);
   public List <Categoria> findByEstadoCategoriaTrue();
    
}
