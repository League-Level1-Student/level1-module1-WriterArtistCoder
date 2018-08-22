
public class HarryRunner {

	public static void main(String[] args) {
		HarryPotter test = new HarryPotter();
		test.makeInvisible(true);
		test.spyOnSnape();
		test.makeInvisible(false);
		test.castSpell("Stupefy");
	}

}
