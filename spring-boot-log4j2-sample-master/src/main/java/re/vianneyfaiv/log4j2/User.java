package re.vianneyfaiv.log4j2;

public class User {
	
	
	public String title;
	public String name;
	public String address;
	
	
	public User(String title, String name, String address) {
		super();
		this.title = title;
		this.name = name;
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
