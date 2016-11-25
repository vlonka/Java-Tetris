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
public class ZPalikka extends Palikka {
    
    private int asento;
    
    public ZPalikka(Ruudukko pelialue) {
        super(new Pala(2, 4), new Pala(2, 5), new Pala(3, 5), new Pala(3, 6), pelialue);
        this.asento = 1;
    }

    @Override
    public void pyori() {
        if (asento == 1) {
            pyori1();
            asento++;
        } else if (asento == 2) {
            pyori2();
            asento = 1;
        }
    }

    public void pyori1() {
        
    }

    public void pyori2() {

    }
    
}
