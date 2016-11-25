/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

/**
 * Luo pelialueen johon ruudut liitetään. Palikka ei sinänsä liiku täällä.
 *
 * @author vlonka
 */
public class Ruudukko {

    private Ruutu[][] ruudut;

    /**
     * Konstruktori.
     */
    public Ruudukko() {
        this.ruudut = new Ruutu[24][10];
    }

    /**
     * Asettaa ruudun ruudukkoon.
     *
     * @param y ruudun korkeuskoordinatti
     * @param x ruudun leveyskoordinaatti
     */
    public void taytaRuutu(int y, int x) {
        Ruutu tayte = new Ruutu();
        ruudut[y][x] = tayte;
    }

    /**
     * Tarkastaa onko kyseisessä ruudukon kohdassa ruutu.
     *
     * @param y korkeuskoordinatti ruudukossa
     * @param x leveyskoordinaatti ruudukossa
     *
     * @return true jos siellä on ruutu, false muuten.
     */
    public boolean onkoTaynna(int y, int x) {
        if (ruudut[y][x] != null) {
            return true;
        }
        return false;
    }

    /**
     * Tarkastaa onko kyseinen ruudukon rivi täynnä ruutuja.
     *
     * @param y rivin korkeuskoordinatti
     * 
     * @see tetris.logiikka.Ruudukko#onkoTaynna(int, int)
     *
     * @return true jos rivi on täynnä ruutuja, false muuten.
     */
    public boolean onkoRiviTaynna(int y) {
        for (int x = 0; x <= 9; x++) {
            if (!this.onkoTaynna(y, x)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tyhjentää rivin ruuduista.
     *
     * @param y rivin korkeuskoordinatti
     *
     */
    public void tyhjennaRivi(int y) {
        for (int x = 0; x <= 9; x++) {
            ruudut[y][x] = null;
        }
    }

    /**
     * Siirtää jokaisen ruudun tietyltä riviltä ja sen yläpuolelta yhden
     * alaspäin. Ylin rivi on tyhjä.
     *
     * @param y alkurivin korkeuskoordinatti
     *
     * @see tetris.logiikka.Ruudukko#kopioiRivi(int, int)
     */
    public void pudotaRuudut(int y) {

        for (int i = y; i > 0; i--) {
            kopioiRivi(i, i - 1);
        }
    }

    /**
     * Korvaa rivin sen ylläolevalla rivillä.
     * 
     * @param   korvattava alempi rivi joka korvataan.
     * @param   kopio ylempi rivi jolla korvataan. Tämäkin korvataan koska tätä
     * metodia käytetään vain metodissa pudotaRuudut().
     */
    private void kopioiRivi(int korvattava, int kopio) {
        for (int x = 0; x <= 9; x++) {
            ruudut[korvattava][x] = ruudut[kopio][x];
        }
    }

    /**
     * Tarkastaa onko rivillä 2 ruutuja. Jos on, peli on hävitty.
     *
     * @return true jos rivillä on täynnä ruutu tai useampi, false muuten.
     */
    public boolean onkoHavitty() {
        for (int x = 0; x <= 9; x++) {
            if (onkoTaynna(2, x)) {
                return true;
            }
        }
        return false;
    }
}
