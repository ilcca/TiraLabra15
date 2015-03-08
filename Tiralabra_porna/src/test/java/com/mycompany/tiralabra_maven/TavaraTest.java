/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ilkkaporna
 */
public class TavaraTest {
    
    public TavaraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void luoJaAnnaKoko100() {
        Tavara s = new Tavara(100, 50);
        int vastaus = s.annaKoko();
        assertEquals(100, vastaus);        
    
    }
    @Test
    public void luoJaAnnaArvo50() {
        Tavara s = new Tavara(100, 50);
        int vastaus = s.annaArvo();
        assertEquals(50, vastaus);        
    
    }

}
