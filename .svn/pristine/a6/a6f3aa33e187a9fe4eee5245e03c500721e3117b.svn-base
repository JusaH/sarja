package fxSarja;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sarja.*;

/**
 * @author Jussi Höykinpuro
 * @version 13.2.2019
 *
 */
public class MuokkaaPelaajaController implements ModalControllerInterface<Object>{
	
	private static Pelaaja muokattava;
	
	
    
    @FXML
    private TextField PELAAJAnimi;

    @FXML
    private TextField PELAAJAhetu;

    @FXML
    private ChoiceBox<?> choiceBoxJoukkue;

    @FXML
    private TextField PELAAJAika;

    @FXML
    private TextField PELAAJAnro;

    @FXML
    private CheckBox checkBoxLisenssi;

    @FXML
    private Button PELAAJAtallenna;
    
    @FXML
    private Button peruuta;
    
    @FXML
    void tallennaPelaaja() {
    	
    	Pelaaja testattava=new Pelaaja();
    	
    	
    	testattava.setNimi(PELAAJAnimi.getText());
    	testattava.setHetu(PELAAJAhetu.getText()); 
    	testattava.setSyntymavuosi(2019-Integer.parseInt(PELAAJAika.getText()));
    	testattava.setNro(PELAAJAnro.getText());
    	testattava.setLisenssi(checkBoxLisenssi.isSelected());
    	
    	String virheIlmoitus=testattava.oikeellisuusTarkistus();
    	
    	if (virheIlmoitus.length()==0){
    	muokattava=testattava;
    	peruuta();
    	}
    	
    	else Dialogs.showMessageDialog(virheIlmoitus);
    	
    }


	@FXML
    void peruuta() {
        Stage stage = (Stage) peruuta.getScene().getWindow();
        stage.close();

    }
	
	@FXML
    void vainNumeroita() {
		try 
        { 
            Integer.parseInt(PELAAJAika.getText()); 
        }  
        catch (NumberFormatException e)  
        { 
            PELAAJAika.clear(); 
        } 
    }


	@Override
	public Pelaaja getResult() {
		return muokattava;
	}

	@Override
	
	public void handleShown() {
		

		PELAAJAnimi.setText( muokattava.getNimi());
		PELAAJAhetu.setText( muokattava.getHetu());
		PELAAJAika.setText( muokattava.getSyntymavuosi());
		PELAAJAnro.setText( muokattava.getNro());
	

			
	}

	@Override
	public void setDefault(Object arg0) {
		//
	}


	public static Pelaaja kysyPelaaja(Pelaaja oletus) {
		muokattava = oletus;
		return ModalController.showModal(SarjaGUIController.class.getResource("muokkaapelaajaa.fxml"), "",null, oletus);
	}
	

}
