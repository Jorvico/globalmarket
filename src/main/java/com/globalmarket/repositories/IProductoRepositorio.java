
package com.globalmarket.repositories;

import com.globalmarket.entities.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto, Integer>{
    public List<Producto> findByNombreProductoContainingOrMarcaProductoContainingOrPresentacionProductoContaining(String c1, String c2, String c3);
    public List<Producto> findByCategoriaNombreCategoriaIs(String categoria);
}
