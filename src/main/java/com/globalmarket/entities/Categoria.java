
package com.globalmarket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "categorias")
public class Categoria {
    
    @Id
    @Column(name = "idCategoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    
    @Column(name = "nombreCategoria", nullable = false, length = 50, unique=true)
    private String nombreCategoria;
    
    @Column(name = "estadoCategoria", columnDefinition = "TINYINT(1)")
    private boolean estadoCategoria;

    public Categoria() {
    }

    public Categoria(String nombreCategoria, boolean estadoCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.estadoCategoria = estadoCategoria;
    }

    public Categoria(int idCategoria, String nombreCategoria, boolean estadoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.estadoCategoria = estadoCategoria;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean isEstadoCategoria() {
        return estadoCategoria;
    }

    public void setEstadoCategoria(boolean estadoCategoria) {
        this.estadoCategoria = estadoCategoria;
    }

}
