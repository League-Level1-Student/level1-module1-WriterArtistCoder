/*
 *    Copyright (c) The League of Amazing Programmers 2013-2017
 *    Level 1
 */

/* 
 * 1. Watch this Smurf cartoon: https://www.youtube.com/watch?v=RqbpzEHuO2g
 * 2. In a Runner class, make a Handy Smurf. Use the methods below to make him eat, and print his name.
 * 3&4 see comments in code below
 * 5. Make a Papa Smurf and print his name, hat color and girl or boy.
 * 6. Make a Smurfette and print her name, hat color and girl or boy. 
 */

public class Smurf {

	private String name;

	Smurf(String name) {
		this.name = name;
	}

	public String getName() {
		return "My name is " + name + " Smurf.";
	}
	
	public static void main(String[] args) {
		Smurf test0 = new Smurf("Smurfette");
		test0.getName();
		test0.eat();
		System.out.println(test0.getHatColor());
		System.out.println(test0.isGirlOrBoy());
		
		Smurf test1 = new Smurf("Papa Smurf");
		test1.getName();
		test1.eat();
		System.out.println(test1.getHatColor());
		System.out.println(test1.isGirlOrBoy());
		
	}

	public void eat() {
		System.out.println(name + " Smurf is eating Smurfberries.");
	}

	/* Papa Smurf wears a red hat, all the others are white. */
	public String getHatColor() {
		// 3. Fill in this method
		if (name.equals("Papa") || name.equals("Papa Smurf"))
			return "red";
		else
			return "white";
	}

	/* Smurfette is the only female Smurf. */
	public String isGirlOrBoy() {
		// 4. Fill in this method
		if (name.equals("Smurfette") || name.equals("Smurfette Smurf"))
			return "female";
		else
			return "male";
	}

}



