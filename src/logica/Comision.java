/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ecoitino
 */
public class Comision {
    
    private String nombre;
    private Date fechaCreacion = new Date();
    private int porcentaje;
    private Producto producto;

    public Comision(String nombre, int porcentaje, Producto producto) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.producto = producto;
    }
    
    private ArrayList<LineaFactura> LineasFactura = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public Producto getProducto() {
        return producto;
    }

    public ArrayList<LineaFactura> getLineasFactura() {
        return LineasFactura;
    }        
    
}
