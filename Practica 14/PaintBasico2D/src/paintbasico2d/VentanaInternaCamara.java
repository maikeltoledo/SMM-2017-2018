/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintbasico2d;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author thejoker
 */
public class VentanaInternaCamara extends VentanaInternaSM {

    /**
     * Creates new form VentanaInternaCamara
     */
    private Webcam camara = null;

    private VentanaInternaCamara() {
        initComponents();
        camara = Webcam.getDefault();
        
        Dimension resoluciones[] = camara.getViewSizes();
        Dimension maxRes = resoluciones[resoluciones.length - 1];
        camara.setViewSize(maxRes);
        if (camara != null) {
            WebcamPanel areaVisual = new WebcamPanel(getCamara());
            if (areaVisual != null) {
                getContentPane().add(areaVisual, BorderLayout.CENTER);
                pack();
            }
        }
    }

    public static VentanaInternaCamara getInstance() {
        VentanaInternaCamara v = new VentanaInternaCamara();
        return (v.getCamara() != null ? v : null);
    }
     
    public void close() {
        if (getCamara() != null) {
            try {
                getCamara().close();
            } catch (Exception e) {
                System.err.println("VentanaInternaJMFPlayer: " + e);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        this.close();
    }//GEN-LAST:event_formInternalFrameClosing

    /**
     * @return the camara
     */
    public Webcam getCamara() {
        return camara;
    }

    /**
     * @param camara the camara to set
     */
    public void setCamara(Webcam camara) {
        this.camara = camara;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
