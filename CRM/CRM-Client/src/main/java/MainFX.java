
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application  {
	public void start(Stage primaryStage) {
		  // Read file fxml and draw interface.
Parent root = null;
		try {
			root = FXMLLoader.load(getClass()
			        .getResource("/tn/"
			        		+ "esprit/CRM/gui/test.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

primaryStage.setTitle("My Application");
primaryStage.setScene(new Scene(root));
primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}