/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javalabratetris.javalabratetris.Peli;
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
    

    
    
    Peli pelaus;
    
    @Before
    public void setUp() {
        pelaus = new Peli();
    }
    
    @Test
    public void taytaRuutuToimii() {
        pelaus.taytaRuutu(2, 3);
        assertEquals(true, pelaus.onkoTaynna(2, 3));
    }
    
}
