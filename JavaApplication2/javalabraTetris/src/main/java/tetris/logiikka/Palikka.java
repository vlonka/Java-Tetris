/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

/**
 * Se alaspäin liikkuva palikka. Koostuu paloista.
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

    /**
     * Konstruktori.
     */
    public Palikka(Pala pala0, Pala pala1, Pala pala2, Pala pala3, Ruudukko pelialue) {
        this.pala0 = pala0;
        this.pala1 = pala1;
        this.pala2 = pala2;
        this.pala3 = pala3;
        this.pelialue = pelialue;
        this.palat = new Pala[4];

        palat[0] = pala0;
        palat[1] = pala1;
        palat[2] = pala2;
        palat[3] = pala3;

    }

    /**
     * Pyörittää palikkaa, eri palikoiden pyöriminen vaati erillisen toteutuksen. 
     */
    public abstract void pyori();

    /**
     * Tarkistaa voiko pala liikkua vasemmalle, vai onko tiellä pelikentän
     * reuna tai ruutu.
     *
     * @param pala Yksi palikan paloista.
     *
     * @see tetris.logiikka.Ruudukko#onkoTaynna(int, int)
     * 
     * @return true jos voi liikkua, false jos ei.
     */
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

    /**
     * Tarkistaa voiko pala liikkua oikealle, vai onko tiellä pelikentän
     * reuna tai ruutu.
     *
     * @param pala Yksi poalikan paloista.
     *
     * @see tetris.logiikka.Ruudukko#onkoTaynna(int, int)
     * 
     * @return true jos voi liikkua, false jos ei.
     */
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

    /**
     * Yrittää liikuttaa palikkaa vasemmalle, käyttää metodia voikoLiikkuaVasemmalle().
     * 
     * @see tetris.logiikka.Palikka#voikoLiikkuaVasemmalle(tetris.logiikka.Pala) 
     */
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

    /**
     * Yrittää liikuttaa palikkaa oikealle, käyttää metodia voikoLiikkuaOikealle().
     *
     * @see tetris.logiikka.Palikka#voikoLiikkuaVasemmalle(tetris.logiikka.Pala) 
     */
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

    /**
     * Yrittää liikuttaa alaspäin, käyttää metodia voikoPudota(). Jos ei voi,
     * täyttää palikan sijainnin ruuduilla.
     *
     * @see tetris.logiikka.Palikka#voikoPudota(tetris.logiikka.Pala) 
     * @see tetris.logiikka.Ruudukko#taytaRuutu(int, int) 
     */
    public void putoa() {
        for (Pala pala : palat) {
            if (!voikoPudota(pala)) {
                for (Pala pala1 : palat) {
                    pelialue.taytaRuutu(pala1.getKorkeus(), pala1.getLeveys());
                }
                return;
            }
        }
        for (Pala pala2 : palat) {
            pala2.setKorkeus(pala2.getKorkeus() + 1);
        }

    }

    /**
     * Tarkastaa voiko pala liikkua alaspäin vai onko esteitä.
     * 
     * @param pala Palikan pala jota käydään läpi
     *
     * @see tetris.logiikka.Ruudukko#onkoTaynna(int, int) 
     */
    public boolean voikoPudota(Pala pala) {
        int y = pala.getKorkeus();
        int x = pala.getLeveys();

        if (y == 23 || pelialue.onkoTaynna(y + 1, x)) {
            return false;
        }
        return true;
    }

    /**
     * toString testien avuksi.
     */
    @Override
    public String toString() {
        return pala0.getKorkeus() + ", " + pala0.getLeveys() + "; "
                + pala1.getKorkeus() + ", " + pala1.getLeveys() + "; "
                + pala2.getKorkeus() + ", " + pala2.getLeveys() + "; "
                + pala3.getKorkeus() + ", " + pala3.getLeveys();

    }

}
