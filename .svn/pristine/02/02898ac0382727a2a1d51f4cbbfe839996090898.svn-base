package fxSarja;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sarja.Joukkue;

public class MuokkaaJoukkueController implements ModalControllerInterface<Joukkue>{
private static Joukkue muokattava;
	

	@FXML
    private TextField JOUKKUEnimi;

    @FXML
    private TextField JOUKKUEvalmentaja;

    @FXML
    private TextField JOUKKUEpuh;

    @FXML
    private TextField JOUKKUEmail;

    @FXML
    private Button peruuta;

    @FXML
    private Button JOUKKUEtallenna;


    @FXML
    void tallennaJoukkue() {
    	if (JOUKKUEnimi.getText().isEmpty())
    		Dialogs.showMessageDialog("Nimi on pakollinen");
    	
    	else {
    	muokattava.setNimi(JOUKKUEnimi.getText());
    	muokattava.setValmentaja(JOUKKUEvalmentaja.getText());
    	muokattava.setPuh(JOUKKUEpuh.getText());
    	muokattava.setEmail(JOUKKUEmail.getText());

    	Stage stage = (Stage) peruuta.getScene().getWindow();
        stage.close();
    	}

    }
    
    @FXML
    void peruuta() {
    	muokattava.setNimi(muokattava.getNimi()+"*");
        Stage stage = (Stage) peruuta.getScene().getWindow();
        stage.close();

    }


	@Override
	public Joukkue getResult() {
		return muokattava;
	}

	public void vaihdaVari(){
		if (JOUKKUEnimi.getText().isEmpty())JOUKKUEnimi.setStyle("-fx-control-inner-background: red;");
		else JOUKKUEnimi.setStyle("-fx-control-inner-background: white;");
		
	}
	
	@Override
	public void handleShown() {
		

		JOUKKUEnimi.setText( muokattava.getNimi());
		vaihdaVari();
		JOUKKUEvalmentaja.setText( muokattava.getValmentaja());
		JOUKKUEpuh.setText( muokattava.getPuh());
		JOUKKUEmail.setText( muokattava.getEmail());
				
	}
	
	@Override
	public void setDefault(Joukkue arg0) {
		//
	}

	public static Joukkue kysyJoukkue(Joukkue oletus) {
		muokattava = oletus;
		return ModalController.showModal(SarjaGUIController.class.getResource("muokkaajoukkue.fxml"), "muokkaa",null, oletus);
	}



}
