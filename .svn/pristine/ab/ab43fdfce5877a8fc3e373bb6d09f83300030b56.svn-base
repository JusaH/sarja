package sarja;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Luokka joka hallinnoi pelaajia. Toteututettu ArrayListilla. Osaa lisätä ja
 * poistaa pelaajia. Osaa lukea ja kirjoittaa tiedostoa.
 * @author juhoykin
 * @version 20.2.2019
 *
 */
public class Pelaajat implements Iterable<Pelaaja>{
    private final ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();

    /**
     * pääohjelma luokan testaamiseenn
     * @param args ei kaytossa
     */
    public static void main(String[] args) {
        Pelaajat pelaajat = new Pelaajat();
        
        Pelaaja jussi = new Pelaaja(); 
        Pelaaja jusa = new Pelaaja();
        
        jussi.rekisteroi();
        jussi.taytaPelaaja(1);
        jusa.rekisteroi();
        jusa.taytaPelaaja(1);
        
        pelaajat.lisaa(jussi);
        pelaajat.lisaa(jusa);
        
        System.out.println(pelaajat.dataksi());
        
            /*
        Pelaajat pelaajat = new Pelaajat();
        pelaajat.lueTiedostosta();
        List<Pelaaja> loydetyt = pelaajat.annaPelaajat(1);
        for (Pelaaja pel : loydetyt) {
            pel.tulosta(System.out);
        }
        */
        
        
    }
        


    
    /**
     * tayttaa pelaajat pelaajilla lukemalla tiedoston riveja. Toistaiseksi oletustiedostonimi pelaajat
     *TODO:parametrina tiedoston nimi ja tarvittavat lisäykset. Katso Vesalta mallia
     * @param tiedosto paikka josta tiedot luetaan
     */
    public void lueTiedostosta(String tiedosto) {
        try (Scanner fi = new Scanner(new FileReader(tiedosto+"\\pelaajat.txt"))){
            //TODO: jotakin kerhon nimistä tässä Vesalla ei ummarra stupid
            while(fi.hasNext()) {
                String rivi = fi.nextLine();
                Pelaaja pelaaja = new Pelaaja();
                pelaaja.parse(rivi);
                pelaaja.rekisteroi(); //TODO:korjaa
                pelaajat.add(pelaaja); //TODO: miksei lisaa toimi?
                
            }
            
        }catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea"+ex.getMessage());
        }
        //TODO: tallennus
    }
    
    /**
     * poistaa pelaajan listasta
     * @param tunnusNro pelaajan tunnusnumero
     * @example
     * <pre name="test">
     * Pelaajat testipelaajat = new Pelaajat();
     * Pelaaja erkki = new Pelaaja();
     * erkki.taytaPelaaja(1);
     * erkki.rekisteroi();
     * testipelaajat.lisaa(erkki);
     * testipelaajat.poista(1);
     * testipelaajat.getLkm()===0;
     */
    public void poistaPelaaja(int tunnusNro) {
        for(Pelaaja pelaaja:pelaajat) {
        	if(pelaaja.getTunnusNro()==tunnusNro) {
        		 this.poistaPelaaja(pelaaja);
        		return;
        	}
        }
    }
    
    
    /**
     * Aliohjelma antaa pelaajien lukumäärän
     * @return pelaajien lukumäärän
     * @example
     * <pre name="test">
     * Pelaajat testipelaajat = new Pelaajat();
     * Pelaaja erkki = new Pelaaja();
     * erkki.taytaPelaaja(1);
     * erkki.rekisteroi();
     * testipelaajat.lisaa(erkki);
     * testipelaajat.getLkm()===1;
     * </pre>
     */
    public int getLkm() {
        return pelaajat.size();
    }
    
    /**
     * Lisää pelaajan pelaajien taulukkoon
     * @param pelaaja uusi pelaaja
     * @example
     * <pre name="test">
     * Pelaajat testi = new Pelaajat();
     * pelaaja testiPelaaja = new Pelaaja();
     * testi.lisaa(testiPelaaja);
     * </pre>
     */
    public void lisaa(Pelaaja pelaaja) {
        pelaajat.add(pelaaja);
        
        
    }
         
     /**
     * palauttaa annetun joukkuen pelaajat
     * @param joukkueId joukkueen tunniste     * 
     * @return joukkueen pelaajat
     */
    public List<Pelaaja> annaPelaajat(int joukkueId){
          ArrayList<Pelaaja> joukkueenPelaajat = new ArrayList<Pelaaja>();
          for(Pelaaja pelaaja : pelaajat) {
              if(pelaaja.getJoukkueNro()==joukkueId) joukkueenPelaajat.add(pelaaja);
             
          }
          return joukkueenPelaajat; 
      }
    

    @Override
    public Iterator<Pelaaja> iterator() {
        return pelaajat.iterator();
    }
    
    /**
     * @return muuntaa tietorakenteen pelaajat tiedostoon tallennettaan muotoon
     */
    public String dataksi() {
        StringBuilder data = new StringBuilder();
        for(Pelaaja pelaaja: pelaajat) {
            data.append(pelaaja.toString()+"\n");
        }
        return data.toString();
    }



    /**
     * antaa pelaajan
     * @param tunnusNro halutun pelaajan tunnusnumero
     * @return pelaaja
     */
	public Pelaaja getPelaaja(int tunnusNro) {
		for(Pelaaja pelaaja: pelaajat) {
			if(pelaaja.getTunnusNro()==tunnusNro) return pelaaja;
		}
		return null;
		
	}



	/**
	 * vaihtaa pelaajan tiedot toisiksi
	 * @param pelaaja olio, joka sis�lt�� uudet tiedot
	 * @param tunnusNro pelaajan, jonka tiedot halutaan vaihtaa, tunnusnumero
	 */
	public void vaihdaPelaajanTiedot(Pelaaja pelaaja, int tunnusNro) {
		this.pelaajat.set(pelaajat.indexOf(getPelaaja(tunnusNro)), pelaaja);
	}



	/**
	 * poistaa pelaajan tietokannasta
	 * @param pelaaja pelaaja joka poistetaan
	 */
	public void poistaPelaaja(Pelaaja pelaaja) {
		pelaajat.remove(pelaaja);
		
	}



	/**
	 * Poistaa pelaajat jotka on tietyss� joukkueessa 
	 * @param joukkueTunnus joukkue jonka pelaajat poistetaan
	 */
	public void poistaPelaajat(int joukkueTunnus) {
		ArrayList<Pelaaja> poistettavat=new ArrayList<Pelaaja>();
		for(Pelaaja pelaaja:pelaajat) {
			if(pelaaja.getJoukkueNro()==joukkueTunnus)poistettavat.add(pelaaja);
		}
		for(Pelaaja pelaaja:poistettavat) poistaPelaaja(pelaaja.getTunnusNro());
			
		//pelaajat.removeAll(poistettavat);
	}

}
