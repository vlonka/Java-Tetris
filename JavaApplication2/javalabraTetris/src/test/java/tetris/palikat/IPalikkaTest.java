package tetris.palikat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import tetris.palikat.IPalikka;
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
public class IPalikkaTest {

    public IPalikkaTest() {
    }

    Ruudukko ruudut;
    Palikka palikka;

    @Before
    public void setUp() {
        ruudut = new Ruudukko();
        palikka = new IPalikka(ruudut);
    }

    @Test
    public void pyori1Toimii() {
        palikka.pyori();
        assertEquals("3, 4; 3, 5; 3, 3; 3, 2", palikka.toString());
    }

    @Test
    public void pyori2Toimii() {
        palikka.pyori();
        palikka.pyori();
        assertEquals("3, 4; 2, 4; 1, 4; 0, 4", palikka.toString());
    }

    @Test
    public void pyori1Estyy() {
        ruudut.taytaRuutu(3, 5);
        palikka.pyori();
        assertEquals("3, 4; 2, 4; 1, 4; 0, 4", palikka.toString());
    }

    @Test
    public void pyori2Estyy() {
        palikka.pyori();
        ruudut.taytaRuutu(0, 4);
        palikka.pyori();
        assertEquals("3, 4; 3, 5; 3, 3; 3, 2", palikka.toString());
    }

    @Test
    public void eiPyoriReunassa() {
        for (int i = 0; i < 20; i++) {
            palikka.liikuVasemmalle();
        }
        palikka.pyori();
        assertEquals("3, 0; 2, 0; 1, 0; 0, 0", palikka.toString());
        
        for (int i = 0; i < 20; i++) {
            palikka.liikuOikealle();
        }
        palikka.pyori();
        assertEquals("3, 9; 2, 9; 1, 9; 0, 9", palikka.toString());
    }

}
