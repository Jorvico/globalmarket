package com.globalmarket;

import com.globalmarket.entities.Categoria;
import com.globalmarket.services.CategoriaServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GlobalmarketApplicationTests {

    @Autowired
    private CategoriaServicio servicio;

    @Test
    @Disabled

    void probarCreacionNuevaCategoria() {
        Categoria c = new Categoria("Aseo", true);
        Categoria guardado = servicio.crearNuevaCategoria(c);
        Assertions.assertTrue(guardado.getIdCategoria() > 0, "Error no se guardo la categoria");
    }

    @Test
    @Disabled
    void probarSiExisteUnaCategoriaAseo() {
        List<Categoria> lista = servicio.consultarCategoria("Aseo");

        Assertions.assertTrue(lista.size() > 0, "Error no se encontro la categoria aseo");
    }

    @Test
    @Disabled
    void probarSiExisteUnaCategoriaId1() {
        Categoria encontrado = servicio.consultarCategoria(5);

        Assertions.assertTrue(encontrado.getIdCategoria() == 5, "Error no se encontro la categoria con id 1");
    }

}
