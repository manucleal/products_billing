/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ecoitino
 */
public class Comision {
    
    private String nombre;
    private Date fechaCreacion = new Date();
    private String porcentaje;
    private Producto producto;

    public Comision(String nombre, String porcentaje, Producto producto) {
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

    public String getPorcentaje() {
        return porcentaje;
    }

    public Producto getProducto() {
        return producto;
    }

    public ArrayList<LineaFactura> getLineasFactura() {
        return LineasFactura;
    }        

    public boolean validar() {
        return esNumero(porcentaje) && validarNombre(nombre);
    }
    
    private boolean validarNombre(String nombre) {
        return nombre!=null && !nombre.trim().equals("");
    }

    private boolean validarPorcentaje(Double porcentaje) {
        return porcentaje > 0 && porcentaje <= 100;
    }
    
    public boolean esNumero(String porcentaje) {
        try {
            Double d = Double.parseDouble(porcentaje);
            return validarPorcentaje(d);
        } catch(NumberFormatException e){
            return false;
        }
    }
    
}
