package sarja;


import java.io.OutputStream;
import java.io.PrintStream;
import kanta.HetuTarkistus;
import fi.jyu.mit.ohj2.Mjonot;

import  static kanta.HetuTarkistus.*;

/**
 * Luokka huolehtii yhden pelaajan luonnista. Osaa muuttaa merkkijonon
 * pelaajan tiedoiksi ja toisinpäin.
 * @author Jussi Höykinpuro
 * @version 20.2.2019
 *
 */
public class Pelaaja {
    
    private int tunnusNro;
    private int joukkueNro;
    private String nimi="";
    private String hetu="";
    private int syntymaVuosi=1920;
    private int paidanNumero=99;
    private boolean lisenssi=false;
    
   //kaikille olioille yhteinen muuttuja
    private static int seuraavaNro =1; 
    
    /**
     * Pelaajan muodostaja joukkue-parametrilla
     * @param joukkueNro joukkue johon uusi pelaaja kuuluu
     * 
     */
    public Pelaaja(int joukkueNro) {
        this.joukkueNro=joukkueNro;
    }
    
    
    /**
     * Pelaajan parametriton muodostaja
     */
    public Pelaaja() {
        
    }
        

    
    /**
     * palauttaa pelaajan tunnusnumeron
     * @return pelaajan tunnusnumero
     */
    public int getTunnusNro() {
        return tunnusNro;
    }
    
    /**
     * Apumetodi testaukseen
     * Täyttää pelaajan tiedot randomisti
     * @param apuhetu apuhetu
     * @param joukkueId joukkueen id
     */
    public void taytaPelaaja(String apuhetu,int joukkueId){
        this.joukkueNro=joukkueId;
        this.nimi="Jussi H";
        this.hetu=apuhetu;
        this.syntymaVuosi=1999;
        this.paidanNumero=rand(1,100);
        this.lisenssi=true;
        
    }
    
    /**
     * ottaa riviltä pelaajan tiedot
     * @param rivi jolta tiedot luetaan
     * 
     * @example
     * <pre name="test">
     * Pelaaja testi = new Pelaaja();
     * testi.parse("1|1|123456-123K|  Zidane  |1993  |12  |x");
     * testi.getJoukkueNro()===1;
     * testi.getTunnusNro()===1;
     * testi.getNimi()==="Zidane";
     *
     * 
     * </pre>
     * huom testeissä ei saa syntymavuotta yms ilman getteria, debuggaamalla nahty että ohjelma toimii
     */
    public void parse(String rivi) {
        StringBuffer apu = new StringBuffer(rivi);
        tunnusNro=(Mjonot.erota(apu,'|', getTunnusNro()));
        setJoukkueNro(Mjonot.erota(apu,'|',getJoukkueNro()));
        hetu=Mjonot.erota(apu,'|',hetu);
        nimi=Mjonot.erota(apu,'|',this.getNimi());
        syntymaVuosi=Mjonot.erota(apu, '|', syntymaVuosi);
        paidanNumero=Mjonot.erota(apu, '|', paidanNumero);
        if (apu.toString().equals("x"))lisenssi=true;
        
        
        
    }
    
      /**
      * Apumetodi testaukseen
      * Tayttaa pelaajan arvotulla hetulla
      * @param joukkueId joukkueen id
      */
      public void taytaPelaaja(int joukkueId) {
          String apuhetu = arvoHetu();
          taytaPelaaja(apuhetu,joukkueId);
      }
    
    
    /**
     * Antaa pelaaja-oliolle numerotunnuksen
     * Yhtä isompi kuin aikasemman tunnusnumero
     * TODO: testit
     */
    public void rekisteroi() {
        tunnusNro = seuraavaNro;
        seuraavaNro++;
    }
    
    /**
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        //String.format Vesalta.
        out.println(this);
        
        
    }
    
    /**
     * Muuttaa pelaajan tiedot merkkijonoksi, joka on
     * oikeassa muodossa tiedostoon tallennusta varten
     *@example
     * <pre name="test">
     * Pelaaja testi = new Pelaaja();
     * testi.rekisteroi();
     * testi.parse("1|1|123456-123K|  Zidane  |1993  |12  |x");
     * testi.toString()==="1|1|123456-123K|Zidane|1993|12|x";
     * Pelaaja testi2 = new Pelaaja(1);
     * testi2.rekisteroi();
     * testi2.toString()==="2|1|||1920|99|";
     * </pre>
     */
    @Override
    public String toString() {
        String apu="";
        if(lisenssi)apu="x";
       return "" +
               getTunnusNro()+"|"+ 
               getJoukkueNro()+"|"+
               hetu+"|"+
               getNimi()+"|"+
               syntymaVuosi+"|"+
               paidanNumero+"|"+
               apu;
               

    }
    
    /**
     * tulostaa pelaajan tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta (OutputStream os) {
        tulosta(new PrintStream(os));
    }

    /**   
     *
     * @return pelaajan nimi
     * @example
     * <pre name="test">
     * Pelaaja jussi = new Pelaaja();
     * jussi.taytaPelaaja(1);
     * jussi.getNimi()==="Jussi H";
     * </pre>
     */
    public String getNimi() {
        
        return this.nimi;
        
    }
    
