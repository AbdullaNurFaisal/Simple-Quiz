package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ResultController implements Initializable {
	@FXML
	Text correctAns;
	public void onBackToLogin(ActionEvent event) throws Exception {
		Controller.reset();
		ViewSwitcher.switchTo(View.LOGIN);
	}

	public void onBackToHome(ActionEvent event) throws Exception {
		Controller.reset();
		ViewSwitcher.switchTo(View.HOME);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		correctAns.setText(String.valueOf(TakeQuizController.correctAnswers)
			+ " out of " 
			+ String.valueOf(Controller.totalQues) 
			+ " ");
	}
	
}
