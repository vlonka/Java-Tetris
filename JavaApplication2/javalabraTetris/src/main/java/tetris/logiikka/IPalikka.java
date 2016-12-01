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
    private Vektori[] liike1 = new Vektori[]{new Vektori(0, 0), new Vektori(1, 1),
        new Vektori(2, -1), new Vektori(3, -2)};
    private Vektori[] liike2 = new Vektori[]{new Vektori(0, 0), new Vektori(-1, -1),
        new Vektori(-2, 1), new Vektori(-2, 2)};

    public IPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(2, 4), new Pala(1, 4), new Pala(0, 4), pelialue);
        this.asento = 1;

    }

    @Override
    public void pyori() {
        if (asento == 1) {
            pyorinta(liike1);
            asento++;
        } else if (asento == 2) {
            pyorinta(liike2);
            asento = 1;
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

    private void pyorinta(Vektori[] liike) {
        for (int i = 0; i <= 3; i++) {
            if (palat[i].getLeveys() + liike[i].LeveysMuutos < 0 || palat[i].getLeveys() + liike[i].LeveysMuutos > 9) {
                if (!pelialue.onkoTaynna(palat[i].getKorkeus() + liike[i].KorkeusMuutos, palat[i].getLeveys() + liike[i].LeveysMuutos)) {
               
                }
            }
        }
    }

    public void pyori2() {
        if (!pelialue.onkoTaynna(pala1.getKorkeus() - 1, pala1.getLeveys() - 1)
                && !pelialue.onkoTaynna(pala2.getKorkeus() - 2, pala2.getLeveys() + 1)
                && !pelialue.onkoTaynna(pala3.getKorkeus() - 3, pala3.getLeveys() + 2)) {
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
