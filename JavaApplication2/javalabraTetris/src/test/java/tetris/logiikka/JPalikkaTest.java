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
public class JPalikkaTest {
    
    public JPalikkaTest() {
    }    
    
    Ruudukko ruudut;
    Palikka palikka;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        palikka = new JPalikka(ruudut);
    }

    @Test
    public void pyori1Toimii() {
        palikka.pyori();
        assertEquals("2, 3; 3, 5; 2, 5; 2, 4", palikka.toString());
    }

    @Test
    public void pyori2Toimii() {
        palikka.pyori();
        palikka.pyori();
        assertEquals("2, 3; 3, 3; 1, 4; 1, 3", palikka.toString());
    }
    
    @Test
    public void pyori3Toimii() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        assertEquals("2, 3; 3, 3; 3, 5; 3, 4", palikka.toString());
    }

    @Test
    public void pyori4Toimii() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        assertEquals("3, 4; 3, 5; 2, 5; 1, 5", palikka.toString());
    }

    @Test
    public void pyori1Estyy() {
        ruudut.taytaRuutu(2, 3);
        palikka.pyori();
        assertEquals("3, 4; 3, 5; 2, 5; 1, 5", palikka.toString());
    }

    @Test
    public void pyori2Estyy() {
        palikka.pyori();
        ruudut.taytaRuutu(3, 3);
        palikka.pyori();
        assertEquals("2, 3; 3, 5; 2, 5; 2, 4", palikka.toString());
    }
    
    @Test
    public void pyori3Estyy() {
        palikka.pyori();
        palikka.pyori();
        ruudut.taytaRuutu(3, 4);
        palikka.pyori();
        assertEquals("2, 3; 3, 3; 1, 4; 1, 3", palikka.toString());
    }

    @Test
    public void pyori4Estyy() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        ruudut.taytaRuutu(1, 5);
        palikka.pyori();
        assertEquals("2, 3; 3, 3; 3, 5; 3, 4", palikka.toString());
    }
}
