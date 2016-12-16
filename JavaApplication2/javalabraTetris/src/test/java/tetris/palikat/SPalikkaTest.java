package tetris.palikat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;
import static org.junit.Assert.*;
import tetris.palikat.SPalikka;

/**
 *
 * @author vlonka
 */
public class SPalikkaTest {
    
    public SPalikkaTest() {
    }
    
    Ruudukko ruudut;
    Palikka palikka;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        palikka = new SPalikka(ruudut);
    }
    
    @Test
    public void pyori1Toimii() {
        palikka.pyori();
        assertEquals("2, 3; 3, 4; 2, 4; 1, 3", palikka.toString());
    }

    @Test
    public void pyori2Toimii() {
        palikka.pyori();
        palikka.pyori();
        assertEquals("3, 3; 3, 4; 2, 4; 2, 5", palikka.toString());
    }

    @Test
    public void pyori1Estyy() {
        ruudut.taytaRuutu(1, 3);
        palikka.pyori();
        assertEquals("3, 3; 3, 4; 2, 4; 2, 5", palikka.toString());
    }

    @Test
    public void pyori2Estyy() {
        palikka.pyori();
        ruudut.taytaRuutu(3, 3);
        palikka.pyori();
        assertEquals("2, 3; 3, 4; 2, 4; 1, 3", palikka.toString());
    }
}
