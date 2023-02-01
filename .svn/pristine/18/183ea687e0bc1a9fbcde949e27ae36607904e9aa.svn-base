/**
 * 
 */
package sarja;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Yllapitaa joukkueita taulukossa. osaa lisata ja poistaa joukkueen. Osaa lukea
 * ja kirjoittaa joukkueet tiedostoon.
 * @author jussi
 * @version 7.3.2019
 *
 */
public class Joukkueet implements Iterable<Joukkue>{
    
    private boolean muutettu=false;
    
    private static final int MAX_JOUKKUEITA = 10;
    private static int lkm =0;
    private Joukkue[] alkiot = new Joukkue[MAX_JOUKKUEITA]; 
    
    /**
     * muodostaja
     */
    public Joukkueet() {
        
    }
    
    /**
     * Tallentaa tehdyt muutokset tiedostoon
     */
    public void tallenna() {
        if (!muutettu)return;
       
    }
    
    /**
     * hakee tiedostosta joukkueet ja lis√§√§ ne tietorakenteeseen
     * @param tiedosto tiedosto josta luetaan
     */
    public void lueTiedostosta(String tiedosto) {
    	int suurinTunnus=0;
        try (Scanner fi = new Scanner(new FileReader(tiedosto+"\\joukkueet.txt"))){
            //TODO: jotakin kerhon nimist√§ t√§ss√§ Vesalla ei ummarra stupid
            while(fi.hasNext()) {
                String rivi = fi.nextLine();
                Joukkue joukkue = new Joukkue();
                joukkue.parse(rivi);
                if(joukkue.getTunnusNro()>suurinTunnus)
                this.lisaa(joukkue);
                
            }
            
        }catch (FileNotFoundException ex) {
            System.err.println("Tiedosto ei aukea"+ex.getMessage());
        }
        //TODO: tallennus
    }

    /**
     * Lisaa uuden joukkueen taulukkoon.
     * Jos taulukko t√§yttyy, luodaan uusi taulukko,joka on kaksinkertainen kooltaan
     * ja laitetaan se alkuper√§isen tilalle.
     * @param uusi lisattava joukkue
     * @example
     * <pre name="test">
     * Joukkueet joukkueet = new Joukkueet();
     * Joukkue testi = new Joukkue();
     * testi.taytaJoukkue();
     * testi.rekisteroi();
     * joukkueet.lisaa(testi);
     * Joukkue testi2 =joukkueet.anna(0);
     * testi.equals(testi2) === true;
     * Joukkue testi3 = new Joukkue();
     * testi3.taytaJoukkue();
     * testi3.rekisteroi();
     * joukkueet.lisaa(testi3);
     * testi2.equals(testi3)===false; 
     * </pre>
     */
    public void lisaa(Joukkue uusi) {
        //demo 10:sta tilan kasvatus
         if (lkm>=alkiot.length) {
             Joukkue[] uusiAlkiot=new Joukkue[alkiot.length*2];
             for (int i=0;i<lkm;i++) {
                 uusiAlkiot[i]=alkiot[i];
                 
                 
             }
             alkiot=uusiAlkiot;
         }
         //TODO: t√§m√§n toiminnon vois siirt√§√§ suoraan lis√§√§ toimintoon
        alkiot[lkm] = uusi;
        lkm++;
    }
    
    /**
     * antaa etsityn joukkueen
     * @param i halutun joukkueen indeksi taulukossa
     * @return pelaaja
     * @throws IndexOutOfBoundsException jos laiton i
     */
    
    public Joukkue anna(int i) throws IndexOutOfBoundsException{
        if(i<0||lkm<=i) throw new IndexOutOfBoundsException("laiton indeksi: "+i);
        return alkiot[i];
    }
    
    /**
     * @return palauttaa joukkueiden maaran
     */
    public int getLkm() {
        return lkm;
    }
    /**
     * @param args ei kaytossa
     */
    public static void main(String[] args) {
        Joukkueet joukkueet = new Joukkueet();
        
        Joukkue jee = new Joukkue();
        jee.taytaJoukkue();
        joukkueet.lisaa(jee);
        
        Joukkue jee2 = new Joukkue();
        jee2.taytaJoukkue();
        joukkueet.lisaa(jee2);
        
        Joukkue jee3 = new Joukkue();
        jee3.taytaJoukkue();
        joukkueet.lisaa(jee3);
        
        System.out.println(joukkueet.getLkm());
        
        
        System.out.print(joukkueet.dataksi());
    
    }

    /**
     * @return antaa listan joukkueista
     */
    public List<Joukkue> annaJoukkueet() {
        ArrayList<Joukkue> joukkueita=new ArrayList<Joukkue>();
        for(int i=0;i<lkm;i++) {
            joukkueita.add(alkiot[i]);
        }
        return joukkueita;
    }

    /**
     * @return muuntaa tietorakenteen joukkueet tiedostoon tallennettaan muotoon
     */
    public String dataksi() {
        StringBuilder data = new StringBuilder();
        for(int i=0;i<lkm;i++) {
            data.append(alkiot[i].toString()+"\n");
        }
        return data.toString();
    }

    @Override
    public Iterator<Joukkue> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * antaa halutun joukkueen
     * @param tunnusNro halutun joukkueen tunnusnumero
     * @return joukkue
     */
	public Joukkue getJoukkue(int tunnusNro) {
		for (int i=0;i<lkm;i++) {
			if(alkiot[i].getTunnusNro()==tunnusNro) return alkiot[i];
		}
		return null;
	}

	/**
	 * vaihtaa joukkueen toiseksi
	 * @param joukkue joukkue joksi vaihdetaan
	 * @param tunnusNro joukkueen tunnusnumero, joka vaihdetaan
	 */
	public void vaihdaJoukkueenTiedot(Joukkue joukkue, int tunnusNro) {
		for (int i=0;i<lkm;i++) {
			if (alkiot[i].getTunnusNro()==tunnusNro) {
				alkiot[i]=joukkue;
				return;
			}
		}
		
	}

	/**
	 * poistaa joukkueen taulukosta vaihtamalla viimeisen ja poistettavan paikkaa ja
	 * v‰hent‰m‰ll‰ joukkueiden lukum‰‰r‰‰ yhdell‰
	 * @param tunnusNro poistettavan joukkueen tunnusnumero
	 */
	public void poista(int tunnusNro) {
		int indeksi = java.util.Arrays.asList(alkiot).indexOf(getJoukkue(tunnusNro));
		alkiot[indeksi]=alkiot[lkm-1];
		lkm--;	
	}

	/**
	 * antaaa listan joukkueista joiden nimi sis‰lt‰‰ hakusanan
	 * @param hakusana etsitty merkkijono
	 * @return lista joukkueista
	 */
	public List<Joukkue> haeNimi(String hakusana) {
		List<Joukkue> toteuttavat = new ArrayList<Joukkue>();
		for (int i=0;i<lkm;i++) {
			if (alkiot[i].getNimi().toLowerCase().contains(hakusana.toLowerCase()))
				toteuttavat.add(alkiot[i]);

		}
		return toteuttavat;
	}
    
  

}
