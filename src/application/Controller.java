package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.ButtonType;


public class Controller {
	UserDAO dao = new UserDAO();

	@FXML
	private TextField username, password, quizID;
	public static Alert alert = new Alert(AlertType.ERROR);
	public static ArrayList<String> questionSet = null;

	public static int offSet = 0, remainingQues = 0, qID = 0, totalQues = 0, currentQues = 0, ansOffset = 5, currentQuesNo = 1;
	public void onLogin(ActionEvent event) throws Exception {
		boolean response = dao.checkUser(username.getText().toString(), password.getText().toString());
		if(response) {
			System.out.println("Password Match!");
			ViewSwitcher.switchTo(View.HOME);
		}
		else {
			System.out.println("Wrong Pass!");
			alert.setContentText("Wrong username or Password!");
			alert.show();
		}
		
	}

	public void onRegister(ActionEvent event) throws Exception {
		boolean success = dao.addUser(username.getText().toString(), password.getText().toString());
		
		if (success) {
			System.out.println("Successfully Registered.");
			ViewSwitcher.switchTo(View.HOME);
		}
		else {
			System.out.println("duplicate!!");
			alert.setContentText("username already exist!");
			alert.show();
		}
	} 
	
	
	public void onTakeQuiz(ActionEvent event) throws Exception {
		qID = Integer.parseInt(quizID.getText().toString());
		boolean response = dao.checkQuizID();
		if (response) {
			System.out.println("found matching id");
			questionSet = dao.getQuestionSet();
			for (String s: questionSet) System.out.println(s);
			offSet = 0;
			totalQues = questionSet.size() / 6;
			remainingQues = totalQues;
			currentQues = 0;
			System.out.println("ques count = " + remainingQues);
			ViewSwitcher.switchTo(View.TAKEQUIZ);

			
		} else {
			alert.setContentText("Invalid quiz ID!");
			alert.show();
		}
	}


	public void onCreateNewAccount(ActionEvent event) throws Exception {
		ViewSwitcher.switchTo(View.REGISTER);
	}

	public void onBackToLogin(ActionEvent event) throws Exception {
			ViewSwitcher.switchTo(View.LOGIN);
	}

	public static void reset() {
		offSet = 0; 
		remainingQues = 0;
		qID = 0; 
		totalQues = 0;
		currentQues = 0; 
		ansOffset = 5;
		TakeQuizController.correctAnswers = 0;
		questionSet = null;
	}
	/// new code 


	
	public void onCreateQuiz(ActionEvent event) throws Exception {
		qID = dao.getQuizID();
		ViewSwitcher.switchTo(View.CREATEQUIZ);
	}



	

}
