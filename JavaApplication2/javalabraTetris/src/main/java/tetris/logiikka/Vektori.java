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
    int KorkeusMuutos;
    int LeveysMuutos;
    
    public Vektori(int y,int x) {
        this.KorkeusMuutos = y;
        this.LeveysMuutos = x;
    }

    public int getKorkeusMuutos() {
        return KorkeusMuutos;
    }

    public int getLeveysMuutos() {
        return LeveysMuutos;
    }
}
