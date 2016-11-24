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
public class Pala {
    
    private int korkeus;
    private int leveys;
    private Ruudukko ruudut;
    
    public Pala(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public int getLeveys() {
        return leveys;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }
    
    
}
