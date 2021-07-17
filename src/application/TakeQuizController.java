package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class TakeQuizController implements Initializable {
	UserDAO dao = new UserDAO();
	@FXML	
	private Text t;
	@FXML
	private RadioButton rb1, rb2, rb3, rb4;
	@FXML
	private Button nextButton;
	@FXML
	private ToggleGroup tg;
	private String ans;
	public static int correctAnswers = 0;
	
	
	public void onSetQuestion() {
		t.setText(Controller.questionSet.get(Controller.offSet));
		rb1.setText(Controller.questionSet.get(Controller.offSet + 1));
		rb2.setText(Controller.questionSet.get(Controller.offSet + 2));
		rb3.setText(Controller.questionSet.get(Controller.offSet + 3));
		rb4.setText(Controller.questionSet.get(Controller.offSet + 4));
		
		
	}
	
	public void onNextQuestion() throws Exception {
		Controller.offSet += 6;
		Controller.remainingQues--;
		if (rb1.isSelected()) ans = "1";
		else if (rb2.isSelected()) ans = "2";
		else if (rb3.isSelected()) ans = "3";
		else if (rb4.isSelected()) ans = "4";
		System.out.println(Controller.questionSet.get(Controller.ansOffset) + " " + ans);
		if (Controller.questionSet.get(Controller.ansOffset).equals(ans)) correctAnswers++;
		
		Controller.ansOffset += 6;
		if (Controller.remainingQues == 0) {
			ViewSwitcher.switchTo(View.RESULT);
		} else {
			ViewSwitcher.switchTo(View.TAKEQUIZ);
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		onSetQuestion();
		if (Controller.remainingQues == 1) {
			nextButton.setText("Finish!");
		} else {
			nextButton.setText("Next question");
		}
	}
}
