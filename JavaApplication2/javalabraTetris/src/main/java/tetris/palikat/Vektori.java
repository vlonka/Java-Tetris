/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.palikat;

/**
 * Kertoo palan liikkeen palikan pyöriessä.
 *
 * @author vlonka
 */
public class Vektori {

    int korkeusMuutos;
    int leveysMuutos;

    /**
     * Konstruktori.
     * 
     * @param y Muutos korkeussuunnassa.
     * @param x Muutos leveyssuunnassa.
     */
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
