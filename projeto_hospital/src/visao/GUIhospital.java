package visao;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class GUIhospital extends Application {
	@Override
	public void start(Stage stagePrincipal) throws Exception {
       
		
        Parent root = FXMLLoader.load(getClass().getResource("painelFX.fxml"));
        Scene scene = new Scene(root); 
        stagePrincipal.setScene(scene); 
        stagePrincipal.setTitle("Hospital");
        stagePrincipal.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
