package fxSarja;

import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author jussi
 * @version 23.4.2019
 *
 */
public class PoistaController implements ModalControllerInterface<Boolean>{
	private boolean poistetaanko=false;

	@FXML
    private Button POISTOperuuta;

    @FXML
    private Button POISTOpoista;

    @FXML
    void peruuta() {
    	Stage stage = (Stage) POISTOperuuta.getScene().getWindow();
        stage.close();
    }

    @FXML
    void poista() {
    	poistetaanko=true;
    	Stage stage = (Stage) POISTOpoista.getScene().getWindow();
        stage.close();
    }

	@Override
	public Boolean getResult() {
		return poistetaanko;
	}

	@Override
	public void handleShown() {
		//
	}

	@Override
	public void setDefault(Boolean oletus) {
		//
	}


}



