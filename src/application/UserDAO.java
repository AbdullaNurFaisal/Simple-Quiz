package application;
import java.sql.*;
import java.util.ArrayList;
class UserDAO {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	boolean isConnected = false;
	void connect() throws Exception {
		final String url = "jdbc:postgresql://localhost:5432/quiz_application"; 
		final String user = "postgres";
		final String pass = "1111";
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, user, pass);
		isConnected = true;

	}
	void close_connection() throws Exception {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (st != null) {
			st.close();
			st = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		isConnected = false;
	}
	public boolean checkUser(String username, String password) throws Exception {
		if (!isConnected) connect();
		
		String query = "SELECT username, password FROM user_info where username = ? and password = ?"; 
		st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, password);
		rs = st.executeQuery();
		boolean result = true;
		if (!rs.isBeforeFirst()) result = false;
		close_connection();
		return result;
	} 
	public boolean checkUsername(String username) throws Exception {
		if (!isConnected) connect();
		
		String query = "SELECT username FROM user_info where username = ?"; 
		st = con.prepareStatement(query);
		st.setString(1, username);
		rs = st.executeQuery();
		boolean result = true;
		if (!rs.isBeforeFirst()) result = false;
		return result;
	} 
	
	public boolean addUser(String username, String password) throws Exception {
		if (!isConnected) connect();
		
		boolean username_exists = checkUsername(username);
		if (username_exists) {
			close_connection();
			return false;
		}
		String query = "INSERT INTO user_info VALUES (?, ?)";
		st = con.prepareStatement(query);
		
		st.setString(1, username);
		st.setString(2, password);
		int count = st.executeUpdate();
		boolean result = true;
		if (count <= 0) result = false;
		close_connection();
		return result;
		
		
	}
	public boolean checkQuizID() throws Exception {
		if (!isConnected) connect();
		String query = "SELECT quiz_id FROM quiz_info where quiz_id = ?"; 
		st = con.prepareStatement(query);
		st.setInt(1, Controller.qID);
		rs = st.executeQuery();
		boolean result = true;
		if (!rs.isBeforeFirst()) result = false;
		close_connection();
		return result;
	}
	ArrayList<String> getQuestionSet() throws Exception {
		ArrayList<String> queries = new ArrayList<>();
		if (!isConnected) connect();
		String query = "SELECT question, option1, option2, option3, option4, answer FROM quiz_info where quiz_id = ?"; 
		st = con.prepareStatement(query);
		st.setInt(1, Controller.qID);
		rs = st.executeQuery();
		while (rs.next()) {
			for (int col = 1; col <= 6; col++) {
				queries.add(rs.getString(col));
			}
		}
		
		return queries;
	}

	public boolean addQuestion(int quizID, String questionName, String op1, String op2, String op3, String op4, String answer) throws Exception
	{
		if (!isConnected) connect();
		String query = "INSERT INTO quiz_info VALUES (?, ?, ?, ?, ?, ?, ?)";
		st = con.prepareStatement(query);
		st.setInt(1, quizID);
		st.setString(2, questionName);
		st.setString(3, op1);
		st.setString(4, op2);
		st.setString(5, op3);
		st.setString(6, op4);
		st.setString(7, answer);
		int count = st.executeUpdate();
		boolean result = true;
		if (count <= 0) result = false;
		close_connection();
		return result;
	}
	
	public int getQuizID() throws Exception {
		if (!isConnected) connect();
		String query = "SELECT COUNT(*) FROM (SELECT DISTINCT quiz_id FROM quiz_info) as temp";
		st = con.prepareStatement(query);
		rs = st.executeQuery();
		rs.next();
		int count = rs.getInt("count");
		return count + 1;	
	}
	
	
}



