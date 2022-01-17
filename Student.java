import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class Student {
	private  int no;
	private String name;
	private String dob;
	private String doj;
	
	public Student(int no, String name, String dob, String doj) {
		super();
		this.no = no;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
	}
	public void create() {
		Connection con = getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("Insert into Student VALUES(?,?,?,?)");
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setString(3, dob);
			ps.setString(4, doj);
			
			if(ps.executeUpdate()>0) {
				System.out.println(name+" Successfully Added!");
			}else {
				System.out.println("Failed to Add");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	public void delete() {
		Connection con = getConnection();
		try {
			
			 
			PreparedStatement statement = con.prepareStatement("DELETE FROM student WHERE STUDENT_NAME = ?");
			statement.setString(1, name);
			 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A user was deleted successfully!");
			}}
			catch(SQLException e) {
				e.printStackTrace();
		}
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	public static  void read(int id) {
		Connection con = getConnection();
		try {
			
			 
			PreparedStatement statement = con.prepareStatement("SELECT * FROM student WHERE STUDENT_NO = ?");
			statement.setInt(1, id);
			 
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				System.out.println("STUDENT_NO " + rs.getInt("STUDENT_NO"));
				System.out.println("STUDENT_NAME " + rs.getString("STUDENT_NAME"));
				System.out.println("STUDENT_DOB " + rs.getString("STUDENT_DOB"));
				System.out.println("STUDENT_DOJ" + rs.getString("STUDENT_DOJ"));
				
				
			}
			}
			catch(SQLException e) {
				e.printStackTrace();
		}
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	public static void readAll() {
		Connection con = getConnection();
		try {
			
			 
			PreparedStatement statement = con.prepareStatement("SELECT * FROM student ");
			
			 
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				System.out.print("STUDENT_NO " + rs.getInt("STUDENT_NO")+" ");
				System.out.print("STUDENT_NAME " + rs.getString("STUDENT_NAME")+" ");
				System.out.print("STUDENT_DOB " + rs.getString("STUDENT_DOB")+" ");
				System.out.print("STUDENT_DOJ" + rs.getString("STUDENT_DOJ")+" ");
				 System.out.println();
				
			}
			}
			catch(SQLException e) {
				e.printStackTrace();
		}
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
			    
			    
	public void update() {
		Connection con = getConnection();
		try {
		

 
	PreparedStatement statement = con.prepareStatement("UPDATE student SET STUDENT_NAME= ?, STUDENT_DOB=? , STUDENT_DOJ =? WHERE STUDENT_NO= ?");
	
	statement.setString(1, name);
	statement.setString(2, dob);
	
	statement.setString(3, doj);
	
	
	statement.setInt(4,no);
	 
	int rowsUpdated = statement.executeUpdate();
	if (rowsUpdated > 0) {
	    System.out.println("An existing user  updated successfully!");
	}
	
	
	}
	catch(SQLException e) {
		e.printStackTrace();
}
	
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	
	
public static void main(String args[]) throws Exception {
		
 Student m = new Student( 8, "nivya", "8-7-1999", "3-9-2021" );
 Student k = new Student( 23, "Manisha", "16-09-1999", "6-9-2021" );
        k.create();
        Student.read(1);
        m.update();
		Student.readAll();
		m.delete();
	    }

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/internship";
		String uname = "root";
		String pass = "kavita@123";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname ,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    
		return con;
	}
}
	