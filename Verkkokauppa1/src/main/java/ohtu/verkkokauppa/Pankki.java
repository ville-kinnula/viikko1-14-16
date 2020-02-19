package ohtu.verkkokauppa;

public class Pankki implements Ipankki {

    private Ikirjanpito kirjanpito;

    public Pankki(Ikirjanpito kirjanpit) {
        kirjanpito = kirjanpit;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
