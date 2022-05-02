package logica;

import java.util.ArrayList;

public class Proveedor {
    
    private String nombre;
    private ArrayList<Producto> productos = new ArrayList();
    private ArrayList<Comision> comisiones = new ArrayList();

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public ArrayList<Comision> getComisiones() {
        return comisiones;
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public boolean agregarComision(String nombre, String porcentaje, Producto producto) {
        Comision comision = new Comision(nombre, porcentaje, producto);
        if(producto != null & comision.validar() && producto.validar() && !existeComision(nombre)) {
            comisiones.add(comision);
            producto.agregarComision(comision);
            return true;
        }
        return false;
    }
    
    public boolean existeComision(String nombre) {
        for(Comision comision : comisiones) {
            if(nombre.equals(comision.getNombre())){
                return true;
            }
        }
        return false;
    }
    
    public boolean tieneComisiones() {
        return comisiones.size() > 0;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public float getTotalAPagar() {
        float total = 0;
        for(Comision comision: comisiones) {
            total += comision.getTotalAPagar();
        }
        return total;
    }
}
