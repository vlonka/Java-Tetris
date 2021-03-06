/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.palikat;

import tetris.logiikka.Pala;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;

/**
 * O-palikan oma koodi.
 * 
 * @author vlonka
 */
public class OPalikka extends Palikka {

    private int asento;

    /**
     * Konstruktori.
     *
     * @param pelialue Pelialueena toimiva ruudukko.
     */
    public OPalikka(Ruudukko pelialue) {
        super(new Pala(3, 4), new Pala(3, 5), new Pala(2, 4), new Pala(2, 5), pelialue);
        this.asento = 1;
    }
    
    /**
     * OPalikan pyöriminen ei muuttaisi mitään, joten se ei pyöri.
     */
    @Override
    public void pyori() {
        
    }

}
