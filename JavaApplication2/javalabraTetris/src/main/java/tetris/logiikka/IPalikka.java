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
public class IPalikka extends Palikka {

    private int asento;

    public IPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(2, 4), new Pala(1, 4), new Pala(0, 4), pelialue);
        this.asento = 1;
    }

    @Override
    public void pyori() {
        if (asento == 1) {
            pyori1();
        } else if (asento == 2) {
            pyori2();
        }
    }

    public void pyori1() {
        if (!pelialue.onkoTaynna(pala1.getKorkeus() + 1, pala1.getLeveys() + 1)
                && !pelialue.onkoTaynna(pala2.getKorkeus() + 2, pala2.getLeveys() + 2)
                && !pelialue.onkoTaynna(pala3.getKorkeus() + 3, pala3.getLeveys() - 2)) {
            pala1.setKorkeus(pala1.getKorkeus() + 1);
            pala1.setLeveys(pala1.getLeveys() + 1);

            pala2.setKorkeus(pala2.getKorkeus() + 2);
            pala2.setLeveys(pala2.getLeveys() - 1);

            pala3.setKorkeus(pala3.getKorkeus() + 3);
            pala3.setLeveys(pala3.getLeveys() - 2);
            
            asento++;
        }
    }

    public void pyori2() {
        if (pelialue.onkoTaynna(pala1.getKorkeus() - 1, pala1.getLeveys() - 1)
                && pelialue.onkoTaynna(pala2.getKorkeus() - 2, pala2.getLeveys() + 1)
                && pelialue.onkoTaynna(pala3.getKorkeus() - 3, pala3.getLeveys() + 2)) {
            pala1.setKorkeus(pala1.getKorkeus() - 1);
            pala1.setLeveys(pala1.getLeveys() - 1);

            pala2.setKorkeus(pala2.getKorkeus() - 2);
            pala2.setLeveys(pala2.getLeveys() + 1);

            pala3.setKorkeus(pala3.getKorkeus() - 3);
            pala3.setLeveys(pala3.getLeveys() + 2);
            
            asento = 1;
        }
    }

}
