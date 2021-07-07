package NewPackage;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class extractJson {
	public static void main(String[] args) throws IOException, JsonMappingException, IOException {
		ObjectMapper o=new ObjectMapper();
		CustomerDetailsAppium c=o.readValue(new File("D:\\Mrinmoy Biswas\\Frameworks\\JsonJava\\customerInfo0.json"), CustomerDetailsAppium.class);
		System.out.println(c.getCourseName());
		System.out.println(c.getStudentName());
		System.out.println(c.getAmount());
		System.out.println(c.getLocation());
		System.out.println(c.getPurchaseDate());
		// Like this we can take values from JSON to Java Object
	}
}
