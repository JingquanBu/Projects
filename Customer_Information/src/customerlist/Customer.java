package customerlist;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String service;
	private String price;
	
	
	
	public Customer(String firstName, String lastName, String email, String service, String price) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.service = service;
		this.price = price;
	}



	public Customer(int id, String firstName, String lastName, String email, String service, String price) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.service = service;
		this.price = price;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getService() {
		return service;
	}



	public void setService(String service) {
		this.service = service;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", service=" + service + ", price=" + price + "]";
	}
	
	
	
	

}
