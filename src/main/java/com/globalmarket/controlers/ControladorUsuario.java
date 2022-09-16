
package com.globalmarket.controlers;

import com.globalmarket.entities.Rol;
import com.globalmarket.entities.Usuario;
import com.globalmarket.services.RolServicio;
import com.globalmarket.services.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorUsuario {
    
    
    @Autowired
    private UsuarioServicio usuario;
    
    @Autowired
    private RolServicio rol;
    

    @GetMapping("/usuarios")
    public String cargarListaUsuario(Model model, @RequestParam(value = "criterio", required = false) String criterio) {
        if (criterio == null) {
            model.addAttribute("usuarios", usuario.consultarUsuarios());
        }else{
            model.addAttribute("usuarios", usuario.consultarUsuarios(criterio));       
        }
        return "listausuarios";
    }

    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario c){
        usuario.crearUsuario(c);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/form")
    public String cargarFormNuevoUsuario(Model modelo){
        Usuario c = new Usuario();
        List<Rol> roles = rol.consultarRoles();
        modelo.addAttribute("usuario", c);
        modelo.addAttribute("roles", roles);
        return "formusuarios";
    }
    
    @GetMapping("/usuarios/form/{id}")
    public String cargarFormUsuarioExistente(Model modelo, @PathVariable int id){
        Usuario c = usuario.consultarUsuario(id);
        List<Rol> roles = rol.consultarRoles();
        modelo.addAttribute("usuario", c);
        modelo.addAttribute("roles", roles);
        return "formusuarios";
    }
    
    
    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarRolExistente(Model modelo, @PathVariable int id){
        Usuario c = usuario.consultarUsuario(id);
        usuario.eliminarUsuario(c);
        return "redirect:/usuarios";
    } 
}
