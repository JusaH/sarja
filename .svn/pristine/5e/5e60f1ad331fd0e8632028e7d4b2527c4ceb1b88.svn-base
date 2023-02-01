/**
 * 
 */
package sarja;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 
 * Luokka huolehtii pelaajat ja joukkueet luokkien yhteistyöstä.
 * @author Jussi Höykinpuro
 * @version 27.2.2019
 *
 */
public class Sarja {
    
    private  String nimi;
    private  Pelaajat pelaajat=new Pelaajat();
    private  Joukkueet joukkueet=new Joukkueet();


    

    /**
     * sarjan muodostaja
     * @param nimi sarjan nimi
     */
    public Sarja(String nimi) {
        this.nimi=nimi;
    }
    
    /**
     * luokan testipääohjelma
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        /*
        Sarja sarja = new Sarja("asd");
        
        Joukkue HPK = new Joukkue();
        HPK.rekisteroi();
        HPK.taytaJoukkue();
        Joukkue HIFK = new Joukkue();
        HIFK.rekisteroi();
        HIFK.taytaJoukkue();
        
        Pelaaja aku1 = new Pelaaja();
        Pelaaja aku2 = new Pelaaja();
        Pelaaja aku3 = new Pelaaja();
        
        aku1.rekisteroi();
        aku1.taytaPelaaja(HPK.getTunnusNro());
        aku2.rekisteroi();
        aku2.taytaPelaaja(HPK.getTunnusNro());
        aku3.rekisteroi();
        aku3.taytaPelaaja(HIFK.getTunnusNro());
        
        sarja.lisaa(HPK);
        sarja.lisaa(HIFK);
        sarja.lisaa(aku1);
        sarja.lisaa(aku2);
        sarja.lisaa(aku3);
        */
        
        Sarja sarja = new Sarja("sarja");
        sarja.lueTiedosto();
        
        for(int i = 0;i<sarja.getJoukkueita();i++) {
            Joukkue joukkue = sarja.annaJoukkue(i);
            System.out.println("Joukkue paikassa "+i);
            joukkue.tulosta(System.out);
            
            List<Pelaaja> testi=sarja.annaPelaajat(joukkue);
            for(Pelaaja pelaaja:testi)System.out.println(" "+pelaaja.toString());
                       
            
        }
        
        List<Joukkue> testi = sarja.annaJoukkueet();
        for(Joukkue joukkue: testi) {
            System.out.println(joukkue.toString());
        }
        
