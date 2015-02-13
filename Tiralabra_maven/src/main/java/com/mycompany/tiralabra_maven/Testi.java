package com.mycompany.tiralabra_maven;

import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilkkaporna
 */
public class Testi {
    
    private Tavara[] tavarat;
    private Sakki sakki;
    private int toistokoe;
    
    public Testi(Tavara [] tavarat, Sakki sakki, int toistokoe) {
        this.tavarat = tavarat;
        this.sakki = sakki;
        this.toistokoe = toistokoe;
    }
    
    public void ajaTesti() {
        
        long summa1 = 0;
        long summa2 = 0;
        
        for (int i=0;i<this.toistokoe;i++) {
            //random järjestys
            Tavara[] ar = shuffleTavarat();
//            Tavara[] ar = this.tavarat;
            Taytto taytto1 = new Taytto(ar, sakki);
            TayttoDP taytto2 = new TayttoDP(ar, sakki);

            long aikaAlussa = 0;
            long aikaLopussa = 0;
            long aika = 0;

            //rotatoidaan testien ajojärjestys
            
            if (i%2==0) {

                // Mittaus naivi-algoritmi
                aikaAlussa = System.currentTimeMillis();
                taytto1.etsiMaksimiArvoJaJono();            
                aikaLopussa = System.currentTimeMillis();  

                aika=aikaLopussa-aikaAlussa;
                summa1+=aika;

                // Mittaus DP -algoritmi
                aikaAlussa = System.currentTimeMillis();
                taytto2.etsiMaksimiArvoJaJono();            
                aikaLopussa = System.currentTimeMillis();  

                aika=aikaLopussa-aikaAlussa;
                summa2+=aika;
            }
            else {

                // Mittaus DP -algoritmi
                aikaAlussa = System.currentTimeMillis();
                taytto2.etsiMaksimiArvoJaJono();            
                aikaLopussa = System.currentTimeMillis();  

                aika=aikaLopussa-aikaAlussa;
                summa2+=aika;

                // Mittaus naivi-algoritmi
                aikaAlussa = System.currentTimeMillis();
                taytto1.etsiMaksimiArvoJaJono();            
                aikaLopussa = System.currentTimeMillis();  

                aika=aikaLopussa-aikaAlussa;
                summa1+=aika;
                
            }
            //Tarkistus, että tulos sama
            if (taytto1.annaMaxArvo()!=taytto2.annaMaxArvo()) {
                System.out.println("Taytto1: Arvo: " + taytto1.annaMaxArvo() + " , jono :" + taytto1.annaMaxJono());
                System.out.println("Taytto2: Arvo: " + taytto2.annaMaxArvo() + " , jono :" + taytto2.annaMaxJono());            
                break;
            }
        }
        
        long keskiarvo1 = summa1/toistokoe;
        long keskiarvo2 = summa2/toistokoe;
        System.out.println(toistokoe + ":n ajon summa Naiivilla: " + summa1 + ", DP:lla: "+ summa2);
        
    
    }
    
    private Tavara[] shuffleTavarat()
    {
      Tavara[] ar=this.tavarat;
      Random rnd = new Random();
      for (int i = ar.length - 1; i > 0; i--)
      {
        int index = rnd.nextInt(i + 1);
        // Simple swap
        Tavara a = ar[index];
        ar[index] = ar[i];
        ar[i] = a;
      }
      return ar;
    
    }    

}
