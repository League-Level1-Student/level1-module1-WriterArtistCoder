

public class RaceCarRunner {
	public static void main(String[] args) {
		/* Do the following things without changing the RaceCar class */
		
		// 1. Create a RaceCar and place it in 5th position
		RaceCar test = new RaceCar("Chrysler", 5);
		// 2. Print the RaceCar's position in the race
		System.out.println(test.getPositionInRace());
		// 3. Crash the RaceCar
		test.crash();
		// 4. If the car is damaged. Bring it in for a pit stop.
		if (test.damaged) {
			test.pit();
		}
		// 5. Help the car move into first place.
		while (test.getPositionInRace() > 1) {
			if (Math.random() < 0.8) {
				test.overtake();
			} else if (Math.random() < 0.7) {
				test.crash();
			}
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
		System.out.println("You won!");
	}
}
