/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IuEscritorio;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Fachada;
import logica.Comision;
import logica.Producto;
import logica.Proveedor;

/**
 *
 * @author ecoitino
 */
public class CrearComision extends javax.swing.JDialog {
    
    private Proveedor proveedorActual;
    private Producto productoProveedorActual;
    private ArrayList<Producto> productosProveedor;
    
    
    /**
     * Creates new form CrearComision
     */
    public CrearComision(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Dashboard Proveedores");
        cargarProveedores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaDataProveedores = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaDataComisiones = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDataProductos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        textFieldNombreComision = new javax.swing.JTextField();
        textFieldPorcentajeComision = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        guardarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaDataProveedores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaDataProveedoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaDataProveedores);

        jLabel1.setText("Proveedores");

        jScrollPane2.setViewportView(listaDataComisiones);

        jLabel2.setText("Comisiones");

        listaDataProductos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaDataProductosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaDataProductos);

        jLabel3.setText("Productos");

        textFieldNombreComision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreComisionActionPerformed(evt);
            }
        });

        textFieldPorcentajeComision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPorcentajeComisionActionPerformed(evt);
            }
        });

        jLabel4.setText("Porcentaje Comisión");

        jLabel5.setText("Nombre Comisión:");

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(guardarButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldNombreComision)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textFieldPorcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 101, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldNombreComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPorcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardarButton)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaDataProveedoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaDataProveedoresValueChanged
        cargarDatosProveedor(listaDataProveedores.getSelectedValue());
    }//GEN-LAST:event_listaDataProveedoresValueChanged

    private void listaDataProductosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaDataProductosValueChanged
        int posicion = listaDataProductos.getSelectedIndex();
        if(posicion != -1){
            productoProveedorActual = productosProveedor.get(posicion);
        }
    }//GEN-LAST:event_listaDataProductosValueChanged

    private void textFieldNombreComisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreComisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreComisionActionPerformed

    private void textFieldPorcentajeComisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPorcentajeComisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPorcentajeComisionActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        String nombreComision = textFieldNombreComision.getText();
        String porcentajeComision = textFieldPorcentajeComision.getText();
        if(proveedorActual.agregarComision(nombreComision, porcentajeComision, productoProveedorActual)){
           cargarComisiones();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo crear la comisión");
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaDataComisiones;
    private javax.swing.JList listaDataProductos;
    private javax.swing.JList listaDataProveedores;
    private javax.swing.JTextField textFieldNombreComision;
    private javax.swing.JTextField textFieldPorcentajeComision;
    // End of variables declaration//GEN-END:variables

    private void cargarProveedores() {
        listaDataProveedores.setListData(Fachada.getInstancia().getProveedores().toArray());
    }

    private void cargarDatosProveedor(Object proveedorSeleccionado) {
        if(proveedorSeleccionado != null){
            productoProveedorActual = null;
            proveedorActual = (Proveedor)proveedorSeleccionado;
            productosProveedor = proveedorActual.getProductos();
            listaDataProductos.setListData(dibujarProductos(proveedorActual.getProductos()));
            cargarComisiones();            
        }        
    }
    
    private void cargarComisiones() {
        listaDataComisiones.setListData(dibujarComisiones(proveedorActual.getComisiones()));
    }
    
    private Object[] dibujarComisiones(ArrayList<Comision> comisiones) {
        ArrayList<String> listadoComisiones = new ArrayList();
        if(comisiones != null) {
            comisiones.forEach(comision -> {
                listadoComisiones.add(
                    "Nombre: " + comision.getNombre() +
                    " Porcentaje: % " + comision.getPorcentaje() +
                    " Producto: " + comision.getProducto().getNombre() 
                );
            });
        }
        return listadoComisiones.toArray();        
    }

    private Object[] dibujarProductos(ArrayList<Producto> productosProveedor) {
        ArrayList<String> listadoProductos = new ArrayList();
        if(productosProveedor != null) {
            productosProveedor.forEach(producto -> listadoProductos.add("Nombre: " + producto.getNombre()));
        }
        return listadoProductos.toArray();
    }
}
