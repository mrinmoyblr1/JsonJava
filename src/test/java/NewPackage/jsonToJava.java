package NewPackage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class jsonToJava {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= null;
		ArrayList<CustomerDetails> a=new ArrayList<CustomerDetails>();		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root", "root");
		// Object of Statement class will help us to execute the queries.
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("Select * from CustomerInfo where Location = 'Asia' and PurchaseDate=curdate();");
		while(rs.next()) 
		  { 
		  CustomerDetails c=new CustomerDetails(); 
		  c.setCourseName(rs.getString(1));
		  c.setPurchaseDate(rs.getString(2)); 
		  c.setAmount(rs.getInt(3));
		  c.setLocation(rs.getString(4)); 
		  a.add(c);
		  }	
		  for(int i=0;i<a.size();i++) 
		  { 
			  ObjectMapper o=new ObjectMapper();
			  o.writeValue(new File("D:\\Mrinmoy Biswas\\Frameworks\\JsonJava\\customerInfo"+i+".json"), a.get(i)); 
		  }
		/*
		 * // ObjectMapper is class from jackson API ObjectMapper o=new ObjectMapper();
		 * o.writeValue(new
		 * File("D:\\Mrinmoy Biswas\\Frameworks\\JsonJava\\customerInfo.json"), a);
		 * 
		 */
		System.out.println("Mrinmoy Biswas");
		conn.close();
	}
}
