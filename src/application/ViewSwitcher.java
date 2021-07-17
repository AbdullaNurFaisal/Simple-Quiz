package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ViewSwitcher {
	
	private static Scene scene = null;

	public static void initializeScene(Scene passedScene) {
		scene = passedScene;
	}
	public static Scene getScene() {
		return scene;
	}
	
	public static void switchTo(View view) throws Exception
	{
		if(scene == null) {
			System.out.println("NO Scene!!");
			return;
		}
		Parent root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getSceneName()));
		scene.setRoot(root);
		
	}

}
