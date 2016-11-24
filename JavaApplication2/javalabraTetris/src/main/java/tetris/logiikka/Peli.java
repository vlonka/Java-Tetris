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
    private Pala pala;

    public Peli() {
        this.pelialue = new Ruudukko();
        this.pala = new Pala(1, 5);
    }

    public void putoa() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (y == 23) {
            pelialue.taytaRuutu(y, x);
            pala.setKorkeus(1);
        } else if (pelialue.onkoTaynna(y + 1, x)) {
            pelialue.taytaRuutu(y, x);
            pala.setKorkeus(1);
        } else {
            pala.setKorkeus(y + 1);
        }

    }

    public void liikuOikealle() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (x != 9) {
            if (!pelialue.onkoTaynna(y, x + 1)) {
                pala.setLeveys(x + 1);
            }
        }

    }

    public void liikuVasemmalle() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (x != 0) {
            if (!pelialue.onkoTaynna(y, x - 1)) {
                pala.setLeveys(x - 1);
            }
        }
    }

    public boolean voikoLiikkuaVasemmalle() {
        int x = pala.getLeveys();
        int y = pala.getKorkeus();

        if (x != 0) {
            if (!pelialue.onkoTaynna(y, x - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean voikoLiikkuaOikealle() {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (x != 9) {
            if (!pelialue.onkoTaynna(y, x + 1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return pala.getKorkeus() + ", " + pala.getLeveys();
    }

    public Ruudukko getPelialue() {
        return pelialue;
    }

    public Pala getNykyinenPala() {
        return pala;
    }

}
