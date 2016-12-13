/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

import java.util.Random;

/**
 * Luokka pyörittää koko peliä. (kun valmis)
 *
 * @author vlonka
 */
public class Peli {

    private Ruudukko pelialue;
    private Palikka palikka;
    Random arpa = new Random();

    /**
     * Konstruktori.
     */
    public Peli() {
        this.pelialue = new Ruudukko();
    }

    public void luoPalikka() {
        int nro = arpa.nextInt(6);

        if (nro == 1) {
            palikka = new IPalikka(pelialue);
        } else if (nro == 2) {
            palikka = new JPalikka(pelialue);
        } else if (nro == 3) {
            palikka = new LPalikka(pelialue);
        } else if (nro == 4) {
            palikka = new OPalikka(pelialue);
        } else if (nro == 5) {
            palikka = new SPalikka(pelialue);
        } else if (nro == 6) {
            palikka = new TPalikka(pelialue);
        } else if (nro == 0) {
            palikka = new ZPalikka(pelialue);
        }
    }
    
    public void uusiPalikka() {
        palikka = null;
        
        luoPalikka();
    }
    
    public void vaihdetaankoPalikka() {
        if (palikka.getKorvattava()) {
            uusiPalikka();
        }
    }

    public Ruudukko getPelialue() {
        return pelialue;
    }
    
    public Palikka getPalikka() {
        return palikka;
    }

}
