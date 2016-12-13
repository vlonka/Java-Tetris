/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import tetris.logiikka.Palikka;
import tetris.logiikka.Peli;
import tetris.logiikka.Ruudukko;

/**
 *
 * @author vlonka
 */
public class Piirtoalusta extends JPanel {

    private Ruudukko ruudukko;
    private Peli peli;

    public Piirtoalusta(Ruudukko ruudukko, Peli peli) {
        this.ruudukko = ruudukko;
        this.peli = peli;
        super.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Color.GREEN);
        for (int i = 0; i <= 23; i++) {
            for (int j = 0; j <= 9; j++) {
                if (ruudukko.onkoTaynna(i, j)) {
                    graphics.fillRect(j * 30, i * 30, 30, 30);
                }
            }
        }

        
        graphics.setColor(Color.CYAN);
        for (int i = 0; i < peli.getPalikka().getPalat().length; i++) {
            graphics.fillRect(peli.getPalikka().getPalat()[i].getLeveys() * 30,
                    peli.getPalikka().getPalat()[i].getKorkeus() * 30, 30, 30);
        }
        

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, 300, 120);
    }
}
