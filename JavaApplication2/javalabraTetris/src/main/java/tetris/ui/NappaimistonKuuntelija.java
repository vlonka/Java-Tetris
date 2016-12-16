/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.logiikka.Peli;

/**
 * Liikkumiskomennot ja niiden kuuntelija.
 * 
 * @author vlonka
 */
public class NappaimistonKuuntelija implements KeyListener {

    private Peli peli;
    private Piirto piirto;

    /**
     * Konstruktori.
     * 
     * @param peli Pelattava peli.
     * @param piirto Liittyy pelitilanteen piirtoon.
     */
    public NappaimistonKuuntelija(Peli peli, Piirto piirto) {
        this.peli = peli;
        this.piirto = piirto;
    }

    /**
     * Palikan ohjaus.
     * 
     * @param e Painike jota painetaan.
     * 
     * @see tetris.logiikka.Palikka#liikuOikealle() 
     * @see tetris.logiikka.Palikka#liikuVasemmalle() 
     * @see tetris.logiikka.Palikka#putoa() 
     * @see tetris.logiikka.Peli#getPalikka() 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            peli.getPalikka().liikuVasemmalle();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            peli.getPalikka().liikuOikealle();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            peli.getPalikka().pyori();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            peli.getPalikka().putoa();
        }
        
        
        piirto.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
