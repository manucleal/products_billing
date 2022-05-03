package logica;

public class DatosPrueba {

    public static void cargar(){
       
        Fachada logica = Fachada.getInstancia();
        
        Proveedor pA = new Proveedor("Proveedor A");
        Proveedor pB = new Proveedor("Proveedor B");
        Proveedor pC = new Proveedor("Proveedor C");       
        
        logica.agregarProveedor(pA);
        logica.agregarProveedor(pB);
        logica.agregarProveedor(pC);
        
        Producto caramelo = new Producto("Caramelo",2,3000,pA);
        Producto camisa = new Producto("Camisa",1300,1000,pB);
        Producto computadora = new Producto("Computadora",20000,40,pC);
        
        pA.agregarComision("Comision 1","10",caramelo);
        pA.agregarComision("Comision 2","5",caramelo);
        
        Cliente juan = new Cliente("12345678","Juan");
        Factura f1 = new Factura(juan);
        f1.agregarProducto(30, caramelo);
        f1.agregarProducto(2, camisa);
        f1.agregarProducto(1, computadora);
        
        logica.agregarFactura(f1);
        
        
        pC.agregarComision("Comision 3","80",computadora);
        
        logica.agregarProducto(caramelo);
        logica.agregarProducto(camisa);
        //logica.agregarProducto(computadora);

        
        Cliente ana = new Cliente("13456789","Ana");
        Cliente mario = new Cliente("21234567","Mario");
        
        logica.agregarCliente(juan);
        logica.agregarCliente(ana);
        logica.agregarCliente(mario);
        
        
        Factura f2 = new Factura(ana);
        f2.agregarProducto(400, caramelo);
        f2.agregarProducto(20, camisa);
        //f2.agregarProducto(10, computadora);
        
        logica.agregarFactura(f2);
        
        Factura f3 = new Factura(mario);
      
        f3.agregarProducto(1, camisa);
        //f3.agregarProducto(1, computadora);
        
        logica.agregarFactura(f3);
    }
}
