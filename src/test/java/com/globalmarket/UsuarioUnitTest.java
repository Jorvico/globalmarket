
package com.globalmarket;

import com.globalmarket.entities.Rol;
import com.globalmarket.entities.Usuario;
import com.globalmarket.services.RolServicio;
import com.globalmarket.services.UsuarioServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioUnitTest {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private RolServicio RolServicio;
    
    @Test
    @Disabled
    public void comprobarSiGuardaUsuario(){
        
        Rol r = RolServicio.consultarRol(1);
        Usuario u = new Usuario(1023882002, "Deisy", "123450",true, r);
        Assertions.assertDoesNotThrow(() ->{
            usuarioServicio.crearUsuario(u);
        }, "No se gurado el usuario");
    }
    
    @Test
    public void comprobarSiBuscaUsuario(){
        
        List<Usuario> buscaPorNombre = usuarioServicio.consultarUsuarios("Jorge");
        Assertions.assertTrue(buscaPorNombre.size()>0, "No se encontro nombre");
        
        
        List<Usuario> buscaPorDocumento = usuarioServicio.consultarUsuarios(1023885432);
        Assertions.assertTrue(buscaPorDocumento.size()>0, "No se encontro documento");
    }
    
    @Test
    public void comprobarSiBuscaUsuarioPorRol(){
        
        List<Usuario> buscaPorRol = usuarioServicio.consultarUsuariosPorRol("Administrador");
        Assertions.assertTrue(buscaPorRol.size()>0, "No se encontro nombre");

    }
            
        
}
