package com.globalmarket.controlers;

import com.globalmarket.entities.Categoria;
import com.globalmarket.entities.Producto;
import com.globalmarket.entities.Rol;
import com.globalmarket.entities.Usuario;
import com.globalmarket.services.CategoriaServicio;
import com.globalmarket.services.ProductoServicio;
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
public class ControladorProducto {

    @Autowired
    private ProductoServicio producto;

    @Autowired
    private CategoriaServicio categoria;

    @GetMapping("/productos")
    public String cargarListaProducto(Model model, @RequestParam(value = "criterio", required = false) String criterio) {
        if (criterio == null) {
            model.addAttribute("productos", producto.consultarProductos());
        } else {
            model.addAttribute("productos", producto.consultarProductos(criterio));
        }
        return "listaproductos";
    }

    @PostMapping("/productos")
    public String guardarUsuario(@ModelAttribute("producto") Producto p) {
        producto.crearProducto(p);
        return "redirect:/productos";
    }

    @GetMapping("/productos/form")
    public String cargarFormNuevoProducto(Model modelo) {
        Producto p = new Producto();
        List<Categoria> categorias = categoria.consultarCategoriaHab();
        modelo.addAttribute("producto", p);
        modelo.addAttribute("categorias", categorias);
        return "formproductos";
    }

    @GetMapping("/productos/form/{id}")
    public String cargarFormProductoExistente(Model modelo, @PathVariable int id) {
        Producto p = producto.consultarProducto(id);
        List<Categoria> categorias = categoria.consultarCategorias();
        modelo.addAttribute("producto", p);
        modelo.addAttribute("categorias", categorias);
        return "formproductos";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarRolExistente(Model modelo, @PathVariable int id) {
        Producto p = producto.consultarProducto(id);
        producto.eliminarProducto(p);
        return "redirect:/productos";
    }
}
