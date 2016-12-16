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
import static org.junit.Assert.*;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;

/**
 *
 * @author vlonka
 */
public class ZPalikkaTest {

    public ZPalikkaTest() {
    }

    Ruudukko ruudut;
    Palikka palikka;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        palikka = new ZPalikka(ruudut);
    }

    @Test
    public void pyori1Toimii() {
        palikka.pyori();
        assertEquals("1, 5; 2, 4; 3, 4; 2, 5", palikka.toString());
    }

    @Test
    public void pyori2Toimii() {
        palikka.pyori();
        palikka.pyori();
        assertEquals("2, 3; 2, 4; 3, 4; 3, 5", palikka.toString());
    }

    @Test
    public void pyori1Estyy() {
        ruudut.taytaRuutu(2, 5);
        palikka.pyori();
        assertEquals("2, 3; 2, 4; 3, 4; 3, 5", palikka.toString());
    }

    @Test
    public void pyori2Estyy() {
        palikka.pyori();
        ruudut.taytaRuutu(2, 3);
        palikka.pyori();
        assertEquals("1, 5; 2, 4; 3, 4; 2, 5", palikka.toString());
    }

}
