package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateQuizController implements Initializable {
	UserDAO dao = new UserDAO();
	@FXML
	private TextField question, option1, option2, option3, option4, answer;
	@FXML
	private Button submit, addQuestion;
	@FXML
	private Text quizID, questionID;
	public void onCreateNextQuestion(ActionEvent event) throws Exception {
		Controller.currentQuesNo++;
		ViewSwitcher.switchTo(View.CREATEQUIZ);
		boolean success = dao.addQuestion(
					Controller.qID, 
					question.getText().toString(),
					option1.getText().toString(),
					option2.getText().toString(), 
					option3.getText().toString(),
					option4.getText().toString(),
					answer.getText().toString()
				);
		if (success) {
			System.out.println("Successfully added new question.");
			ViewSwitcher.switchTo(View.CREATEQUIZ);
		} else {
			System.out.println("failed to create question");
		}
	}
	public void setID() {
		quizID.setText(String.valueOf(Controller.qID));
		questionID.setText(String.valueOf(Controller.currentQuesNo));
	}

	
	public void onBackToHome(ActionEvent event) throws Exception {
		onCreateNextQuestion(event);
		Controller.currentQuesNo = 1;
		Controller.alert = new Alert(AlertType.INFORMATION);
		Controller.alert.setContentText("Successfully created quiz. Quiz id =  " + Controller.qID);
		Controller.alert.show();
		ViewSwitcher.switchTo(View.HOME);
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setID();
	}
	

}
