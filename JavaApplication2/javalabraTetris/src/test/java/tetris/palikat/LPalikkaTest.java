package tetris.palikat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tetris.palikat.LPalikka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;
import static org.junit.Assert.*;

/**
 *
 * @author vlonka
 */
public class LPalikkaTest {
    
    public LPalikkaTest() {
    }
    
    Ruudukko ruudut;
    Palikka palikka;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        palikka = new LPalikka(ruudut);
    }

    
    @Test
    public void pyori1Toimii() {
        palikka.pyori();
        assertEquals("2, 5; 2, 4; 3, 4; 2, 6", palikka.toString());
    }

    @Test
    public void pyori2Toimii() {
        palikka.pyori();
        palikka.pyori();
        assertEquals("1, 6; 1, 5; 3, 6; 2, 6", palikka.toString());
    }
    
    @Test
    public void pyori3Toimii() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        assertEquals("3, 5; 3, 4; 3, 6; 2, 6", palikka.toString());
    }

    @Test
    public void pyori4Toimii() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        assertEquals("1, 4; 2, 4; 3, 4; 3, 5", palikka.toString());
    }

    @Test
    public void pyori1Estyy() {
        ruudut.taytaRuutu(2, 5);
        palikka.pyori();
        assertEquals("1, 4; 2, 4; 3, 4; 3, 5", palikka.toString());
    }

    @Test
    public void pyori2Estyy() {
        palikka.pyori();
        ruudut.taytaRuutu(1, 5);
        palikka.pyori();
        assertEquals("2, 5; 2, 4; 3, 4; 2, 6", palikka.toString());
    }
    
    @Test
    public void pyori3Estyy() {
        palikka.pyori();
        palikka.pyori();
        ruudut.taytaRuutu(3, 5);
        palikka.pyori();
        assertEquals("1, 6; 1, 5; 3, 6; 2, 6", palikka.toString());
    }

    @Test
    public void pyori4Estyy() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        ruudut.taytaRuutu(2, 4);
        palikka.pyori();
        assertEquals("3, 5; 3, 4; 3, 6; 2, 6", palikka.toString());
    }
}
