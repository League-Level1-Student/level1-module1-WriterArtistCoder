
public class Person {
	private String name;
	private String superpower;
	
	public static void main(String[] args) {
		
	}
	
	Person(String name, String superpower) {
		this.name = name;
		this.superpower = superpower;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getPower() {
		return this.superpower;
	}
	
	public void setPower(String newPower) {
		this.superpower = newPower;
	}
}
