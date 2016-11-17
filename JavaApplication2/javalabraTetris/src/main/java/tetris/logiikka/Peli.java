/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

/**
 *
 * @author vlonka
 */
public class Peli {

    private Ruudukko pelialue;
    private Nelio pala;

    public Peli() {
        this.pelialue = new Ruudukko();
        this.pala = new Nelio(1, 5);
    }

    public void taytaRuutu(int y, int x) {
        pelialue.taytaRuutu(y, x);
    }

    public boolean onkoTaynna(int y, int x) {
        return pelialue.onkoTaynna(y, x);
    }

    public void putoa() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (y == 22) {
            taytaRuutu(y, x);
            pala.setKorkeus(1);
        } else if (onkoTaynna(y + 1, x)) {
            taytaRuutu(y, x);
            pala.setKorkeus(1);
        } else {
            pala.setKorkeus(y + 1);
        }

    }

    public void liikuOikealle() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (x != 9) {
            if (!onkoTaynna(y, x + 1)) {
                pala.setLeveys(x + 1);
            }
        }

    }

    public void liikuVasemmalle() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (x != 0) {
            if (!onkoTaynna(y, x - 1)) {
                pala.setLeveys(x - 1);
            }
        }
    }
    
    @Override
    public String toString() {
        return pala.getKorkeus() + ", " + pala.getLeveys();
    }
    
    public String palanSijainti() {
        return pala.getKorkeus() + ", " + pala.getLeveys();
    }
}
