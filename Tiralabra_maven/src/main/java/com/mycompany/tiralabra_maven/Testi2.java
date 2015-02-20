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
public class Testi2 {
    
    private Tavara[] tavarat;
    private Sakki sakki;
    private int toistokoe;
    
    public Testi2(Tavara [] tavarat, Sakki sakki, int toistokoe) {
        this.tavarat = tavarat;
        this.sakki = sakki;
        this.toistokoe = toistokoe;
    }
    
    public void ajaTesti() {
        
        long summa1 = 0;
        long summa2 = 0;
        int laskuri1=0; //test
        int laskuri2=0;

        
        for (int i=0;i<this.toistokoe;i++) {
            //random järjestys
            Tavara[] ar = shuffleTavarat();
//            Tavara[] ar = this.tavarat;
            Taytto taytto1 = new Taytto(ar, sakki);
            TayttoDP taytto2 = new TayttoDP(ar, sakki);

            long aikaAlussa = 0;
            long aikaLopussa = 0;
            long aika = 0;

            int sisatoisto=1000;
            //rotatoidaan testien ajojärjestys
            long sum1=0; 
            long sum2=0; 
            for (int j=0;j<sisatoisto;j++) {

                if (i%2==0) {
                    laskuri1++;

                    // Mittaus naivi-algoritmi
                    aikaAlussa = System.nanoTime();
                    taytto1.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if(j>=10) sum1+=aika;

                    // Mittaus DP -algoritmi
                    aikaAlussa = System.nanoTime();
                    taytto2.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if(j>=10) sum2+=aika;
                }
                else {
                    laskuri2++; //test

                    // Mittaus DP -algoritmi
                    aikaAlussa = System.nanoTime();
                    taytto2.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if(j>=10) sum2+=aika;
        
                    // Mittaus naivi-algoritmi
                    aikaAlussa = System.nanoTime();
                    taytto1.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if (j>=10) sum1+=aika;
                }

                //Tarkistus, että tulos sama
                if (taytto1.annaMaxArvo()!=taytto2.annaMaxArvo()) {
                    System.out.println("Taytto1: Arvo: " + taytto1.annaMaxArvo() + " , jono :" + taytto1.annaMaxJono());
                    System.out.println("Taytto2: Arvo: " + taytto2.annaMaxArvo() + " , jono :" + taytto2.annaMaxJono());            
                    break;
                }

            }
            summa1+=sum1/(sisatoisto-10);
            summa2+=sum2/(sisatoisto-10);
            
        }
        System.out.println(laskuri1);
        System.out.println(laskuri2);

        long keskiarvo1 = summa1/toistokoe;
        long keskiarvo2 = summa2/toistokoe;
        System.out.println(toistokoe + ":n ajon keskiarvo (ms) Naiivilla: " + keskiarvo1/1000 + ", DP:lla: "+ keskiarvo2/1000);
        
    
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
