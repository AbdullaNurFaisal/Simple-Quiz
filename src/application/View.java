package application;

public enum View {
	
	HOME("Home.fxml"),
	LOGIN("LogIn.fxml"),
	REGISTER("Register.fxml"),
	TAKEQUIZ("TakeQuiz.fxml"),
	RESULT("Result.fxml"),
	CREATEQUIZ("CreateQuiz.fxml");
	
	private String sceneName;
	
	View(String sceneName) {
		this.sceneName = sceneName;
	}

	public String getSceneName() {
		return sceneName;
	}
	
	

}