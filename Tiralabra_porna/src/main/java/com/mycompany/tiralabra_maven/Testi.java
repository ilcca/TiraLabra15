package com.mycompany.tiralabra_maven;

import java.util.Random;

/** Luokalla ajetaan suorituskykytestejä naiiville ja DP-algoritmille samalla syötteellä
 *
 * @author ilkkaporna
 */
public class Testi {
    
    private String nimi;
    private Tavara[] tavarat;
    private Sakki sakki;
    private int toistokoe;
    private int koko;
    
    /**Alustetaan suorituskykytesti
     *
     */

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
    
    /**Ajaa suorituskykytesti ja tulostetaan testin tulokset kummallekin algoritmille
     *
     */
    public void ajaTesti() {
        
        long summa1 = 0;
        long summa2 = 0;
        int laskuri1=0; //test
        int laskuri2=0;
        
        Taytto tulosN = null;
        TayttoDP tulosDP = null;
        
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

                //Tarkistus, että tulos sama kummallakin algoritmilla
                if (tayttoN.annaMaxArvo()!=tayttoDP.annaMaxArvo()) {
                    System.out.println("Taytto1: Arvo: " + tayttoN.annaMaxArvo() + " , jono :" + tayttoN.annaMaxJono());
                    System.out.println("Taytto2: Arvo: " + tayttoDP.annaMaxArvo() + " , jono :" + tayttoDP.annaMaxJono());            
                    break;
                }
                
                
            }
            summa1+=sum1/(sisatoisto);
            summa2+=sum2/(sisatoisto);
            
            tulosN=tayttoN;
            tulosDP=tayttoDP;
            
        }
//        System.out.println(laskuri1);
//        System.out.println(laskuri2);

        
        long keskiarvo1 = summa1/rot;
        long keskiarvo2 = summa2/rot;

        String[] kootN = tulosN.annaMaxJono().split(" ");
        int kokoN = 0;
        for (int i = 0; i < kootN.length; i++) {
            try {
                kokoN += this.tavarat[Integer.parseInt(kootN[i])-1].annaKoko();
            } catch (NumberFormatException nfe) {};
        }          
        
        String[] kootDP = tulosDP.annaMaxJono().split(" ");
        int kokoDP = 0;
        for (int i = 0; i < kootDP.length; i++) {
            try {
                kokoDP += this.tavarat[Integer.parseInt(kootDP[i])-1].annaKoko();
            } catch (NumberFormatException nfe) {};
        }          

        System.out.println(this.nimi);
        System.out.println("Tavarat: " + annaTavaroidenKokoJaArvo());
        System.out.println("Sakki " + this.sakki.annaKoko() + ", lkm " + this.koko + ", toistot " + toistokoe);
        System.out.println("Keskiarvo (ms) Naiivi: " + keskiarvo1/1000 + ", DP: " + keskiarvo2/1000);
        System.out.println("Tulos Naiivi: maksimiarvo: " + tulosN.annaMaxArvo() + " koko: " + kokoN + " maksimiarvon toteuttavien travaroiden järjestysnumerot: ");                 
        System.out.println(tulosN.annaMaxJono());
        System.out.println("Tulos DP: maksimiarvo: " + tulosDP.annaMaxArvo() + " koko: " + kokoDP + " maksimiarvon toteuttavien travaroiden järjestysnumerot: ");
        System.out.println(tulosDP.annaMaxJono());
    
    }
    public String annaTavaroidenKokoJaArvo() {
        String tulos="";
        for (int i=0; i<tavarat.length; i++) {
            tulos += "\n" + (i+1) + "# koko: " + this.tavarat[i].annaKoko() + " arvo: " + this.tavarat[i].annaArvo();
        }
        return tulos;
    }
    
    // Tavaroiden sekoitus, jos halutaan ajaa testejä sekoittamalla ulkotoistossa tavraoiden järjestystä
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
