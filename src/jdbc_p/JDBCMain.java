package jdbc_p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			//url id password
			Statement stmt = con.createStatement();
			
			//stmt.executeQuery("SELECT * FROM test2");
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM test2");
			while(rs.next()) {
				String id = rs.getString("identity");
				Date reg_date = rs.getDate("REG_DATE");
				int grade = rs.getInt("grade");
				System.out.println(id+","+reg_date+","+grade+">>>>>>>>");
			}
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
