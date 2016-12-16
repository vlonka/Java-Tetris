/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.palikat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;
import static org.junit.Assert.*;
import tetris.palikat.TPalikka;

/**
 *
 * @author vlonka
 */
public class TPalikkaTest {

    public TPalikkaTest() {
    }

    Ruudukko ruudut;
    Palikka palikka;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        palikka = new TPalikka(ruudut);
    }

    @Test
    public void pyori1Toimii() {
        palikka.pyori();
        assertEquals("2, 4; 1, 3; 1, 4; 0, 4", palikka.toString());
    }

    @Test
    public void pyori2Toimii() {
        palikka.pyori();
        palikka.pyori();
        assertEquals("2, 4; 2, 3; 1, 4; 2, 5", palikka.toString());
    }

    @Test
    public void pyori3Toimii() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        assertEquals("2, 4; 0, 4; 1, 4; 1, 5", palikka.toString());
    }

    @Test
    public void pyori4Toimii() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        assertEquals("2, 4; 1, 3; 1, 4; 1, 5", palikka.toString());
    }

    @Test
    public void pyori1Estyy() {
        ruudut.taytaRuutu(0, 4);
        palikka.pyori();
        assertEquals("2, 4; 1, 3; 1, 4; 1, 5", palikka.toString());
    }

    @Test
    public void pyori2Estyy() {
        palikka.pyori();
        ruudut.taytaRuutu(2, 3);
        palikka.pyori();
        assertEquals("2, 4; 1, 3; 1, 4; 0, 4", palikka.toString());
    }

    @Test
    public void pyori3Estyy() {
        palikka.pyori();
        palikka.pyori();
        ruudut.taytaRuutu(1, 5);
        palikka.pyori();
        assertEquals("2, 4; 2, 3; 1, 4; 2, 5", palikka.toString());
    }

    @Test
    public void pyori4Estyy() {
        palikka.pyori();
        palikka.pyori();
        palikka.pyori();
        ruudut.taytaRuutu(1, 3);
        palikka.pyori();
        assertEquals("2, 4; 0, 4; 1, 4; 1, 5", palikka.toString());
    }
}
