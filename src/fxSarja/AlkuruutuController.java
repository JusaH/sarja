package fxSarja;



import java.io.File;
import fi.jyu.mit.fxgui.*;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Jussi Höykinpuro
 * @version 13.2.2019
 *
 */
public class AlkuruutuController implements ModalControllerInterface<String>{
    private String nimi=null;

    @FXML
    private MenuItem menuSulje;

    @FXML
    private MenuItem menuInfo;

    @FXML
    private MenuItem menuOhje;

    @FXML
    private TextField fieldSarja;

    @FXML
    private Button buttonJatka;

    @FXML
    private void handleOhje() {
		SarjaGUIController.ohje();

    }
    
    @FXML
    private void handleInfo() {
        ModalController.showModal(SarjaGUIController.class.getResource("info.fxml"), "pelaaja", null, "");	

    }


    /**
     * Tämä handlaa sarjan avaamisen. Palauttaa annetun sarjan nimen. Toistaiseksi palauttaa
     * aina saman nimen kun ei vielä lueta tiedostoja
     */
    @FXML
    
    public void handleSarja() {
        nimi = fieldSarja.getText();
        File file = new File(nimi);
		
        if (!file.isDirectory() && luodaanko()) luoTiedosto();
        
        if (file.isDirectory()) {
        Stage stage = (Stage) buttonJatka.getScene().getWindow();
        stage.close();
        return;
        }
        nimi=null;
        return;
    }

    private boolean luodaanko() {
		return  fi.jyu.mit.fxgui.Dialogs.showQuestionDialog("Uusi","Antamaasi sarjaa ei l�ytynyt, luodaanko uusi?","kyll�","peruuta");
		
	}

	private void luoTiedosto() {
		File dir = new File(nimi);
		dir.mkdir();
		handleSarja();
	}

	/**
     * Sulkee ohjelman
     */
    @FXML
    public  void handleSulje() {
		System.exit(0);

    }

	@Override
	public String getResult() {
		
		return nimi;
	}

	@Override
	public void handleShown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefault(String arg0) {
		// TODO Auto-generated method stub
		
	}
    
    

}
