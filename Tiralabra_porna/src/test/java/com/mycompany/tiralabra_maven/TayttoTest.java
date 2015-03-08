/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.tiralabra_maven;

import java.util.ArrayList;
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
public class TayttoTest {
    
    public TayttoTest() {
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

    
    @Test
    public void hello() {}

    @Test
    public void alustaTayttoTestaaTavarat() {
        int[] koot = {400,25,23,22};
        int[] arvot = {100,90,80,70};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }

        Sakki sakki = new Sakki(430);
        
        Taytto taytto1 = new Taytto(tavarat, sakki);
        String vastaus = taytto1.annaTavaratMerkkijonona();

        assertEquals("Indeksi: 0, koko: 400, arvo: 100; Indeksi: 1, koko: 25, arvo: 90; Indeksi: 2, koko: 23, arvo: 80; Indeksi: 3, koko: 22, arvo: 70; " +
"", vastaus);
    }
    @Test
    public void alustaTayttoTestaaPaino() {
        int[] koot = {400,25,23,22};
        int[] arvot = {100,90,80,70};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }

        Sakki sakki = new Sakki(430);
        
        Taytto taytto1 = new Taytto(tavarat, sakki);
        int vastaus = taytto1.annaSakki().annaKoko();

        assertEquals(430, vastaus);
    }
     

    @Test
    public void alustaTayttoTestaaEtsiMaksimiArvoJaJono() {
        int[] koot = {400,350,25,23,22};
        int[] arvot = {100,30,90,80,70};

        Tavara[] tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            tavarat[i]=new Tavara(koot[i], arvot[i]);
        }

        Sakki sakki = new Sakki(410);
        
        Taytto taytto1 = new Taytto(tavarat, sakki);
        taytto1.etsiMaksimiArvoJaJono();
        String vastaus = "Arvo: " + taytto1.annaMaxArvo() + ", jono: " + taytto1.annaMaxJono();
        assertEquals("Arvo: 240, jono:  5 4 3", vastaus);
    }
}
