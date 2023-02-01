package sarja;

import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * luokka joukkueelle. Osaa muodostaa, muokata ja tulostaa joukkueen tietoja.
 * 
 * @author jussi
 * @version 15.3.2019
 *
 */
public class Joukkue {
    private int tunnusNro;
    private String nimi = "";
    private String valmentaja ="";
    private String puh = "";
    private String email="";
    
    private static int seuraavaNro = 1;
    
    /**
     * Muodostaja joukkueelle
     */
    public Joukkue() {
        
    }
    
    /**
     * Tayttaa joukkueen tiedoilla
     */
    public void taytaJoukkue() {
        this.nimi="Kuokkalan Kodittomat";
        this.valmentaja="Zidane";
        this.puh="012345678";
        this.email="testi@gmail.com";
    }
    
    
    
    /**
     * antaa joukkueelle tunnusnumeron
     * @return Joukkueen tunnusnumero
     * @example
     * <pre name="test">
     * Joukkue testi = new Joukkue();
     * Joukkue testi2 = new Joukkue();
     * testi.getTunnusNro()===0;
     * testi2.getTunnusNro()===0;
     * </pre>
     */
    public int rekisteroi() {
        tunnusNro= seuraavaNro;
        seuraavaNro++;
        return tunnusNro;

    }
    
    /**
     * @return palauttaa joukkueen tiedot merkkijonona
     * @example
     * <pre name="test">
     * Joukkue testi = new Joukkue();
     * testi.rekisteroi();
     * testi.taytaJoukkue();
     * testi.toString()==="2|Kuokkalan Kodittomat|Zidane|testi@gmail.com|012345678";
     * </pre>
     */
    @Override
    public String toString() {
        return ""+
                getTunnusNro()+"|"+
                getNimi()+"|"+
                valmentaja+"|"+
                email+"|"+
                puh;
    }
    
    
    /**
     * ottaa riviltä joukkueen tiedot
     * @param rivi jolta tiedot luetaan
     * @example
     * <pre name="test">
     * Joukkue testi = new Joukkue();
     * testi.parse("1|testi|Jouko|Jouko|040123456");
     * testi.toString()==="1|testi|Jouko|Jouko|040123456";
     * </pre>
     */
    public void parse(String rivi) {
        StringBuffer apu = new StringBuffer(rivi);
        tunnusNro=(Mjonot.erota(apu,'|',getTunnusNro()));
        if(tunnusNro>=seuraavaNro)seuraavaNro=tunnusNro+1; 
        nimi=(Mjonot.erota(apu,'|',getNimi()));
        valmentaja=(Mjonot.erota(apu,'|',valmentaja));
        email=(Mjonot.erota(apu,'|',email));
        puh=(Mjonot.erota(apu,'|',puh));
    }
    
    
    /**
     * Tulostetaan joukkueen tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println(this.toString());
    }
    
    /**
     * paaluokka metodien testaukseen
     * @param args ei kaytossa
     */
    public static void main(String[] args) {
        //
    }

    /**
     * @return joukkueen tunnusnumero
     */
    public int getTunnusNro() {

        return this.tunnusNro;
    }
    
    /**
     * 
     * @return joukkueen nimi
     * @example
     * <pre name="test">
     * Joukkue joukkue = new Joukkue();
     * joukkue.rekisteroi();
     * joukkue.taytaJoukkue();
     * joukkue.getNimi()==="Kuokkalan Kodittomat";
     * joukkue.getTunnusNro()===1;
     * </pre>
     */
    public String getNimi() {
        return this.nimi;
    }

    /**
     * 
     * @return valmentaja
     */
	public String getValmentaja() {
		
		return this.valmentaja;
	}

	/**
	 * 
	 * @return puhelinnumero
	 */
	public String getPuh() {
		
		return this.puh;
	}
	
	/**
	 * 
	 * @return s�hk�posti
	 */
	public String getEmail() {
		
		return email;
	}
	
	/**
	 * asettaa joukkueen nimen
	 * @param nimi uusi nimi
	 */
	public void setNimi(String nimi) {
		this.nimi=nimi;
		
	}
	
	/**
	 * asettaa valmentajan nimen
	 * @param valmentaja uusi valmentajan nimi
	 */
	public void setValmentaja(String valmentaja) {
		this.valmentaja=valmentaja;
		
	}

	/**
	 * asettaa puhelinnumeron
	 * @param puh uusi puhelinnumero
	 */
	public void setPuh(String puh) {
		this.puh=puh;
		
	}

	/**
	 * asettaa s�hk�postin
	 * @param email s�hk�posti
	 * @example
	 * <pre name="test">
	 * Joukkue testi = new Joukkue();
	 * testi.setPuh("0401234567");
	 * testi.setNimi("testi");
	 * testi.setValmentaja("Jussi");
	 * testi.setEmail("testi@gmail.com");
     * testi.getPuh()==="0401234567";
     * testi.getNimi()==="testi";
     * testi.getValmentaja()==="Jussi";
     * testi.getEmail()==="testi@gmail.com";
	 * </pre>
	 */
	public void setEmail(String email) {
		this.email=email;
		
	}
	
	/**
	 * tarkistaa onko muokatut tiedot oikein
	 * @return merkkijonon virheistä
	 * @example
	 * TODO testit
	 */
	public String oikeellisuusTarkistus() {
		StringBuilder viat = new StringBuilder();
		//if (this.getNimi().length()==0)viat.append("Nimi on pakollinen.\n");
		//if (this.getHetu().length()!=0 && !HetuTarkistus.tarkista(this.getHetu()))viat.append("Viallinen hetu, voi j�tt�� my�s tyhj�ksi.\n");
		//if (this.getPaidanNumero()==null || Integer.parseInt(this.getPaidanNumero())>100 || Integer.parseInt(this.getPaidanNumero())<1)viat.append("Paidan numero pit�� olla 1-100");
		return viat.toString();
			
				
	}
	
}
