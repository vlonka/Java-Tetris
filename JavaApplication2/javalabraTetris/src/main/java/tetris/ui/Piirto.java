/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tetris.logiikka.Peli;
import tetris.logiikka.Ruudukko;

/**
 *
 * @author vlonka
 */
public class Piirto extends JFrame implements Runnable {

    private Ruudukko ruudukko;
    private Peli peli;

    public Piirto(Ruudukko ruudukko, Peli peli) {
        this.ruudukko = ruudukko;
        this.peli = peli;
    }

    @Override
    public void run() {
        new JFrame("Tetris");
        setPreferredSize(new Dimension(310, 750));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(getContentPane());

        repaint();

        pack();
        setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(new Piirtoalusta(ruudukko, peli));
        addKeyListener(new NappaimistonKuuntelija(peli, this));
    }
}