        /*
        System.out.println("Hpk pelaajat");
        List<Pelaaja> loydetyt = sarja.annaPelaajat(HPK);
        for(Pelaaja pelaaja : loydetyt) {
            pelaaja.tulosta(System.out);

        }
        
        System.out.println("Hifk pelaajat");
        loydetyt = sarja.annaPelaajat(HIFK);
        for(Pelaaja pelaaja : loydetyt) {
            pelaaja.tulosta(System.out);
        }    
        
        */
        
        }
        
        
   
    
    /**
     * antaa Joukkueiden lukumaaran
     * @return joukkueiden lkm
     * 
     */
    public int getJoukkueita() {
        return joukkueet.getLkm();
        
    }
    
    /**
     * antaa pelaajan annetussa indeksissä
     * @param i etsityn pelaajan indeksi paikka taulukossa
     * @return pelaaja taulukon paikassa i
     * @throws IndexOutOfBoundsException asd
     */
    public Joukkue annaJoukkue(int i) throws IndexOutOfBoundsException{
        return joukkueet.anna(i);
    }

        
    /**
     * lisätään pelaaja sarjaan
     * @param pelaaja pelaaja joka halutaan lisätä
     * @example
     * <pre name="test">
     * Sarja sarja = new Sarja("testi");
     * Joukkue joukkue = new Joukkue();
     * joukkue.rekisteroi();
     * Pelaaja jusa = new Pelaaja(1);
     * Pelaaja jussi = new Pelaaja(1);
     * jusa.rekisteroi();
     * jussi.rekisteroi();
     * sarja.lisaa(jusa);
     * sarja.lisaa(jussi);
     * sarja.lisaa(joukkue);
     * sarja.getJoukkueita()===1;
     * sarja.getPelaajia()===2;
     * </pre>
     */
    public void lisaa(Pelaaja pelaaja) {
        pelaajat.lisaa(pelaaja);
        
        
    }
    
    
    /**
     * Lisataan uusi joukkue sarjaan
     * @param joukkue lisattava joukkue
     */
    public void lisaa(Joukkue joukkue) {
        joukkueet.lisaa(joukkue);
    }
    
    /**
     * @param joukkue , jonka pelaajat halutaan
     * @return tietorakenne, jossa viitteet pelaajiin
     */
    public List<Pelaaja> annaPelaajat(Joukkue joukkue) {
        return pelaajat.annaPelaajat(joukkue.getTunnusNro());
    }
    
    /**
     * @return palauttaa sarjan pelaajien lkm
     */
    public int getPelaajia() {
        return pelaajat.getLkm();
    }
    
    /**
     * @return sarjan nimi
     */
    public String getSarjanNimi() {
        return this.nimi;
    }

    /**
     * @param nro joukkueen tunnusnro
     * @return lista joukkueen pelaajista
     */
    public List<Pelaaja> annaPelaajat(int nro) {

        return pelaajat.annaPelaajat(nro);
    }
    
    /**
     * poistaa pelaajan
     * @param tunnusnumero poistettavan pelaajan tunnusnumero
     */
    public void poistaPelaaja(int tunnusnumero) {
        pelaajat.poistaPelaaja(tunnusnumero);
    }

    /**
     * lukee tiedostoista pelaajat ja joukkueet ja lisää ne sarjaan
     */
    public void lueTiedosto() {
        pelaajat = new Pelaajat();
        joukkueet = new Joukkueet();
        
        //setTiedosto(sarjanNimi);
        pelaajat.lueTiedostosta(this.getNimi());
        joukkueet.lueTiedostosta(this.getNimi());
        
    }

    /**
     * @return antaa sarjan joukkueet listarakenteena
     */
    public List<Joukkue> annaJoukkueet() {
        return joukkueet.annaJoukkueet();
    }

    /**
     * tallentaa sarjan sen nimen mukaiseen tiedostoon
     */
    public void tallenna() {
        //String tallennettavaJoukkueet = joukkueet.dataksi();
        //String tallennettavaPelaajat = pelaajat.dataksi();
        try (PrintWriter out = new PrintWriter(this.getNimi()+"\\pelaajat.txt")){
            
            for(Pelaaja pelaaja:pelaajat) {
                out.println(pelaaja.toString());
            }
            
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try (PrintWriter out = new PrintWriter(this.getNimi()+"\\joukkueet.txt")){
            
            for(int i=0;i<joukkueet.getLkm();i++) {
                out.println(joukkueet.anna(i).toString());
            }
            
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    

    /**
     * getteri sarjan nimelle
     * @return sarjan nimi
     */
    public String getNimi() {
        return this.nimi;
    }
    
    /**
     * pyyt�� pelaajat luokkaa palauttamaan halutun pelaajan
     * @param tunnusNro pelaajan tunnusluku
     * @return palauttaa haetun pelaajan
     */
    public Pelaaja getPelaaja(int tunnusNro){
    	return pelaajat.getPelaaja(tunnusNro);
    }
    
    /**
     * muuttaaa pelaajan tiedot
     * @param pelaaja olio, jossa on uudet tiedot
     * @param tunnusNro pelaajan tunnusNro, jonka tiedot halutaan vaihtaa
     */
	public void vaihdaPelaajanTiedot(Pelaaja pelaaja, int tunnusNro) {
		pelaajat.vaihdaPelaajanTiedot(pelaaja,tunnusNro);
		
	}

	/**
	 * pyyt�� joukkuetta joukkueet luokalta tunnusluvun perusteella
	 * @param tunnusNro joukkueen tunnusluku jota haetaan
	 * @return etsitty joukkue
	 */
	public Joukkue getJoukkue(int tunnusNro) {

		return joukkueet.getJoukkue(tunnusNro);
	}
	
	/**
	 * l�hett�� pyynn�n joukkueet luokalle, vaihtaa halutun joukkueen tiedot
	 * @param joukkue uudet tiedot
	 * @param tunnusNro t�m�n joukkueen tiedot vaihdetaan
	 */
	public void vaihdaJoukkueentiedot(Joukkue joukkue, int tunnusNro) {
		joukkueet.vaihdaJoukkueenTiedot(joukkue,tunnusNro);
		
	}

	/**
	 * Poistaa joukkueen ja sen pelaajat
	 * @param tunnusNro poistettavan joukkueen tunnusnumero
	 */
	public void poistaJoukkue(int tunnusNro) {
		pelaajat.poistaPelaajat(tunnusNro);
		joukkueet.poista(tunnusNro);
		
		
	}

	/**
	 * Pyyt�� joukkueet luokalta listaa hakusanan toteuttavista joukkueista
	 * @param hakusana sana jonka joukkue halutaan toteuttavan
	 * @return lista hakusanan toteuttavista joukkueista
	 */
	public List<Joukkue> haeNimi(String hakusana) {
		return joukkueet.haeNimi(hakusana);
	}
}
