
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        ljono = new int[KAPASITEETTI];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }

        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            kasvataKapasiteettiaJosTarpeen();
            return true;
        }
        return false;
    }
    
    private void kasvataKapasiteettiaJosTarpeen() {
        if (alkioidenLkm % ljono.length == 0) {
            int[] taulukkoOld = ljono;
            ljono = new int[alkioidenLkm + kasvatuskoko];
            for (int i = 0; i < taulukkoOld.length; i++) {
                ljono[i] = taulukkoOld[i];
            }
        }
    }

    public boolean kuuluu(int luku) {
        int kuuluuko = 0;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                kuuluuko++;
                break;
            }
        }
        return (kuuluuko > 0);
    }

    public boolean poista(int luku) {
        boolean löytyikö = false;
        for (int j = 0; j < alkioidenLkm; j++) {
            if (luku == ljono[j]) {
                löytyikö = true;
            }
            if (löytyikö) {
                ljono[j] = ljono[j + 1];
            }
        }
        if (löytyikö) {
            alkioidenLkm--;
        }
        return löytyikö;

    }


    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String tuloste = "{";
        if (alkioidenLkm > 0) {
            tuloste += ljono[0];
            for (int i = 1; i < alkioidenLkm; i++) {
                tuloste += ", " + ljono[i];
            }
        }
        return (tuloste + "}");
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = a;
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                y.lisaa(aTaulu[i]);
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z=a;
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
