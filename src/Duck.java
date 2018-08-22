import java.applet.AudioClip;

import javax.swing.JApplet;

public class Duck {
	private String favoriteFood;
	private int numberOfFriends;
	
	Duck(String favoriteFood, int numberOfFriends) {
	       this.favoriteFood = favoriteFood;
	       this.numberOfFriends = numberOfFriends;
	}
	
	public static void main(String args[]) {
		 Duck daffy = new Duck("donuts", 5);
		 daffy.quack(); 
	}
	
	public void quack() {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource("pong copy.wav"));
		sound.play();
		try {
			Thread.sleep(1000);
			sound.stop();
		} catch (Exception e) {
			
		}
	}
}
