package fxSarja;
	
import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import sarja.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * 
 * @author Jussi Höykinpuro
 * @version 11.2.2019
 *
 */
public class SarjaMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            
            final FXMLLoader ldr = new FXMLLoader(getClass().getResource("SarjaGUIVIew.fxml"));
            final Pane root = (Pane)ldr.load();
            final SarjaGUIController sarjaCtrl = (SarjaGUIController)ldr.getController();

            final Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("sarja.css").toExternalForm());
            
            
            
            
            Sarja sarja = new Sarja(ModalController.showModal(SarjaGUIController.class.getResource("alkuruutu.fxml"), "",null, ""));
            if (sarja.getNimi()==null) Platform.exit();
            sarjaCtrl.setSarja(sarja);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sarja");
            
            primaryStage.setOnCloseRequest((event) ->{
                sarjaCtrl.tallenna();
                Platform.exit(); 
            });
            
            primaryStage.show();
            
            
            /*
            Application.Parameters params = getParameters();
            if(params.getRaw().size() > 0)
                sarjaCtrl.lueTiedosto(params.getRaw().get(0));
            else
                if(!sarjaCtrl.avaa()) Platform.exit();
                */

        } catch(Exception e) {
            e.printStackTrace();
		}
	}
	/**
	 * aaa
	 * @param args nope
	 */
	public static void main(String[] args) {
		launch(args);
	}
}