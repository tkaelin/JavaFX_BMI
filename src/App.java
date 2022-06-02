
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
		Parent root = loader.load();
		/*
		 * if you need access to the controller, uncomment the following line
		 * BMIController controller = loader.getController();
		 */

		Scene scene = new Scene(root);

		/* use the stylesheet, if there is one defined */
		URL settingsURL = getClass().getResource("Settings.css");
		if (settingsURL != null) {
			scene.getStylesheets().add(settingsURL.toExternalForm());
		}

		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculate BMI");
		primaryStage.show();
	}

}
