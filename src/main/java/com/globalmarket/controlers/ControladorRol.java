
package com.globalmarket.controlers;

import com.globalmarket.entities.Rol;
import com.globalmarket.services.RolServicio;
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
public class ControladorRol {

    @Autowired
    private RolServicio rol;
/*
    @GetMapping("/")
    public String cargarPaginaPrincipal() {
        return "index";

    }

    @GetMapping("/login")
    public String cargarIniciarSesion() {
        return "login";

    }
*/
    @GetMapping("/roles")
    public String cargarListaRol(Model model, @RequestParam(value = "criterio", required = false) String criterio) {
        if (criterio == null) {
            model.addAttribute("roles", rol.consultarRoles());
        }else{
            model.addAttribute("roles", rol.consultarRol(criterio));
        }
        return "listaroles";
    }

    @PostMapping("/roles")
    public String guardarRol(@ModelAttribute("rol") Rol c){
        rol.crearNuevoRol(c);
        return "redirect:/roles";
    }

    @GetMapping("/roles/form")
    public String cargarFormNuevoRol(Model modelo){
        Rol c = new Rol();
        modelo.addAttribute("rol", c);
        return "formroles";
    }
    
    @GetMapping("/roles/form/{id}")
    public String cargarFormRolesExistente(Model modelo, @PathVariable int id){
        Rol c = rol.consultarRol(id);
        modelo.addAttribute("rol", c);
        return "formroles";
    }
    
    
    @GetMapping("/roles/eliminar/{id}")
    public String eliminarRolExistente(Model modelo, @PathVariable int id){
        Rol c = rol.consultarRol(id);
        rol.eliminarRol(c);
        return "redirect:/roles";
    }  
}

