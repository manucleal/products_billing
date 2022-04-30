package logica;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private int precio;
   // private int stock;
    private int unidades;
    private Proveedor proveedor;
    private int codigo;
    
    private ArrayList<Comision> comisiones = new ArrayList();

    public Producto() {}

    public Producto(String nombre, int precio, int stock, Proveedor proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = stock;
        this.proveedor = proveedor;
        
        //proveedor.agregar(this);
    }

    public int getUnidades() {
        return unidades;
    }

    public boolean setUnidades(int unidades) {
        
        if( validarUnidades( unidades)){
            this.unidades = unidades;
            return true;
        }
        return false;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public float getPrecio() {
        return precio;
    }

    public boolean setPrecio(int precio) {
        if(validarPrecio(precio)){
            this.precio = precio;
            return true;
        }
        return false;
    }   

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if(validarNombre(nombre)){
            this.nombre = nombre;
            return true;
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int cod) {
       codigo = cod;
    }

    public boolean validar() {
        return validarNombre(nombre) && validarPrecio(precio) && validarUnidades(unidades) && proveedor!=null;
    }

    private boolean validarUnidades(int unidades) {
        if(unidades>0){
            
            return true;
        }
        return false;
        
    }

    private boolean validarPrecio(int precio) {
        return precio>0;
       
    }

    private boolean validarNombre(String nombre) {
        return nombre!=null && !nombre.trim().equals("");
     }

    protected void modificarStock(int cantidad) {
        unidades+=cantidad;
    }

    public ArrayList<Comision> getComisiones() {
        return comisiones;
    }
    
    public boolean agregarComision(Comision comision){
        return comisiones.add(comision);    
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
