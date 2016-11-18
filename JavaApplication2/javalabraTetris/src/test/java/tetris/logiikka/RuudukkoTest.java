package tetris.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tetris.logiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vlonka
 */
public class RuudukkoTest {
    

    
    
    Ruudukko ruudut;
    
    @Before
    public void setUp() {
        ruudut = new Ruudukko();
    }
    
    @Test
    public void taytaRuutuToimii() {
        ruudut.taytaRuutu(2, 3);
        assertEquals(true, ruudut.onkoTaynna(2, 3));
    }
    
    @Test
    public void onkoRivitaynnaToimii() {
        for (int x = 0; x <= 9; x++) {
            ruudut.taytaRuutu(10, x);
        }
        assertEquals(true, ruudut.onkoRiviTaynna(10));
    }
    
    @Test
    public void onkoTyhjaRiviTaynna() {
        assertFalse(ruudut.onkoRiviTaynna(9));
    }
    
    @Test
    public void tyhjennaRiviToimii() {
        for (int x = 0; x <= 9; x++) {
            ruudut.taytaRuutu(10, x);
        }
        ruudut.tyhjennaRivi(9);
        assertFalse(ruudut.onkoRiviTaynna(9));
    }
    
    @Test
    public void ruutujenPudotusToimii() {
        ruudut.taytaRuutu(12, 3);
        ruudut.taytaRuutu(12, 4);
        ruudut.taytaRuutu(12, 7);
        ruudut.taytaRuutu(12, 9);
        ruudut.taytaRuutu(8, 1);
        ruudut.taytaRuutu(6, 9);
        
        ruudut.pudotaRuudut(13);
        
        assertTrue(ruudut.onkoTaynna(13, 3));
        assertTrue(ruudut.onkoTaynna(13, 4));
        assertTrue(ruudut.onkoTaynna(13, 7));
        assertTrue(ruudut.onkoTaynna(13, 9));
        assertTrue(ruudut.onkoTaynna(9, 1));
        assertTrue(ruudut.onkoTaynna(7, 9));
        
        assertFalse(ruudut.onkoTaynna(12, 3));
        assertFalse(ruudut.onkoTaynna(12, 4));
        assertFalse(ruudut.onkoTaynna(12, 7));
        assertFalse(ruudut.onkoTaynna(12, 9));
        assertFalse(ruudut.onkoTaynna(8, 1));
        assertFalse(ruudut.onkoTaynna(6, 9));
    }
    
    @Test
    public void onkoHavittyToimii() {
        assertFalse(ruudut.onkoHavitty());
        
        ruudut.taytaRuutu(2, 9);
        assertTrue(ruudut.onkoHavitty());
    }
    
}
