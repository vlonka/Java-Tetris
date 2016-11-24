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

    public IPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(2, 4), new Pala(1, 4), new Pala(0, 4), pelialue);
        this.asento = 1;
    }

    @Override
    public void pyori() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
