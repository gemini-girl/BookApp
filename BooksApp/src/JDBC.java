
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {
	
	Connection c;
	Scanner input = new Scanner(System.in);

	public void searchBooks() throws SQLException{
		Statement s;
		ResultSet rs;
		s = c.createStatement();
		System.out.println("Enter Column Name:");
		String column = input.nextLine();
		System.out.println("Enter value:");
		String value = input.nextLine();
		rs= s.executeQuery("select * from Authors a, Titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN and " +column +"=" +"'"+ value + "'");
		while(rs.next()){
			System.out.println(rs.getString("ISBN") +"   "+rs.getString("Title")  +"   "+ rs.getString("FirstName")  +"   "+ rs.getString("LastName")+"   "+ rs.getString("EditionNumber")+"   "+rs.getString("Copyright") );
		}
	}
	public void insertBooks() throws SQLException{
		PreparedStatement inAuth;
		PreparedStatement inTit;
		PreparedStatement inID;
		ResultSet r;
		Statement st ;
		st = c.createStatement();
		try{
		System.out.println("Enter ISBN:");
		String isbn = input.nextLine();
		//int isbn = Integer.parseInt(is);

		System.out.println("Enter Title:");
		String titl = input.nextLine();
		
		System.out.println("Enter First Name:");
		String fname = input.nextLine();
		
		System.out.println("Enter Last Name:");
		String lname = input.nextLine();
		
		System.out.println("Enter Edition Number:");
		String edNum = input.nextLine();
		//int edNum = input.nextInt();
		
		System.out.println("Enter Copyright:");
		String copy = input.nextLine();
		//int copy = input.nextInt();
				
		inAuth=c.prepareStatement("insert into Authors (FirstName, LastName) values (?,?)");
		inAuth.setString(1, fname);
		inAuth.setString(2, lname);
		inAuth.executeUpdate();		
		
		inTit=c.prepareStatement("insert into Titles (ISBN, Title, EditionNumber, Copyright) values (?,?,?,?)");
		inTit.setString(1, isbn);
		inTit.setString(2, titl);
		inTit.setString(3, edNum);
		inTit.setString(4, copy);
		inTit.executeUpdate();
	
		
		inID=c.prepareStatement("insert into AuthorISBN (AuthorID, ISBN) values ((select AuthorID from Authors where FirstName = ? and LastName = ? ),(select ISBN from Titles where Title = ?))");
		inID.setString(1, fname);
		inID.setString(2, lname);
		inID.setString(3, titl);
		inID.executeUpdate();
		
		
		r= st.executeQuery("select * from Authors a, Titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN ");
		while(r.next()){
			System.out.println(r.getString("ISBN") +"   "+r.getString("Title")  +"   "+ r.getString("FirstName")  +"   "+ r.getString("LastName")+"   "+ r.getString("EditionNumber")+"   "+r.getString("Copyright") );
			}
	
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void updateBooks() throws SQLException{
		Statement s;
		PreparedStatement UpAuth;
		PreparedStatement UpTit;
		ResultSet rs;
		//Statement stat = null;
		s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		try{
		System.out.print("Enter the ISBN of the book you want to edit:");
		String upisbn = input.nextLine();
		
		rs = s.executeQuery("select a.AuthorID from Authors a, titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN and t.ISBN = '"+ upisbn+ "'");
		rs.absolute(1);
		int authID = 0;
		authID = rs.getInt("AuthorID");
		
		System.out.println("Enter the new details:");
		
		System.out.println("Enter Title:");
		String uptitl = input.nextLine();
		
		System.out.println("Enter First Name:");
		String upfname = input.nextLine();
		
		System.out.println("Enter Last Name:");
		String uplname = input.nextLine();
		
		System.out.println("Enter Edition Number:");
		//String upedNum = input.nextLine();
		int upedNum = input.nextInt();
		
		System.out.println("Enter Copyright:");
		//String upcopy = input.nextLine();
		int upcopy = input.nextInt();
				
		UpAuth=c.prepareStatement("Update Authors set FirstName = ?, LastName = ? where AuthorID = '" +authID +"'");
		UpAuth.setString(1, upfname);
		UpAuth.setString(2, uplname);
		UpAuth.executeUpdate();		
		
		UpTit=c.prepareStatement("Update Titles set Title = ?, EditionNumber = ?, Copyright = ? where ISBN = '" + upisbn + "'" );
		UpTit.setString(1, uptitl);
		UpTit.setInt(2, upedNum);
		UpTit.setInt(3, upcopy);
		UpTit.executeUpdate();
	
		rs= s.executeQuery("select * from Authors a, Titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN ");
		while(rs.next()){
			System.out.println(rs.getString("ISBN") +"   "+rs.getString("Title")  +"   "+ rs.getString("FirstName")  +"   "+ rs.getString("LastName")+"   "+ rs.getString("EditionNumber")+"   "+rs.getString("Copyright") );
			}
	
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	
	}
	public void deleteBooks() throws SQLException{
		Statement s;
		PreparedStatement delAuth;
		PreparedStatement delTit;
		PreparedStatement delAI;
		ResultSet rs;
		s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		try{
			System.out.print("Enter the ISBN of the book you want to edit:");
			int delisbn = input.nextInt();
			
			rs = s.executeQuery("select a.AuthorID from Authors a, titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN and t.ISBN = '"+ delisbn+ "'");
			rs.absolute(1);
			int authID = 0;
			authID = rs.getInt("AuthorID");
			
			System.out.println(authID +" "+ delisbn);
			
			delAI=c.prepareStatement("Delete from AuthorISBN where AuthorID = ? and ISBN = ?");
			delAI.setInt(1, authID );
			delAI.setInt(2, delisbn );
			delAI.executeUpdate();		
			
			delAuth=c.prepareStatement("Delete from Authors where AuthorID = ?");
			delAuth.setInt(1, authID );
			delAuth.executeUpdate();		
			
			delTit=c.prepareStatement("Delete from Titles where ISBN = ?");
			delTit.setInt(1, delisbn);
			delTit.executeUpdate();
		
			rs= s.executeQuery("select * from Authors a, Titles t, AuthorISBN ai where a.AuthorID = ai.AuthorID and t.ISBN = ai.ISBN ");
			while(rs.next()){
				System.out.println(rs.getString("ISBN") +"   "+rs.getString("Title")  +"   "+ rs.getString("FirstName")  +"   "+ rs.getString("LastName")+"   "+ rs.getString("EditionNumber")+"   "+rs.getString("Copyright") );
				}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	public static void main(String[] args) {
		try{
		JDBC jdbc = new JDBC();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		jdbc.c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","books","books");
		System.out.println("Select a option from below \n 1 for search \n 2 for Insert \n 3 for Update \n 4 for Delete ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		switch(n){
		case 1: 
			jdbc.searchBooks();
			break;
		case 2: 
			jdbc.insertBooks();
			break;
		case 3:
			jdbc.updateBooks();
			break;
		case 4:
			jdbc.deleteBooks();
			break;
		}
		}
		catch(Exception e){
			System.out.println("error");
			System.out.println(e.getMessage());
		}	
	}
}