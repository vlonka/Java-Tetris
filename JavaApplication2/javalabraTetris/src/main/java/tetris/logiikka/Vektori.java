/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

/**
 * Kertoo palan liikkeen palikan pyöriessä.
 *
 * @author vlonka
 */
public class Vektori {

    int korkeusMuutos;
    int leveysMuutos;

    public Vektori(int y, int x) {
        this.korkeusMuutos = y;
        this.leveysMuutos = x;
    }

    public int getKorkeusMuutos() {
        return korkeusMuutos;
    }

    public int getLeveysMuutos() {
        return leveysMuutos;
    }
}
