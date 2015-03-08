package com.mycompany.tiralabra_maven;

/** Jono on tehty vaihtoehtoiseksi tavaksi tallettaa maksimiarvontoteuttavan tavarakokoonpanon indeksit. Ei käytetä kutenkaan Taytto -luokissa vielä.
 *
 * @author ilkkaporna
 */
public class Jono {
    
    private Alkio eka=null;
    private Alkio viimeisin;
    
    public Jono() {
        
    }

    public void lisaa(int indeksi) {
        if (this.eka==null) {
            this.eka=new Alkio(indeksi);
            this.viimeisin=this.eka;
        }
        else {
            Alkio seuraava=new Alkio(indeksi);
            this.viimeisin.seuraava(seuraava);
            this.viimeisin=seuraava;
        }
    }
    public void annaIndeksitMerkki(int maxKoko) {
        int[] tuloste = new int[maxKoko];
        int laskuri = 0;
        Alkio alkio = this.eka;
        while (alkio!=null) {
            tuloste[laskuri]=alkio.annaIndeksi();
            alkio=alkio.annaSeuraava();
            laskuri++;
        }
    }

    private class Alkio {
        private Alkio seuraava;        
        private int indeksi;
        
        public Alkio(int indeksi) {
            this.seuraava=null;
            this.indeksi=indeksi;
        }
        public void seuraava(Alkio seuraava) {
            this.seuraava=seuraava;
        }
        
        public int annaIndeksi() {
            return this.indeksi;
        }
        
        public Alkio annaSeuraava() {
            return this.seuraava;
        }
        
    }
}
