package fxSarja;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import sarja.*;


/**
 * @author Jussi Höykinpuro
 * @version 11.2.2019
 *
 */
public class SarjaGUIController implements Initializable,ModalControllerInterface<String>{
	
	@FXML
	private CheckBox checkLisenssi;
    
    @FXML
    private CheckBox checkPelaaja;

    @FXML
    private CheckBox checkJoukkue;

    @FXML
    private ChoiceBox<String> hakuValikko;
    
    @FXML
    private BorderPane sarjaRuutu;

    @FXML
    private Label textSarja;

    @FXML
    private MenuItem menuSulje;

    @FXML
    private MenuItem menuTulosta;

    @FXML
    private MenuItem menuPoista;

    @FXML
    private MenuItem menuMuokkaa;

    @FXML
    private MenuItem menuInfo;

    @FXML
    private MenuItem menuOhje;

    @FXML
    private TextField hakuKentta;

    @FXML
    private Button buttonLisaaPelaaja;

    @FXML
    private Button buttonLisaaJoukkue;

    @FXML
    private TextField textJoukkue;

    @FXML
    private TextField textValmentaja;

    @FXML
    private TextField textPuh;

    @FXML
    private TextField textMail;

    @FXML
    private TextField textPelaaja;

    @FXML
    private TextField textHetu;

    @FXML
    private TextField textIka;

    @FXML
    private TextField textPaita;

    @FXML
    private TextField textLisenssi;

    @FXML
    private Button buttonMuokkaa;

    @FXML
    private Button buttonPoista;
      
    @FXML
    private ListChooser<Joukkue> panelJoukkue;
    
    @FXML
    private ListChooser<Pelaaja> panelPelaaja;
    

    @Override
    public void initialize(URL url,ResourceBundle bundle) {
        alusta();
        
    }
    
    
    @FXML
    void alustaJoukkuehaku() {
    	checkPelaaja.setSelected(false);
    }

    @FXML
    void alustaPelaajaHaku() {
    	checkJoukkue.setSelected(false);
    	
    	
    }

    @FXML
    void handleHaku() {
        hae(checkJoukkue.isSelected(),hakuValikko.getValue());
    }


	@FXML
    void handleInfo() {
        ModalController.showModal(SarjaGUIController.class.getResource("info.fxml"), "Urheilusarjan Joukkuerekisteri", null, "");
    }

    @FXML
    void handleLisaaPelaaja() {
        uusiPelaaja();
    }
    
    @FXML
    void handleLisaaJoukkue() {
        uusiJoukkue();
    }
    

    @FXML
    void handleMuokkaa() {
    
    	  	
    	if(panelPelaaja.getSelectedObject()!=null) {
    		Pelaaja pelaaja = sarja.getPelaaja(panelPelaaja.getSelectedObject().getTunnusNro());
    		pelaaja=muokkaaPelaaja(panelPelaaja.getSelectedObject());
    		pelaaja.setJoukkueNro(panelPelaaja.getSelectedObject().getJoukkueNro());
    		pelaaja.setTunnusNro(panelPelaaja.getSelectedObject().getTunnusNro());
    		sarja.vaihdaPelaajanTiedot(pelaaja,panelPelaaja.getSelectedObject().getTunnusNro());
    		joukkueenPelaajat();
    		return;
    	}
    	
        if(panelJoukkue.getSelectedObject()!=null) {
        	Joukkue joukkue = sarja.getJoukkue(panelJoukkue.getSelectedObject().getTunnusNro());
        	joukkue = muokkaaJoukkue(panelJoukkue.getSelectedObject());
        	sarja.vaihdaJoukkueentiedot(joukkue,panelJoukkue.getSelectedObject().getTunnusNro());
        	naytaJoukkueet();
        	return;
        }
        
         Dialogs.showMessageDialog("klikkaa ensin pelaajaa tai joukkuetta, jota haluat muokata");

        
    }




    @FXML
    void handleOhje() {
        ohje();
        }
        //Dialogs.showMessageDialog("Vielä ei ole ohjeita!");

    @FXML
    void handlePoista() {
        poista();
    }




