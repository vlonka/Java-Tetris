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
public class Palikka {
    
    private int korkeus;
    private int leveys;
    
    public Palikka(int korkeus, int leveys) {
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
