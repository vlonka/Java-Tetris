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
    
    public JPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(3, 5), new Pala(2, 5), new Pala(1, 5), pelialue);
        this.asento = 1;
    }
    
    @Override
    public void pyori() {
        if (asento == 1) {
            pyori1();
            asento++;
        } else if (asento == 2) {
            pyori2();
            asento++;
        } else if (asento == 3) {
            pyori3();
        } else if (asento == 4) {
            pyori4();
            asento = 1;
        }
    }

    private void pyori1() {
        
    }

    private void pyori2() {
        
    }

    private void pyori3() {
        
    }
    
    private void pyori4() {
        
    }
    
}
