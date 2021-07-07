package NewPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class oneSingleJsonFile {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		JSONArray js = new JSONArray();
		ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");

		// Object of Statement class will help us to execute the queries.
		Statement st = conn.createStatement();
		ResultSet rs = st
				.executeQuery("Select * from CustomerInfo where Location = 'Asia' and PurchaseDate=curdate();");
		while (rs.next()) {
			CustomerDetails c = new CustomerDetails();
			c.setCourseName(rs.getString(1));
			c.setPurchaseDate(rs.getString(2));
			c.setAmount(rs.getInt(3));
			c.setLocation(rs.getString(4));
			a.add(c);
			
			
		}

		for (int i = 0; i < a.size(); i++) {
			ObjectMapper o = new ObjectMapper();
			o.writeValue(new File("D:\\Mrinmoy Biswas\\Frameworks\\JsonJava\\customerInfo" + i + ".json"), a.get(i));
			Gson g = new Gson();
			String jsonString = g.toJson(a.get(i));
			js.add(jsonString);

		}

		JSONObject jo = new JSONObject();
		jo.put("data", js);
		System.out.println(jo.toJSONString());
		String unescapeString = StringEscapeUtils.unescapeJava(jo.toJSONString());
		System.out.println(unescapeString);
		String strMiddle = unescapeString.replace("\"{", "{");
		String finalString = strMiddle.replace("}\"", "}");
		System.out.println(finalString);

		try (FileWriter file = new FileWriter("D:\\Mrinmoy Biswas\\Frameworks\\JsonJava\\SingleJson.json")) {
			file.write(finalString);

		}

		conn.close();
	}
}
