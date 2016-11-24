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
public abstract class Palikka {

    private Ruudukko pelialue;
    private int asento;
    private Pala pala0;
    private Pala pala1;
    private Pala pala2;
    private Pala pala3;
    private Pala[] palat;

    public Palikka(Pala pala1, Pala pala2, Pala pala3, Pala pala4, Ruudukko pelialue) {
        this.pala0 = pala1;
        this.pala1 = pala2;
        this.pala2 = pala3;
        this.pala3 = pala4;
        this.pelialue = pelialue;
        this.palat = new Pala[4];

        palat[0] = pala0;
        palat[1] = pala1;
        palat[2] = pala2;
        palat[3] = pala3;
    }

    public abstract void pyori();

    public boolean voikoLiikkuaVasemmalle(Pala pala) {

        int x = pala.getLeveys();
        int y = pala.getKorkeus();

        if (x != 0) {
            if (!pelialue.onkoTaynna(y, x - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean voikoliikkuaOikealle(Pala pala) {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (x != 9) {
            if (!pelialue.onkoTaynna(y, x + 1)) {
                return true;
            }
        }
        return false;
    }

    public void liikuVasemmalle() {
        for (Pala pala : palat) {
            if (!voikoLiikkuaVasemmalle(pala)) {
                return;
            }
        }
        for (Pala pala : palat) {
            pala.setLeveys(pala.getLeveys() - 1);
        }
    }

    public void liikuOikealle() {
        for (Pala pala : palat) {
            if (!voikoliikkuaOikealle(pala)) {
                return;
            }
        }
        for (Pala pala : palat) {
            pala.setLeveys(pala.getLeveys() + 1);
        }
    }

    public void putoa() {
        for (Pala pala : palat) {
            if (!voikoPudota(pala)) {
                for (Pala pala1 : palat) {
                    pelialue.taytaRuutu(pala1.getKorkeus(), pala1.getLeveys());
                } return;
            }
            for (Pala pala2 : palat) {
                pala2.setKorkeus(pala2.getKorkeus() + 1);
            }
        }
    }

    public boolean voikoPudota(Pala pala) {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (y == 23 || pelialue.onkoTaynna(y + 1, x)) {
            return false;
        }
        return true;
    }

}
