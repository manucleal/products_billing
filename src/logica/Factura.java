package logica;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    
    private Cliente cliente;
    private ArrayList <LineaFactura> lineas = new ArrayList();
    private Date fecha;
    private int numero;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<LineaFactura> getLineas() {
        return lineas;
    }

    public boolean agregar(int cantidad, Producto p){
        if (cantidad == 0) {
            return false;
        }
        if (cantidad > p.getUnidades()) {
            return false;
        }
        for (LineaFactura linea: lineas) {
            if (linea.getProducto() == p) {
                return linea.incrementar(cantidad);
            }
        }
        lineas.add(new LineaFactura(p, cantidad));
        return true;
    }
    
    public boolean agregarPorCodigoProducto(int cantidad, int codigoProducto){
        Producto p = Fachada.getInstancia().buscarProductoPorCodigo(codigoProducto);
        if (p == null){
            return false;
        }
        return agregar(cantidad, p);
    }
    
    public boolean tieneProducto(Producto unP){
        boolean ret = false;
        for(LineaFactura l: lineas){
            if(l.tieneProducto(unP)){
                ret = true;
            }
        }
        return ret;       
    }

    @Override
    public String toString() {
        return "Factura{" + "cliente=" + cliente + ", lineas=" + lineas + '}';
    }

    public float total() {
        float total = 0;
        for (LineaFactura linea : lineas) {
            total += linea.total();
        }
        return total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void asignarFecha() {
        this.setFecha(new Date());
    }
    
    protected void bajarStock() {
        for(LineaFactura lf:lineas){
            lf.bajarStock();
        }
    }
}
