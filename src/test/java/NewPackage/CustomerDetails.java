package NewPackage;
public class CustomerDetails {
	private String CourseName;
	private String PurchaseDate;
	private int Amount;
	private String location;
	
	// Get the Course Name from Database object class	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	// Get the Purchase Date from Database object class	
	public String getPurchaseDate() {
		return PurchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		PurchaseDate = purchaseDate;
	}
	
	// Get the Amount from Database object class	
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	// Get the Location from Database object class
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
