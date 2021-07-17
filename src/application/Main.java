package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception  {
			ViewSwitcher.initializeScene(new Scene(new Pane()));
			ViewSwitcher.switchTo(View.LOGIN);
			primaryStage.setScene(ViewSwitcher.getScene());
			primaryStage.show();
	}
	
	public static void main(String[] args) {	
			launch(args);
	}
}
