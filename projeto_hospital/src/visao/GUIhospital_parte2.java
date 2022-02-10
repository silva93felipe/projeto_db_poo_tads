package visao;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GUIhospital_parte2 extends Application {
	@Override
	public void start(Stage stagePrincipal) throws Exception {
       
		
        Parent root = FXMLLoader.load(getClass().getResource("Gui955parteII.fxml"));
        Scene scene = new Scene(root); 
        stagePrincipal.setScene(scene); 
        stagePrincipal.setTitle("Hospital-Dependente");
        stagePrincipal.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
