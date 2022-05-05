/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IuEscritorio;

import java.awt.Dimension;
import java.util.ArrayList;
import logica.Comision;
import logica.Factura;
import logica.LineaFactura;
import logica.Producto;
import static utilidades.DateUtils.formatDate;

/**
 *
 * @author ecoitino
 */
public class InformacionItems extends javax.swing.JDialog {

    /**
     * Creates new form InformacionItems
     */
    public InformacionItems(java.awt.Frame parent, boolean modal, Comision comision) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setSize(new Dimension(800, 600));
        cargarInformacionItems(comision);
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
        listaDataFacturas = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listaDataFacturas);

        jLabel1.setText("Items");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaDataFacturas;
    // End of variables declaration//GEN-END:variables

    private void cargarInformacionItems(Comision comision) {
        listaDataFacturas.setListData(dibujadorItems(comision));
    }
    
    private Object[] dibujadorItems(Comision comision) {
        ArrayList<String> listadoItems = new ArrayList();
        comision.getFacturas().forEach(factura -> {
            LineaFactura lineaFactura = factura.getLineaFacturaPorProducto(comision.getProducto());
            listadoItems.add(
                "Nro factura: " + factura.getNumero() +
                " / Fecha: " + formatDate(factura.getFecha()) +
                " / Unidades: " + lineaFactura.getCantidad() +
                " / Comisión a pagar: $ " + comision.getComisionPorLinea(lineaFactura.total()) 
            );
        });
        return listadoItems.toArray();
    }
}