    /**
     * asettaa pelaajan joukkueen
     * @param jNro joukkueen tunnus 
     * @example
     * <pre name="test">
     * Pelaaja testi = new Pelaaja();
     * testi.setJoukkueNro(1);
     * testi.setSyntymavuosi(1999);
     * testi.setNimi("Jussi");
     * testi.setHetu("123456-123X");
     * testi.setTunnusNro(2);
     * testi.setLisenssi(true);
     * testi.setNro("99");
     * testi.getJoukkueNro()===1;
     * testi.getSyntymavuosi()==="1999";
     * testi.getNimi()==="Jussi";
     * testi.getHetu()==="123456-123X";
     * testi.getTunnusNro()===2;
     * testi.getLisenssi()===true;
     * testi.getNro()==="99";
     * testi.getJoukkueNro()===1;
     * </pre>
     */
    public void setJoukkueNro(int jNro) {
        this.joukkueNro=jNro;
    }
    
    /**
     * kertoo, mihin joukkueeseen pelaaja kuuluu
     * @return joukkueen id
     */
    public int getJoukkueNro() {
        return this.joukkueNro;
    }
    
    /**
     * testipääohjelma
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //
        
    }

    /**
     * asettaa uuden syntymavuoden
     * @param syntymaVuosi uusi syntymavuosi
     */
	public void setSyntymavuosi(int syntymaVuosi) {
		this.syntymaVuosi=syntymaVuosi;
		
	}

	/**
	 * asettaa pelaajan nimen
	 * @param nimi uusi nimi
	 */
	public void setNimi(String nimi) {
		this.nimi=nimi;
		
	}

	/**
	 * asettaa hetun
	 * @param hetu uusi hetu
	 */
	public void setHetu(String hetu) {
		this.hetu=hetu;
		
	}

	/**
	 * asettaa paidannumeron
	 * @param nro paidan uusi numero
	 */
	public void setNro(String nro) {
		this.paidanNumero=Integer.parseInt(nro);
		
	}

	/**
	 * asetttaa lisenssin maksetuksi/maksamattomaksi
	 * @param lisenssiMaksettu boolean arvo lisenssille
	 */
	public void setLisenssi(boolean lisenssiMaksettu) {
		this.lisenssi=lisenssiMaksettu;
		
	}

	/**
	 * 
	 * @return hetu merkkijonona
	 */
	public String getHetu() {
		return this.hetu;
	}

	/**
	 * 
	 * @return pelaajan syntym�vuoden merkkijonona
	 */
	public String getSyntymavuosi() {
		
		return Integer.toString(this.syntymaVuosi);
	}

	/**
	 * 
	 * @return palauttaa pelaajan tunnusnumeron
	 */
	public String getNro() {
		// TODO Auto-generated method stub
		return Integer.toString(this.paidanNumero);
	}

	/**
	 * asettaa tunnusnumeron
	 * @param tunnusNro tunnusnumero
	 */
	public void setTunnusNro(int tunnusNro) {
		this.tunnusNro=tunnusNro;
		
	}

	/**
	 * 
	 * @return palauttaa paidan numeron merkkijonona
	 */
	public String getPaidanNumero() {
		// TODO Auto-generated method stub
		return Integer.toString(this.paidanNumero);
	}
	
	/**
	 * @return palauttaa true, jos lisenssi maksettu, ja false, jos ei.
	 */
	public boolean getLisenssi() {
		return this.lisenssi;
	}


	/**
	 * tarkistaa, että annetut tiedot ovat oikeanlaisia
	 * @return merkkijono, jossa kerrotaan mitä on vialla, tai tyhjä merkkijono jos ok.
	 *@example
	 * <pre name="test">
	 * Pelaaja testi = new Pelaaja();
	 * testi.setNro("10");
	 * testi.oikeellisuusTarkistus()==="Nimi on pakollinen.\n";
	 * testi.setNro("200");
	 * testi.oikeellisuusTarkistus()==="Nimi on pakollinen.\nPaidan numero pitää olla 1-100"
	 * testi.setHetu("123456-123X");
	 * testi.oikeellisuusTarkistus()==="Nimi on pakollinen.\nViallinen hetu, voi jättää myöss tyhjäksi.\nPaidan numero pitää olla 1-100"
	 * </pre>
	 */
	public String oikeellisuusTarkistus() {
		StringBuilder viat = new StringBuilder();
		if (this.getNimi().length()==0 ||this.getNimi()==null)viat.append("Nimi on pakollinen.\n");
		if (this.getHetu().length()!=0 && !HetuTarkistus.tarkista(this.getHetu()))viat.append("Viallinen hetu, voi jättää myöss tyhjäksi.\n");
		if (this.getPaidanNumero()==null || Integer.parseInt(this.getPaidanNumero())>99 || Integer.parseInt(this.getPaidanNumero())<1)viat.append("Paidan numero pitää olla 1-100");
		return viat.toString();
			
				
	}
}
