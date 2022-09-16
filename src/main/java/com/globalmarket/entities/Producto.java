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
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "idproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "nombreproducto", nullable = false, unique = true, length = 50)
    private String nombreProducto;

    @Column(name = "marcaproducto", nullable = false, unique = true, length = 50)
    private String marcaProducto;

    @Column(name = "presentacionproducto", nullable = true, unique = true, length = 50)
    private String presentacionProducto;

    @Column(name = "costoproducto", nullable = false)
    private int costoProducto;

    @Column(name = "precioventaproducto", nullable = false)
    private int precioVentaProducto;
    
    @Column(name = "inventarioactualproducto", nullable = false)
    private int inventarioActualProducto;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String nombreProducto, String marcaProducto, String presentacionProducto, int costoProducto, int precioVentaProducto, int inventarioActualProducto, Categoria categoria) {
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.presentacionProducto = presentacionProducto;
        this.costoProducto = costoProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.inventarioActualProducto = inventarioActualProducto;
        this.categoria = categoria;
    }

    public Producto(int idProducto, String nombreProducto, String marcaProducto, String presentacionProducto, int costoProducto, int precioVentaProducto, int inventarioActualProducto, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.presentacionProducto = presentacionProducto;
        this.costoProducto = costoProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.inventarioActualProducto = inventarioActualProducto;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getPresentacionProducto() {
        return presentacionProducto;
    }

    public void setPresentacionProducto(String presentacionProducto) {
        this.presentacionProducto = presentacionProducto;
    }

    public int getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }

    public int getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(int precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public int getInventarioActualProducto() {
        return inventarioActualProducto;
    }

    public void setInventarioActualProducto(int inventarioActualProducto) {
        this.inventarioActualProducto = inventarioActualProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
