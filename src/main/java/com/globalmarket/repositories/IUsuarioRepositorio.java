
package com.globalmarket.repositories;

import com.globalmarket.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    public List<Usuario> findByNombreUsuarioContaining(String c1);
    public List<Usuario> findByDocumentoUsuario(int c1);
    public List<Usuario> findByRolNombreRolIs(String c1);
}
