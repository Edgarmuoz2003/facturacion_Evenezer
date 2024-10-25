package com.leyedsoftware.login;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class logo extends javax.swing.JLabel {
    int x, y;

    public logo(JPanel panel){
        this.x = panel.getWidth();
        this.y = panel.getHeight();
        this.setSize(x, y);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/loguito.png"));
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null); 
    }
}
