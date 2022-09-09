
package com.globalmarket.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
    
    @GetMapping("/")
    public String cargarPaginaPrincipal(){
        return "index";
        
    }
    
}
