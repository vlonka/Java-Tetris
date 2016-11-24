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
public class Ruudukko {

    private Ruutu[][] ruudut;

    public Ruudukko() {
        this.ruudut = new Ruutu[24][10];
    }

    public void taytaRuutu(int y, int x) {
        Ruutu tayte = new Ruutu();
        ruudut[y][x] = tayte;
    }

    public boolean onkoTaynna(int y, int x) {
        if (ruudut[y][x] != null) {
            return true;
        }
        return false;
    }

    public boolean onkoRiviTaynna(int y) {
        for (int x = 0; x <= 9; x++) {
            if (!this.onkoTaynna(y, x)) {
                return false;
            }
        }
        return true;
    }

    public void tyhjennaRivi(int y) {
        for (int x = 0; x <= 9; x++) {
            ruudut[y][x] = null;
        }
    }

    public void pudotaRuudut(int y) {

        for (int i = y; i > 0; i--) {
            kopioiRivi(i, i - 1);
        }
    }

    private void kopioiRivi(int korvattava, int kopio) {
        for (int x = 0; x <= 9; x++) {
            ruudut[korvattava][x] = ruudut[kopio][x];
        }
    }

    public boolean onkoHavitty() {
        for (int x = 0; x <= 9; x++) {
            if (onkoTaynna(2, x)) {
                return true;
            }
        }
        return false;
    }
}
