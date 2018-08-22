public class CatAnimal {
	private String breed;
	private String furString;
	private boolean clawsVisible;

	public static void main(String args[]) {
		CatAnimal test = new CatAnimal("Siamese", "white and black");
		test.meow();
		test.pounce("Mouse");
	}
	
	public CatAnimal(String breed, String color) {
		this.breed = breed;
		this.furString = color;
		this.clawsVisible = false;
	}
	
	public void meow() {
		System.out.println("Cat: Mreow?");
	}
	
	public void pounce(String victim) {
		// victim must be all-lowercase except for first letter.
		System.out.println("Cat: YAHHH! I'll get you, " + victim.toLowerCase() + "!");
		System.out.println(victim + ": Ahhhhhh!");
	}
}
