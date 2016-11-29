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
public class LPalikka extends Palikka {

    private int asento;

    public LPalikka(Ruudukko pelialue) {
        super(new Pala(1, 4), new Pala(2, 4), new Pala(3, 4), new Pala(3, 5), pelialue);
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
        if (!pelialue.onkoTaynna(pala0.getKorkeus() + 1, pala0.getLeveys() + 1)
                && !pelialue.onkoTaynna(pala3.getKorkeus() - 1, pala3.getLeveys() + 1)) {
            pala0.setKorkeus(pala0.getKorkeus() + 1);
            pala0.setLeveys(pala0.getLeveys() + 1);

            pala3.setKorkeus(pala3.getKorkeus() - 1);
            pala3.setLeveys(pala3.getLeveys() + 1);
        }
    }

    private void pyori2() {
        if (!pelialue.onkoTaynna(pala0.getKorkeus() - 1, pala0.getLeveys() + 1)
                && !pelialue.onkoTaynna(pala1.getKorkeus() - 1, (pala1.getLeveys() + 1))
                && !pelialue.onkoTaynna(pala2.getKorkeus(), pala2.getLeveys() + 2)) {
            pala0.setKorkeus(pala0.getKorkeus() - 1);
            pala0.setLeveys(pala0.getLeveys() + 1);

            pala1.setKorkeus(pala1.getKorkeus() - 1);
            pala1.setLeveys(pala1.getLeveys() + 1);

            pala2.setLeveys(pala2.getLeveys() - 2);
        }
    }

    private void pyori3() {
        if (!pelialue.onkoTaynna(pala0.getKorkeus() + 2, pala0.getLeveys() - 1)
                && !pelialue.onkoTaynna(pala1.getKorkeus() + 2, (pala1.getLeveys() - 1))) {
            pala0.setKorkeus(pala0.getKorkeus() + 2);
            pala0.setLeveys(pala0.getLeveys() - 1);

            pala1.setKorkeus(pala1.getKorkeus() + 2);
            pala1.setLeveys(pala1.getLeveys() - 1);
        }
    }

    private void pyori4() {
        if (!pelialue.onkoTaynna(pala0.getKorkeus() - 2, pala0.getLeveys() - 1)
                && !pelialue.onkoTaynna(pala1.getKorkeus() - 1, pala1.getLeveys())
                && !pelialue.onkoTaynna(pala2.getKorkeus(), pala2.getLeveys() - 2)
                && !pelialue.onkoTaynna(pala3.getKorkeus() + 1, pala3.getLeveys() - 1)) {
            pala0.setKorkeus(pala0.getKorkeus() - 2);
            pala0.setLeveys(pala0.getLeveys() - 1);

            pala1.setKorkeus(pala1.getKorkeus() - 1);

            pala2.setLeveys(pala2.getLeveys() - 2);

            pala3.setKorkeus(pala3.getKorkeus() + 1);
            pala3.setLeveys(pala3.getLeveys() - 1);
        }
    }

}
