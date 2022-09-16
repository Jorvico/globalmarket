
package com.globalmarket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @Column (name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    
    @Column (name = "documentousuario", nullable = false, unique = true)
    private int documentoUsuario;
    
    @Column (name = "nombreusuario", nullable = false, unique = true)
    private String nombreUsuario;   
    
    @Column (name = "contrasenausuario", nullable = false, unique = true)
    private String contrasenaUsuario;
    
    @Column(name = "estadousuario", columnDefinition = "TINYINT(1)")
    private boolean estadoUsuario;
    
    @ManyToOne
    @JoinColumn(name = "idrol")
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int documentoUsuario, String nombreUsuario, String contrasenaUsuario, boolean estadoUsuario, Rol rol) {
        this.documentoUsuario = documentoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.estadoUsuario = estadoUsuario;
        this.rol = rol;
    }

    public Usuario(int idUsuario, int documentoUsuario, String nombreUsuario, String contrasenaUsuario, boolean estadoUsuario, Rol rol) {
        this.idUsuario = idUsuario;
        this.documentoUsuario = documentoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.estadoUsuario = estadoUsuario;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(int documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public boolean isEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
}
