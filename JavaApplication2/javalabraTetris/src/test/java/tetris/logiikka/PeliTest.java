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
public class PeliTest { // Jotain haikkaa, mikaan testi ei toimi, en tajua miksi.
    
    Peli pelaus;

    @Before
    public void setUp() {
        pelaus = new Peli();
    }
    
    @Test
    public void konstruktoriToimii() {
        assertEquals("1, 5", pelaus.toString());
    }
    
    @Test
    public void putoaToimii() {
    pelaus.putoa();
    assertEquals("2, 5", pelaus.toString());
}
    
    @Test
    public void pohjanLapiPutoaminen() {
        for (int i = 0; i < 22; i++) {
            pelaus.putoa();
        }
        assertEquals("1, 5", pelaus.toString());
    }
    
    @Test
    public void ruutuunPutoaminen() {
        pelaus.taytaRuutu(3, 5);
        for (int i = 0; i < 2; i++) {
            pelaus.putoa();
        }
        assertEquals("1, 5", pelaus.toString());
        assertEquals(true, pelaus.onkoTaynna(2, 5));
    }
    
    @Test
    public void liikuOikealleToimii() {
        pelaus.liikuOikealle();
        assertEquals("1, 6", pelaus.toString());
    }
    
    @Test
    public void liikuVasemmalleToimii() {
        pelaus.liikuVasemmalle();
        assertEquals("1, 4", pelaus.toString());
    }
    
    @Test
    public void ruutuLiikeVasen() {
        pelaus.taytaRuutu(1, 4);
        pelaus.liikuVasemmalle();
        assertEquals("1, 5", pelaus.toString());
    }
    
    @Test
    public void ruutuLiikeOikea() {
        pelaus.taytaRuutu(1, 6);
        pelaus.liikuOikealle();
        assertEquals("1, 5", pelaus.toString());
    }
    
    @Test
    public void reunaLiikeOikea() {
        for (int i = 0; i < 10; i++) {
            pelaus.liikuOikealle();
        }
        assertEquals("1, 9", pelaus.toString());
    }
    
    @Test
    public void reunaLiikeVasen() {
        for (int i = 0; i < 10; i++) {
            pelaus.liikuVasemmalle();
        }
        assertEquals("1, 0", pelaus.toString());
    }

}
