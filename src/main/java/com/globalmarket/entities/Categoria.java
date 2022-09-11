
package com.globalmarket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "categorias")
public class Categoria {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", nullable = false, length = 50, unique=true)
    private String nombre;
    
    @Column(name = "estado_cate", columnDefinition = "TINYINT(1)")
    private boolean estado_cate;

    public Categoria() {
    }

    public Categoria(String nombre, boolean estado_cate) {
        this.nombre = nombre;
        this.estado_cate = estado_cate;
    }

    public Categoria(int id, String nombre, boolean estado_cate) {
        this.id = id;
        this.nombre = nombre;
        this.estado_cate = estado_cate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_cate() {
        return nombre;
    }

    public void setNombre_cate(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado_cate() {
        return estado_cate;
    }

    public void setEstado_cate(boolean estado_cate) {
        this.estado_cate = estado_cate;
    }

    
   
    
}
