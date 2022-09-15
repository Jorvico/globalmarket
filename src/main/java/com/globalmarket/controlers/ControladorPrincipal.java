package com.globalmarket.controlers;

import com.globalmarket.entities.Categoria;
import com.globalmarket.services.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria c){
        servicio.crearNuevaCategoria(c);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/form")
    public String cargarFormNuevaCategorias(Model modelo){
        Categoria c = new Categoria();
        modelo.addAttribute("categoria", c);
        return "formcategorias";
    }
    
    @GetMapping("/categorias/form/{id}")
    public String cargarFormCategoriasExistente(Model modelo, @PathVariable int id){
        Categoria c = servicio.consultarCategoria(id);
        modelo.addAttribute("categoria", c);
        return "formcategorias";
    }
    
    
    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoriaExistente(Model modelo, @PathVariable int id){
        Categoria c = servicio.consultarCategoria(id);
        servicio.eliminarCategoria(c);
        return "redirect:/categorias";
    }
    
    
}
