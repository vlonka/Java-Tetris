/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.SwingUtilities;
import tetris.ui.Piirto;

/**
 * Luokka pyörittää koko peliä. (kun valmis)
 *
 * @author vlonka
 */
public class Peli {

    private Ruudukko pelialue;
    private final List<Palikka> palikat = new ArrayList<>();
    private Palikka kayttoPalikka;
    Random arpa = new Random();
    int pisteet;

    /**
     * Konstruktori.
     */
    public Peli() {
        this.pelialue = new Ruudukko();
    }

    public void luoPalikka() {
        int nro = arpa.nextInt(7);

        if (nro == 0) {
            kayttoPalikka = new ZPalikka(pelialue);
        } else if (nro == 1) {
            kayttoPalikka = new IPalikka(pelialue);
        } else if (nro == 2) {
            kayttoPalikka = new JPalikka(pelialue);
        } else if (nro == 3) {
            kayttoPalikka = new LPalikka(pelialue);
        } else if (nro == 4) {
            kayttoPalikka = new OPalikka(pelialue);
        } else if (nro == 5) {
            kayttoPalikka = new SPalikka(pelialue);
        } else if (nro == 6) {
            kayttoPalikka = new TPalikka(pelialue);
        }

        palikat.add(kayttoPalikka);
    }

    public void vaihdetaankoPalikka() {
        if (kayttoPalikka.getKorvattava()) {
            luoPalikka();
        }
    }

    public Ruudukko getPelialue() {
        return pelialue;
    }

    public Palikka getPalikka() {
        return kayttoPalikka;
    }

    public List<Palikka> getPalikat() {
        return palikat;
    }

    public void peliPyorinta() {
        pisteet = 0;
        luoPalikka();
        long aika = System.currentTimeMillis();
        Piirto kayttoliittyma = new Piirto(pelialue, this);
        SwingUtilities.invokeLater(kayttoliittyma);
        while (true) {

            if (System.currentTimeMillis() > aika + 1000) {
                kayttoPalikka.putoa();
                vaihdetaankoPalikka();

                for (int y = 23; y >= 0; y--) {
                    if (pelialue.onkoRiviTaynna(y)) {
                        pelialue.pudotaRuudut(y);
                        pisteet++;
                    }
                }

                if (pelialue.onkoHavitty()) {
                    break;
                }
                aika = System.currentTimeMillis();
                kayttoliittyma.repaint();
            }

        }
    }
}
