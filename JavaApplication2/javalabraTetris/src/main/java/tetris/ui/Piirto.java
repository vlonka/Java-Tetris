/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author vlonka
 */
public class Piirto extends JFrame implements Runnable {

    public Piirto() {
    }

    @Override
    public void run() {
        new JFrame("Tetris");
        setPreferredSize(new Dimension(300, 600));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(getContentPane());


        repaint();

        pack();
        setVisible(true);
    }

    private void luoKomponentit(Container container) {
    }

@Override
    protected void paintComponent(Graphics graphics) {
        paintComponent(graphics);
        graphics.fillRect(50, 80, 100, 50);
        graphics.fillRect(200, 20, 50, 200);
    }

}
