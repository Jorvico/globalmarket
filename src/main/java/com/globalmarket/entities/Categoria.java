
package com.globalmarket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    
    @Column(name = "nombre_cate", nullable = false, length = 50, unique=true)
    private String nombre_cate;
    
    @Column(name = "estado_cate", columnDefinition = "TINYINT(1)")
    private boolean estado_cate;

    public Categoria() {
    }

    public Categoria(String nombre_cate) {
        this.nombre_cate = nombre_cate;
    }

    public Categoria(int id_categoria, String nombre_cate) {
        this.id_categoria = id_categoria;
        this.nombre_cate = nombre_cate;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_cate() {
        return nombre_cate;
    }

    public void setNombre_cate(String nombre_cate) {
        this.nombre_cate = nombre_cate;
    }

    public boolean isEstado_cate() {
        return estado_cate;
    }

    public void setEstado_cate(boolean estado_cate) {
        this.estado_cate = estado_cate;
    }

   
    
}
