/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

/**
 * Luokka pyörittää koko peliä. (kun valmis)
 * 
 * @author vlonka
 */
public class Peli {

    private Ruudukko pelialue;

    /**
     * Konstruktori.
     */
    
    public Peli() {
        this.pelialue = new Ruudukko();
    }

    public Ruudukko getPelialue() {
        return pelialue;
    }

}
