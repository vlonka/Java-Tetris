/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logiikka;

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
public class PalikkaTest {

    public PalikkaTest() {
    }

    Ruudukko ruudut;
    Palikka nelio;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        nelio = new OPalikka(ruudut);
    }

    @Test
    public void liikuVasemmalleToimii() {
        nelio.liikuVasemmalle();
        assertEquals("3, 3; 3, 4; 2, 3; 2, 4", nelio.toString());
    }

    @Test
    public void estettyLiikuVasemmalleToimii() {
        ruudut.taytaRuutu(3, 3);
        nelio.liikuVasemmalle();
        assertEquals("3, 4; 3, 5; 2, 4; 2, 5", nelio.toString());
    }
    
    @Test
    public void liikuOikealleToimii() {
        nelio.liikuOikealle();
        assertEquals("3, 5; 3, 6; 2, 5; 2, 6", nelio.toString());
    }

    @Test
    public void estettyLiikuOikealleToimii() {
        ruudut.taytaRuutu(2, 6);
        nelio.liikuOikealle();
        assertEquals("3, 4; 3, 5; 2, 4; 2, 5", nelio.toString());
    }
    
    @Test
    public void putoaToimii() {
        nelio.putoa();
        assertEquals("4, 4; 4, 5; 3, 4; 3, 5", nelio.toString());
    }
    
    @Test
    public void EstettyPutoaToimii() {
        ruudut.taytaRuutu(4, 5);
        nelio.putoa();
        assertEquals("3, 4; 3, 5; 2, 4; 2, 5", nelio.toString());
        
        assertTrue(ruudut.onkoTaynna(3, 4));
        assertTrue(ruudut.onkoTaynna(3, 5));
        assertTrue(ruudut.onkoTaynna(2, 4));
        assertTrue(ruudut.onkoTaynna(2, 5));
        
        assertFalse(ruudut.onkoTaynna(1, 4));
        assertFalse(ruudut.onkoTaynna(1, 5));
    }
    
    @Test
    public void pohjaanPutoaminen() {
        for (int i = 0; i <= 20; i++) {
            nelio.putoa();
        }
        
        assertTrue(ruudut.onkoTaynna(23, 4));
        assertTrue(ruudut.onkoTaynna(23, 5));
        assertTrue(ruudut.onkoTaynna(22, 4));
        assertTrue(ruudut.onkoTaynna(22, 5));
        
        assertFalse(ruudut.onkoTaynna(21, 4));
        assertFalse(ruudut.onkoTaynna(21, 5));
    }

}
