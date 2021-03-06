/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.ftm.iu;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.List;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Composite;
import java.awt.RenderingHints;

import java.awt.Shape;
import java.awt.geom.Point2D;
import sm.ftm.graficos.MiPunto;
import sm.ftm.graficos.MiLinea;
import sm.ftm.graficos.MiRectangulo;
import sm.ftm.graficos.MiElipse;

/**
 *
 * @author thejoker
 */
public class Lienzo2D extends javax.swing.JPanel {

    /**
     * Creates new form Lienzo2D
     */
    private Point2D pAux;
    List<Shape> vShape;
    private Formas forma;
    private Shape s;
    
    private Color color;
    private Stroke stroke;
    
    private boolean relleno;
    private boolean transparencia;
    private boolean alisar;
    private boolean editar;

    private RenderingHints render;
    private Composite comp;
    
    public Lienzo2D() {
        initComponents();
        
        this.vShape = new ArrayList();
        forma = Formas.Punto;
        
        color = Color.BLACK;
        stroke = new BasicStroke(1.0f);
        
        relleno = false;
        transparencia = false;
        alisar = false;
        editar = false;
        
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        g2d.setStroke(stroke);
        
        if(transparencia)
            g2d.setComposite(comp);
        
        if(alisar)
            g2d.setRenderingHints(render);
            
        for(Shape s:vShape) {
            if(relleno) g2d.fill(s);
            g2d.draw(s);
        }
    }
    
    public Formas getForma() {
        return forma;
    }

    public void setForma(Formas forma) {
        this.forma = forma;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(int grosor) {
        this.stroke = new BasicStroke(grosor);
    }

    public Float getStrokeWidth(){
        return ((BasicStroke) stroke).getLineWidth();
    }
    
    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }
    
    public boolean isTransparencia() {
        return transparencia;
    }

    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }

    public boolean isAlisar() {
        return alisar;
    }

    public void setAlisar(boolean alisar) {
        this.alisar = alisar;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public Shape getSelectedShape(Point2D p){
        for(Shape s:vShape){
            if(s.contains(p))
                return s;
              
            if(s instanceof MiLinea){
                if(((MiLinea)s).contains(p)){
                    return s;
                }   
            } 
        }
        
        return null;
    }
    
    public Shape CreateShape(Point2D pi, Point2D pf){
        Shape s = null;
        
        switch(forma){
            case Punto:
                    s = new MiPunto(pi);
                break;
            case Linea:
                    s = new MiLinea(pi,pf);
                break;
            case Rectangulo:
                    s = new MiRectangulo(pi,pf);
                break;
            case Elipse:
                    s = new MiElipse(pi,pf);
                break;
        }
        
        return s;
    }
    
    public void UpdateShape(Point2D pf){
        switch(forma){
            case Linea:
                    ((MiLinea)s).setPf(pf);
                break;
            case Rectangulo:
                    ((MiRectangulo)s).setPf(pf);
                break;
            case Elipse:
                    ((MiElipse)s).setPf(pf);
                break;
        }
    }
    
    public void UpdatePositionShape(Point2D p){ 
        if(s instanceof MiPunto){
            ((MiPunto)s).setLocation(p);
        }
        
        if(s instanceof MiLinea){
            ((MiLinea)s).setLocation(p);
        }
        
        if(s instanceof MiRectangulo){
            ((MiRectangulo)s).setLocation(p);
        }
        
        if(s instanceof MiElipse){
            ((MiElipse)s).setLocation(p);
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

    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(editar){
            this.s = this.getSelectedShape(evt.getPoint());
        }else{
            pAux = evt.getPoint();
            this.s = this.CreateShape(pAux,pAux);
            vShape.add(s);
        }
            
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(editar){
            if(this.s != null){
                this.UpdatePositionShape(evt.getPoint());
            }    
        }else
            this.UpdateShape(evt.getPoint());
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
