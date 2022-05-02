/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IuEscritorio;

import logica.Fachada;
import logica.Proveedor;

/**
 *
 * @author ecoitino
 */
public class ConsultarComisiones extends javax.swing.JDialog {

    private Proveedor proveedorActual;
    /**
     * Creates new form ConsultarComisiones
     */
    public ConsultarComisiones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cargarProveedoresConComisiones();
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
        verComisiones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaDataProveedores.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaDataProveedoresValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaDataProveedores);

        jLabel1.setText("Lista Proveedores con comisiones");

        verComisiones.setText("Ver comisiones");
        verComisiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verComisionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verComisiones)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(verComisiones)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verComisionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verComisionesActionPerformed
        Object proveedor = listaDataProveedores.getSelectedValue();
        if(proveedor != null) {
            Proveedor proveeedor = (Proveedor)proveedor;
            new ComisionesProveedor(null, false, proveeedor.getComisiones()).setVisible(true);
        }
    }//GEN-LAST:event_verComisionesActionPerformed

    private void listaDataProveedoresValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaDataProveedoresValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listaDataProveedoresValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaDataProveedores;
    private javax.swing.JButton verComisiones;
    // End of variables declaration//GEN-END:variables

    private void cargarProveedoresConComisiones() {
        listaDataProveedores.setListData(Fachada.getInstancia().getProveedoresConComisiones().toArray());
    }
}