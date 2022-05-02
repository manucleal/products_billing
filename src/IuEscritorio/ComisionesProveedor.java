/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IuEscritorio;

import java.awt.Dimension;
import java.util.ArrayList;
import logica.Comision;
import logica.Fachada;
import logica.Producto;

/**
 *
 * @author ecoitino
 */
public class ComisionesProveedor extends javax.swing.JDialog {
    
    /**
     * Creates new form ComisionesProveedor
     */
    public ComisionesProveedor(java.awt.Frame parent, boolean modal, ArrayList<Comision> comisiones) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setSize(new Dimension(1000, 600));
        cargarComisiones(comisiones);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDataComisiones = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Comisiones");

        jScrollPane1.setViewportView(listaDataComisiones);

        jButton1.setText("Ver items");

        jLabel2.setText("Total a Pagar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(664, 723, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaDataComisiones;
    // End of variables declaration//GEN-END:variables
    private void cargarComisiones(ArrayList<Comision> comisiones) {
        listaDataComisiones.setListData(dibujarComisiones(comisiones));
    }

    private Object[] dibujarComisiones(ArrayList<Comision> comisiones) {
        ArrayList<String> listadoComisiones = new ArrayList();
        if(comisiones != null) {
            comisiones.forEach(comision -> {
                Producto producto = comision.getProducto();
                int cantidadUnidadesVendidas =  Fachada.getInstancia().getCantidadUnidadesVendidasPorProducto(producto);
                listadoComisiones.add(
                    "Nombre: " + comision.getNombre() +
                    " Fecha : " + comision.getFechaCreacionFormat() +
                    " Producto: " + producto.getNombre() +
                    " Precio: $ " + producto.getPrecio() +
                    " Total unidades vendidas: " + cantidadUnidadesVendidas +
                    " Porcentaje a pagar: % " + comision.getPorcentaje() +
                    " Total a pagar: NI IDEA"
                );
            });
        }
        return listadoComisiones.toArray();
    }
}
