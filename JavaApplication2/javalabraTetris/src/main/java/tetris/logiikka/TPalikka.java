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
public class TPalikka extends Palikka {

    private int asento;

    public TPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(2, 3), new Pala(2, 4), new Pala(2, 5), pelialue);
        this.asento = 1;
    }

    @Override
    public void pyori() {
        if (asento == 1) {
            pyori1();
            asento++;
        } else if (asento == 2) {
            pyori2();
            asento++;
        } else if (asento == 3) {
            pyori3();
        } else if (asento == 4) {
            pyori4();
            asento = 1;
        }
    }

    private void pyori1() {
        if (!pelialue.onkoTaynna(pala3.getKorkeus() - 1, pala3.getLeveys() - 1)) {
            pala3.setKorkeus(pala3.getKorkeus() - 1);
            pala3.setLeveys(pala3.getLeveys() - 1);
        }
    }

    private void pyori2() {
        if (!pelialue.onkoTaynna(pala1.getKorkeus() + 1, pala1.getLeveys())
                && !pelialue.onkoTaynna(pala3.getKorkeus() + 2, pala3.getLeveys() + 1)) {
            pala1.setKorkeus(pala1.getKorkeus() + 1);

            pala3.setKorkeus(pala3.getKorkeus() + 2);
            pala3.setLeveys(pala3.getLeveys() + 1);
        }
    }

    private void pyori3() {
        if (!pelialue.onkoTaynna(pala1.getKorkeus() - 2, pala1.getLeveys() + 1)
                && !pelialue.onkoTaynna(pala3.getKorkeus() - 1, pala3.getLeveys())) {
            pala1.setKorkeus(pala1.getKorkeus() - 2);
            pala1.setLeveys(pala1.getLeveys() + 1);

            pala3.setKorkeus(pala3.getKorkeus() - 1);
        }
    }

    private void pyori4() {
        if (!pelialue.onkoTaynna(pala1.getKorkeus() + 1, pala1.getLeveys() - 1)) {
            pala1.setKorkeus(pala1.getKorkeus() + 1);
            pala1.setLeveys(pala1.getLeveys() - 1);
        }
    }

}
