

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BMIApp extends Application {

    public static void main( String[] args )
    {
		launch(args);		
	}

    @Override
	public void start(Stage primaryStage) throws Exception {
				
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BMIView.fxml"));
		Parent root = loader.load();
		//BMIController controller = loader.getController();
			
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("BMISettings.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculate BMI");
		primaryStage.show();
	}

}
