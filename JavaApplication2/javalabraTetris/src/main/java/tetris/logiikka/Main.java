/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

import javax.swing.SwingUtilities;
import tetris.ui.Piirto;

/**
 * Main. Lähtee pyörittämään peliä ja lopuksi printtaa tilanteen ja pisteet.
 * Kaksi jälkimmäistä toimintoa eivät ole kriittisiä mutta tilanteen printtaus oli 
 * avuksi testauksessa.
 * 
 * @author vlonka
 */
public class Main {

    /**
     * Sama kuin yllä.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Peli pelaus = new Peli();
        pelaus.peliPyorinta();

        for (int y = 0; y <= 23; y++) {
            if (y < 10) {
                System.out.print(y + "  ");
            } else {
                System.out.print(y + " ");
            }
            for (int x = 0; x <= 9; x++) {
                if (pelaus.getPelialue().onkoTaynna(y, x)) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

        System.out.println("");
        System.out.println("Tuloksesi: " + pelaus.pisteet + " pistettä.");     
    }

}