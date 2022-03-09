import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;

public class BMIApp extends Application {

	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(new File("src\\BMI.fxml").toURI().toURL());
		Scene sc = new Scene(root);
		primaryStage.setScene(sc);
		primaryStage.setTitle("BMI App");
		primaryStage.show();
	}
	

}
