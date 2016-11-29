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
public class SPalikka extends Palikka {

    private int asento;

    public SPalikka(Ruudukko pelialue) {
        super(new Pala(3, 3), new Pala(3, 3), new Pala(2, 3), new Pala(2, 4), pelialue);
        this.asento = 1;
    }

    @Override
    public void pyori() {
        if (asento == 1) {
            pyori1();
            asento++;
        } else if (asento == 2) {
            pyori2();
            asento = 1;
        }
    }

    public void pyori1() {
        if (!pelialue.onkoTaynna(pala0.getKorkeus() - 1, pala0.getLeveys())
                && !pelialue.onkoTaynna(pala3.getKorkeus() - 1, pala3.getLeveys() - 2)) {
            pala0.setKorkeus(pala0.getKorkeus() - 1);

            pala3.setKorkeus(pala3.getKorkeus() - 1);
            pala3.setLeveys(pala3.getLeveys() - 2);
        }
    }

    public void pyori2() {
        if (!pelialue.onkoTaynna(pala0.getKorkeus() + 1, pala0.getLeveys())
                && !pelialue.onkoTaynna(pala3.getKorkeus() + 1, pala3.getLeveys() + 2)) {
            pala0.setKorkeus(pala0.getKorkeus() + 1);

            pala3.setKorkeus(pala3.getKorkeus() + 1);
            pala3.setLeveys(pala3.getLeveys() + 2);
        }
    }

}
