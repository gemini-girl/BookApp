

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test {

	Connection c;
	Statement s;
	PreparedStatement p;
	ResultSet rs;	
	Scanner input = new Scanner(System.in);

	public void search() throws SQLException{
		Statement s;
		ResultSet rs;
		s = c.createStatement();
		/*System.out.println("Enter Column Name:");
		String column = input.nextLine();
		System.out.println("Enter value:");
		String value = input.nextLine();
		rs= s.executeQuery("select * from Authors a, Titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN and " +column +"=" +"'"+ value + "'");
		rs= s.executeQuery("select * from Authors a, Titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN");*/
		rs= s.executeQuery("insert into Titles values ('123456', 'Joker', '123', '2014')");
		while(rs.next()){
			System.out.println(rs.getString("ISBN") +"   "+rs.getString("Title")  +"   "+ rs.getString("EditionNumber")+"   "+rs.getString("Copyright") );
		}
	}
	public static void main(String args[])
	{
		try{
			test jdbc = new test();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		jdbc.c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","books","books");
		jdbc.search();
		//jdbc.insert();
		
		}
		catch(Exception e){
			System.out.println("error");
			System.out.println(e.getMessage());
		}	
	}

}
