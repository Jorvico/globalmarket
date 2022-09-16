
package com.globalmarket;

import com.globalmarket.entities.Categoria;
import com.globalmarket.entities.Producto;
import com.globalmarket.services.CategoriaServicio;
import com.globalmarket.services.ProductoServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductoUnitTest {
     
    @Autowired
    private ProductoServicio ProductoServicio;
    
    @Autowired
    private CategoriaServicio CategoriaServicio;
    
    @Test
    @Disabled
    public void comprobarSiGuardaUsuario(){
        
        Categoria c = CategoriaServicio.consultarCategoria(1);
        Producto p = new Producto("Sahmpoo h&s 200 ml", "babaria", "frasco", 1000, 2000, 10, c);
        Assertions.assertDoesNotThrow(() ->{
            ProductoServicio.crearProducto(p);
        }, "No se guardo el producto");
    }
    
    @Test
    @Disabled
    public void comprobarSiBuscaProducto(){
        
        List<Producto> buscaPorNombre = ProductoServicio.consultarProductos("Sahmpoo");
        Assertions.assertTrue(buscaPorNombre.size()>0, "No se encontro producto");
        
        
        List<Producto> buscaPorMarca = ProductoServicio.consultarProductos("babaria");
        Assertions.assertTrue(buscaPorMarca.size()>0, "No se encontro producto");
        
        List<Producto> buscaPorPresentacion = ProductoServicio.consultarProductos("frasco");
        Assertions.assertTrue(buscaPorPresentacion.size()>0, "No se encontro producto");
        
    }
    
    @Test
    @Disabled
    public void comprobarSiBuscaProductoPorCategoria(){
        
        List<Producto> buscaPorCategoria = ProductoServicio.consultarProductoPorCategoria("Electro");
        Assertions.assertTrue(buscaPorCategoria.size()>0, "No se encontro producto");

    }

}