	@FXML
    void handleSulje() {
        System.exit(0);
    }

    @FXML
    void handleTulosta() {
        Dialogs.showMessageDialog("Vielä ei osata tulostaa!");
    }
    
	
	/**
	 * Ohjelma käsittelee ohjeen tuonnin. Toistaiseksi avaa suunnitelman selaimeen.
	 */
	public static void ohje(){
		Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URI("https://tim.jyu.fi/view/kurssit/tie/ohj2/2019k/ht/juhoykin");
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            return;
        } catch (IOException e) {
            return;
		}

	}


	
	//=============================================================
	private Sarja sarja;

	/**
	 * Lisaa pelaajan joukkueeseen joka on tällä hetkellä valittu
	 */
	public void uusiPelaaja() {
	    Pelaaja uusi = new Pelaaja();
	    uusi.setJoukkueNro(panelJoukkue.getSelectedObject().getTunnusNro());
	    uusi=MuokkaaPelaajaController.kysyPelaaja(uusi);
	    
	    //TODO rekister�i vain jos oikeanlaiset merkinn�t
        uusi.rekisteroi();
        sarja.lisaa(uusi);
        panelPelaaja.add(uusi.getNimi(),uusi);

	}
	
	/**
	 * Joukkueen lisaaminen
	 */
	public void uusiJoukkue() {
	    Joukkue uusi = new Joukkue();
	    uusi=MuokkaaJoukkueController.kysyJoukkue(uusi);
	    if (uusi.getNimi().charAt(uusi.getNimi().length()-1)=='*')return;
	    sarja.lisaa(uusi);
	    uusi.rekisteroi();
        panelJoukkue.add(uusi.getNimi(),uusi);  
	}
	
	
	/**
	 * avaa muokkaa ikkunan,jossa muokataan joukkuetta, joka on muokkausnappulaa painaessa valittuna
	 * @param muokattava muokattava joukkue
	 * @return palauttaa muokatun joukkueen
	 */
	public Joukkue muokkaaJoukkue(Joukkue muokattava) {
		
		Joukkue uusi=MuokkaaJoukkueController.kysyJoukkue(muokattava);
		if (uusi.getNimi().charAt(uusi.getNimi().length()-1)=='*') {
			uusi.setNimi(uusi.getNimi().substring(0,uusi.getNimi().length()-1));
		}
		return uusi;
		
	}

	/**
	 * avaa muokkaa ikkunan,jossa muokataan pelaajaa, joka on muokkausnappulaa painaessa valittuna
	 * @param muokattava muokattava pelaaja
	 * @return palauttaa muokatun pelaajan
	 */
	public Pelaaja muokkaaPelaaja(Pelaaja muokattava) {
	    Pelaaja uusi=MuokkaaPelaajaController.kysyPelaaja(muokattava);
		return uusi;
		
	}
	
	/**
	 * Tarvittavat alustukset. Tekstialue tekstikenttien tilalla.
	 * treeviewin tilalle vaihdettu 2 listchooseria ainakin toistaiseks
	 * TODO: treeview? 
	 */
    private void alusta() {
    	
    	hakuValikko.getItems().addAll("cat","dog");
    	
        System.out.print("here");
        
        panelPelaaja.addSelectionListener(e -> naytaPelaajaTiedot());
        panelJoukkue.addSelectionListener(e -> naytaJoukkueTiedot());


        
        
	}
    
    /**
     * asettaa joukkuepaneeliin olemassaolevat joukkueet
     */
    public void naytaJoukkueet() {
    	panelJoukkue.clear();
        List<Joukkue> sarjanJoukkueet = sarja.annaJoukkueet();
        for(Joukkue joukkue : sarjanJoukkueet) {
            panelJoukkue.add(joukkue.getNimi(),joukkue);
        }
    }
    /**
     * Metodi joka laittaa valitun joukkueen pelaajien nimet ja tunnusnumerot tekstilootaan
     */
    public void naytaJoukkueTiedot(){
    	Joukkue joukkue=panelJoukkue.getSelectedObject();
        joukkueenPelaajat();
        textJoukkue.setText(joukkue.getNimi());
        textValmentaja.setText(joukkue.getValmentaja());
        textPuh.setText(joukkue.getPuh());
        textMail.setText(joukkue.getEmail());

            
    }
    
    /**
     * Asettaa valitun joukkueen pelaajat pelaajapaneeliin
     */
    public void joukkueenPelaajat() {

        panelPelaaja.clear();
        List<Pelaaja> pelaajat = sarja.annaPelaajat(panelJoukkue.getSelectedObject().getTunnusNro());
            for(Pelaaja pelaaja : pelaajat) {
            	if (checkLisenssi.isSelected()) {
            		if(pelaaja.getLisenssi())panelPelaaja.add(pelaaja.getNimi(),pelaaja);
            	}
            	
            	else panelPelaaja.add(pelaaja.getNimi(),pelaaja);   
                
                
            }

            
        
    }


    /**
     * Metodi joka laittaa valitun pelaajan tiedot tekstilootaan
     */
    public void naytaPelaajaTiedot(){
        Pelaaja pelaaja=panelPelaaja.getSelectedObject();
        textPelaaja.setText(pelaaja.getNimi());
        textHetu.setText(pelaaja.getHetu());
        textIka.setText(pelaaja.getSyntymavuosi());
        textPaita.setText(pelaaja.getPaidanNumero());
        boolean lisenssi=pelaaja.getLisenssi();
        if(lisenssi) {
        	textLisenssi.setText("maksettu");     	
        }else textLisenssi.setText("ei maksettu");
    }
	
    /**
     * asetetaan viite sarjalle jota käytetään
     * @param sarja sarja jota käytetään
     */
    public void setSarja(Sarja sarja) {
        this.sarja=sarja;
        sarja.lueTiedosto();
        naytaJoukkueet();
        
        
    }


    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void setDefault(String arg0) {
        // TODO Auto-generated method stub
        
    }
    
    

    /**
    * @return asd
     */
     public boolean voikoSulkea() {
    //tallenna();  
     return true;
     }
        
        /**
         * @return s
         */
     /*
    public boolean avaa() {
        
        String nimi = AlkuruutuController.handleSarja();
        if (nimi == null) return false;
        lueTiedosto(nimi);
        return true;
        
        }
        */


    /**
     * lähettää sarjalle pyynnön lukea tiedostoista pelaajat ja joukkueet
     */
    public void lueTiedosto() {
        //setTitle("Sarja: " + sarjanNimi);

        sarja.lueTiedosto();
        
    }       
    
    /**
     * tallentaa sarjan tiedot 
     */
    public void tallenna() {
        sarja.tallenna();
    }

    /**
     * poistaa valitun pelaaja tai joukkueen ja sen pelaajat
     */
    private void poista() {
    	if(panelPelaaja.getSelectedObject()!=null) {
    		sarja.poistaPelaaja(panelPelaaja.getSelectedObject().getTunnusNro());
    		joukkueenPelaajat();
    		return;
    	}
    	
        if(panelJoukkue.getSelectedObject()!=null) {
        	boolean poistetaan=ModalController.showModal(SarjaGUIController.class.getResource("poisto.fxml"), "",null, false);
        	if(poistetaan) {
        		sarja.poistaJoukkue(panelJoukkue.getSelectedObject().getTunnusNro());
        		panelPelaaja.clear();
        		naytaJoukkueet();
        	}
        	return;
        }
        
         Dialogs.showMessageDialog("klikkaa ensin pelaajaa tai joukkuetta, jonka haluat poistaa");
			
		}

    public void hae(boolean joukkueValittu,String haettava) {
    	if (joukkueValittu) {
    		if (haettava=="nimi") {
    			List<Joukkue> haetut =sarja.haeNimi(hakuKentta.getText());
    			panelJoukkue.clear();
    			panelPelaaja.clear();
    			
    			for(Joukkue joukkue:haetut) {
    				panelJoukkue.add(joukkue.getNimi(),joukkue);
    			}
    		} //TODO else?
    		
    	}
    	
    }
}

