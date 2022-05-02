/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
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
    private ArrayList<Factura> facturas = new ArrayList<>();        
    
    public Comision(String nombre, String porcentaje, Producto producto) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.producto = producto;
    }
    
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

    public ArrayList<Factura> getFacturas() {
        return facturas;
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

    public void agregarFactura(Factura factura) {
        if(!facturas.contains(factura)) {
            facturas.add(factura);
        }
    }
    
    public float getTotalAPagar() {
        float total = 0;
        for(Factura factura : facturas) {
            for(LineaFactura lineaFactura: factura.getLineas()) {                
                if(lineaFactura.tieneProducto(producto) && validarFechas(fechaCreacion, factura.getFecha())) {
                    total += totalPorLineaFactura(lineaFactura);
                }
            }
        }
        return total;
    }

    public int getCantidadUnidadesVendidas() {
        int unidadesVendidas = 0;
        for(Factura factura : facturas) {
            unidadesVendidas += factura.getCantidadUnidadesVendidasPorFactura(producto);
        }
        return unidadesVendidas;
    }
    
    private boolean validarFechas(Date fechaComision, Date fechaFactura) {
        return fechaComision.before(fechaFactura) || fechaComision.equals(fechaFactura);
    }
    
    private Double totalPorLineaFactura(LineaFactura lineaFactura) {
        return lineaFactura.total() * Double.parseDouble(porcentaje) / 100;
    }
    
}
