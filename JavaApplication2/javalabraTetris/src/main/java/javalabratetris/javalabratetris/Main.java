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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Peli pelaus = new Peli();        // testikoodia
        
        pelaus.putoa();
        
        System.out.println(pelaus.toString());
        System.out.println("");

        pelaus.taytaRuutu(2, 3);
        pelaus.taytaRuutu(9, 6);
        pelaus.taytaRuutu(9, 4);
        pelaus.taytaRuutu(17, 7);

        pelaus.liikuOikealle();         // liikkuminen ei tuota haluttua tulosta

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
                if (pelaus.onkoTaynna(y, x)) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

    }

}
