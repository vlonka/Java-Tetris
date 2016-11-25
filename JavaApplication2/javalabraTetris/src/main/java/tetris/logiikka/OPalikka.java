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
public class OPalikka extends Palikka {

    private int asento;

    public OPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(3, 5), new Pala(2, 4), new Pala(2, 5), pelialue);
        this.asento = 1;
    }

    /**
     * Neliön muotoisen kappaalen keirtyminen 90 astetta ei tässä yhteydessä tee mitään,
     * joten O-palikka ei pyöri.
     */
    @Override
    public void pyori() {
        
    }

}
