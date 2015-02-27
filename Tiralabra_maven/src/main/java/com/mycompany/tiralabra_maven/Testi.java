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
    
    private String nimi;
    private Tavara[] tavarat;
    private Sakki sakki;
    private int toistokoe;
    private int koko;
    
    public Testi(String nimi, int[] koot, int [] arvot, int sakki, int toistokoe) {
        this.nimi=nimi;

        this.tavarat = new Tavara[koot.length];
        for (int i=0; i<koot.length; i++) {
            this.tavarat[i]=new Tavara(koot[i], arvot[i]);
        }
        this.sakki = new Sakki(sakki);
        this.koko=this.tavarat.length;
        this.toistokoe = toistokoe;
    }
    
    public void ajaTesti() {
        
        long summa1 = 0;
        long summa2 = 0;
        int laskuri1=0; //test
        int laskuri2=0;
        
        
        //rotatoidaan testien suoritusjärjestystä kerran
        int rot = 2;
        for (int i=0;i<rot;i++) {
            //random järjestys
            //Tavara[] ar = shuffleTavarat();

            Tavara[] ar = this.tavarat;
            Taytto tayttoN = new Taytto(ar, sakki);
            TayttoDP tayttoDP = new TayttoDP(ar, sakki);

            long aikaAlussa = 0;
            long aikaLopussa = 0;
            long aika = 0;

            int sisatoisto=this.toistokoe;
            //rotatoidaan testien ajojärjestys
            long sum1=0; 
            long sum2=0; 

            //ignoorataan 10 ensimmäistä tuloksista, lisätään siksi 10 ylimääräistä toistokierrosta
            for (int j=0;j<sisatoisto;j++) {

                if (i%2==0) {
                    laskuri1++;

                    // Mittaus naivi-algoritmi
                    aikaAlussa = System.nanoTime();
                    tayttoN.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    //ignoorataan 10 ensimmäistä tuloksista
                    if(j>=0) sum1+=aika;

                    // Mittaus DP -algoritmi
                    aikaAlussa = System.nanoTime();
                    tayttoDP.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if(j>=0) sum2+=aika;
                }
                else {
                    laskuri2++; //test

                    // Mittaus DP -algoritmi
                    aikaAlussa = System.nanoTime();
                    tayttoDP.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if(j>=0) sum2+=aika;
        
                    // Mittaus naivi-algoritmi
                    aikaAlussa = System.nanoTime();
                    tayttoN.etsiMaksimiArvoJaJono();            
                    aikaLopussa = System.nanoTime(); 

                    aika=aikaLopussa-aikaAlussa;
                    if (j>=0) sum1+=aika;
                }

                //Tarkistus, että tulos sama
                if (tayttoN.annaMaxArvo()!=tayttoDP.annaMaxArvo()) {
                    System.out.println("Taytto1: Arvo: " + tayttoN.annaMaxArvo() + " , jono :" + tayttoN.annaMaxJono());
                    System.out.println("Taytto2: Arvo: " + tayttoDP.annaMaxArvo() + " , jono :" + tayttoDP.annaMaxJono());            
                    break;
                }

            }
            summa1+=sum1/(sisatoisto);
            summa2+=sum2/(sisatoisto);
            
        }
//        System.out.println(laskuri1);
//        System.out.println(laskuri2);

        long keskiarvo1 = summa1/rot;
        long keskiarvo2 = summa2/rot;
        System.out.println(this.nimi + ": sakki " + this.sakki.annaKoko() + ", lkm " + this.koko + ", toistot " + toistokoe + ", keskiarvo (ms) Naiivi: " + keskiarvo1/1000 + ", DP: " + keskiarvo2/1000);
        
    
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
