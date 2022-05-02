package logica;

import java.util.ArrayList;
import java.util.Date;

public class Fachada {
    
    private static Fachada instancia;
    
    private final ControlClientes controlClientes = new ControlClientes();
    private final ControlFacturas controlFacturas = new ControlFacturas();
    private final ControlStock controlStock = new ControlStock();
    
    public static Fachada getInstancia(){
        
        if (instancia==null){
            instancia =  new Fachada();
        }
        return instancia;
    }
    
    public ArrayList<Cliente> getClientes() {
        return controlClientes.getClientes();
    }
    
    public ArrayList<Cliente> clientesNoCompraronProductoMenorPrecio(){
        return controlClientes.clientesNoCompraronProductoMenorPrecio();
    }
    
    public ArrayList<Cliente> clientesCompraronProductoMenorPrecio() {
        return controlClientes.clientesCompraronProductoMenorPrecio();
    }

    public boolean existeCliente(String unaCedula) {
           return controlClientes.existeCliente(unaCedula);
    }
    
    public Cliente buscarClientePorCedula(String unaCedula) {
           return controlClientes.buscarClientePorCedula(unaCedula);
    }
  
    public boolean agregarCliente(Cliente c){
        return controlClientes.agregar(c);
    }
    
    public ArrayList<Factura> getFacturas() {
        return controlFacturas.getFacturas();
    }
    
    public void agregarFactura(Factura unaFactura){
        controlFacturas.agregar(unaFactura);
    }
    
    public boolean clienteComproProducto(Cliente c, Producto p){
        return controlFacturas.clienteComproProducto(c, p);
    }
    
    public Date clienteFechaUltimaFacturaPorProducto(Cliente c, Producto p){
        return controlFacturas.clienteFechaUltimaFacturaPorProducto(c, p);
    }
    
    public ArrayList<Producto> getProductos() {
        return controlStock.getProductos();
    }

    public ArrayList<Proveedor> getProveedores() {
        return controlStock.getProveedores();
    }
    
    public ArrayList<Proveedor> getProveedoresConComisiones() {
        return controlStock.getProveedoresConComisiones();
    }
    
    public Producto getProductoMenorPrecio(){
        return controlStock.getProductoMenorPrecio();
    }
  
    public void agregarProveedor(Proveedor unProveedor){
        controlStock.agregar(unProveedor);
    }
    
    public  boolean agregarProducto(Producto unProducto){
        return controlStock.agregar(unProducto);
    }
    
    public Producto buscarProductoPorCodigo(int codigoProducto) {
        return controlStock.buscarProductoPorCodigo(codigoProducto);
    }
}
