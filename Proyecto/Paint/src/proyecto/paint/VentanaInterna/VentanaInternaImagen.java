/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.paint.VentanaInterna;

import proyecto.paint.VentanaPrincipal;
import sm.ftm.ui.Lienzo2DImagen;

/**
 *
 * @author thejoker
 */
public class VentanaInternaImagen extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInternaImagen
     */
    public VentanaInternaImagen (){
        initComponents();
        
        this.setTitle("Lienzo");
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
        lienzo2DImagen = new sm.ftm.ui.Lienzo2DImagen();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout lienzo2DImagenLayout = new javax.swing.GroupLayout(lienzo2DImagen);
        lienzo2DImagen.setLayout(lienzo2DImagenLayout);
        lienzo2DImagenLayout.setHorizontalGroup(
            lienzo2DImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        lienzo2DImagenLayout.setVerticalGroup(
            lienzo2DImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        getContentPane().add(lienzo2DImagen, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return the lienzo2DImagen
     */
    public Lienzo2DImagen getLienzo2DImagen() {
        return lienzo2DImagen;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private sm.ftm.ui.Lienzo2DImagen lienzo2DImagen;
    // End of variables declaration//GEN-END:variables
}
