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
public class JPalikka extends Palikka {

    private int asento;
    private Vektori[] liike1 = new Vektori[]{new Vektori(-1, -1), new Vektori(0, 0),
        new Vektori(0, 0), new Vektori(1, -1)};
    private Vektori[] liike2 = new Vektori[]{new Vektori(0, 0), new Vektori(0, -2),
        new Vektori(-1, -1), new Vektori(-1, -1)};
    private Vektori[] liike3 = new Vektori[]{new Vektori(0, 0), new Vektori(0, 0),
        new Vektori(2, 1), new Vektori(2, 1)};
    private Vektori[] liike4 = new Vektori[]{new Vektori(1, 1), new Vektori(0, 2),
        new Vektori(-1, 0), new Vektori(-2, 1)};

    /**
     * Konstruktori.
     *
     * @param pelialue Pelialueena toimiva ruudukko.
     */
    public JPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(3, 5), new Pala(2, 5), new Pala(1, 5), pelialue);
        this.asento = 1;
    }

    /**
     * Katsoo mikä pyörimisliike suoritetaan.
     *
     */
    @Override
    public void pyori() {
        if (asento == 1) {
            pyorinta(liike1);
            asento++;
        } else if (asento == 2) {
            pyorinta(liike2);
            asento++;
        } else if (asento == 3) {
            pyorinta(liike3);
            asento++;
        } else if (asento == 4) {
            pyorinta(liike4);
            asento = 1;
        }
    }

    /**
     * Pyörittää palaa Vektorilistan mukaan.
     *
     * @param liike array palojen liikkeistä.
     *
     * @see tetris.logiikka.Ruudukko#onkoTaynna(int, int)
     */
    public void pyorinta(Vektori[] liike) {

        for (int i = 0; i <= 3; i++) {
            if (palat[i].getLeveys() + liike[i].leveysMuutos < 0 || palat[i].getLeveys() + liike[i].leveysMuutos > 9
                    || pelialue.onkoTaynna(palat[i].getKorkeus() + liike[i].korkeusMuutos, palat[i].getLeveys() + liike[i].leveysMuutos)) {
                return;
            }
        }
        for (int j = 0; j <= 3; j++) {
            palat[j].setKorkeus(palat[j].getKorkeus() + liike[j].korkeusMuutos);
            palat[j].setLeveys(palat[j].getLeveys() + liike[j].leveysMuutos);
        }
    }
}
