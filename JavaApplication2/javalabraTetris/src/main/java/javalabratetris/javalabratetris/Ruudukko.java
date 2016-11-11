/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabratetris.javalabratetris;

/**
 *
 * @author vlonka
 */
public class Ruudukko {

    private Ruutu[][] ruudut;

    public Ruudukko() {
        this.ruudut = new Ruutu[23][10];
    }
    
    public void taytaRuutu(int y, int x) {
        Ruutu tayte = new Ruutu();
        ruudut[y][x] = tayte;
    }

    public boolean onkoTaynna(int y, int x) {
        if (ruudut[y][x] != null) {
            return true;
        }
        return false;
    }
}
