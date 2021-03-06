/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author thejoker
 */
public class Lienzo extends javax.swing.JPanel {

    Point pi = new Point(-10,-10);
    Point pf = new Point(-10,-10);
    Point pmouse = new Point(-10,-10);
    
    Color color = Color.BLACK;
    Formas forma = Formas.Punto;
    boolean relleno;   
    
    public Lienzo() {
        initComponents();
    }

    @Override
    public void paint(Graphics g){
        int ejex, ejey, ancho, alto;
        super.paint(g);
   
        g.setColor(color);
        
        ejex = Math.min(this.pi.x, this.pf.x);
        ejey = Math.min(this.pi.y, this.pf.y);
        ancho = Math.abs(this.pi.x - this.pf.x);
        alto = Math.abs(this.pi.y - this.pf.y);
              
        switch(forma){
            case Punto:
                if(this.pmouse == null)
                    break;
                else
                    g.fillOval(this.pmouse.x-4, this.pmouse.y-4, 4, 4);
                    break;
            case Linea:
                if(this.pi == null && this.pf == null)
                    break;
                else
                    g.drawLine(this.pi.x, this.pi.y, this.pf.x, this.pf.y);
                    break;
            case Rectangulo:
                if(pi == null && pf == null)
                    break;
                g.drawRect(ejex, ejey, ancho, alto);
                break;
            case RectanguloRelleno:
                if(pi == null && pf == null)
                    break;
                g.fillRect(ejex, ejey, ancho, alto);
                break;
            case Ovalo:
                if(pi == null && pf == null)
                    break; 
                g.drawOval(ejex, ejey, ancho, alto);
                break;
            case OvaloRelleno:
                if(pi == null && pf == null)
                    break; 
                g.fillOval(ejex, ejey, ancho, alto);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void setForma(Formas f){
        this.forma = f;
    }
    
    public Formas getForma(){
        return this.forma;
    }
    
    public void setColor(Color c){
        this.color = c;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public void setRelleno(boolean relleno){
        this.relleno = relleno;
    }
    
    public boolean getRelleno(){
        return this.relleno;
    }
    
    public void LimpiarLienzo(){
        this.pi = new Point(-10,-10);
        this.pf = new Point(-10,-10);
        this.pmouse = new Point(-10,-10);
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.pmouse = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.pi = evt.getPoint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.pf = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.pf = evt.getPoint();
        this.repaint();
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
