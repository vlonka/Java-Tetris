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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Peli pelaus = new Peli();        // testikoodia

        pelaus.putoa();
        for (int i = 0; i < 10; i++) {
            pelaus.liikuVasemmalle();
        }

        System.out.println(pelaus.toString());
        System.out.println("");

        pelaus.getPelialue().taytaRuutu(2, 3);
        pelaus.getPelialue().taytaRuutu(9, 6);
        pelaus.getPelialue().taytaRuutu(9, 4);
        pelaus.getPelialue().taytaRuutu(17, 5);
        
        pelaus.getPelialue().tyhjennaRivi(2);
        pelaus.getPelialue().tyhjennaRivi(3);
        pelaus.getPelialue().pudotaRuudut(11);

        for (int i = 0; i <= 80; i++) {
            pelaus.putoa();
        }
        for (int y = 0; y <= 22; y++) {
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

    }

}
