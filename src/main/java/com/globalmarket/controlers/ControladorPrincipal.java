package com.globalmarket.controlers;

import com.globalmarket.services.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * iRUTA PRINCIPAL index.html / FORMULARIO PARA MOSTRAR listacategorias.html
 * /categorias FORMULARIO PARA CREAR/ACTUALIZAR CATEGORIAS categoriaform.html
 * /categorias/form/i{id}
 *
 * @author jlvid
 */
@Controller
public class ControladorPrincipal {

    @Autowired
    private CategoriaServicio servicio;

    @GetMapping("/")
    public String cargarPaginaPrincipal() {
        return "index";

    }

    @GetMapping("/login")
    public String cargarIniciarSesion() {
        return "login";

    }

    @GetMapping("/categorias")
    public String cargarListaCategorias(Model model, @RequestParam(value = "criterio", required = false) String criterio) {
        if (criterio == null) {
            model.addAttribute("categorias", servicio.consultarCategorias());
        }else{
            model.addAttribute("categorias", servicio.consultarCategoria(criterio));
        }

        return "listacategorias";

    }

    @GetMapping("/categorias/form")
    public String cargarFormCategorias() {
        return "formcategorias";

    }
}
