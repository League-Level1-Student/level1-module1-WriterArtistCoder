import java.applet.AudioClip;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*;

// TODO http://level1.jointheleague.org/Mod3Recipes/WhackAMole.html

public class WhackAMole implements ActionListener {

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();

	public static void main(String[] args) {
		WhackAMole instance = new WhackAMole();
		instance.setupGUI();

		int i = 0;
		while (true) {
			if (i > 100) {
				instance.panel.removeAll();
				instance.drawButtons();
				i = 0;
			}
			i++;
		}
	}

	public void setupGUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(600, 600));

		frame.add(panel);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	public void drawButtons() {
		int moleNum = new Random().nextInt(24);
		for (int i = 0; i < 24; i++) {
			JButton b = new JButton("");

			if (i == moleNum) {
				b.setText("MOLE!");
				b.addActionListener(this);
			} else {
				b.addActionListener(this);
			}

			panel.add(b);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (button.getText().equals("MOLE!")) {
			playSound("pong copy.wav");
			try {
				Thread.sleep(1000);
			} catch (Exception x) {

			}
		} else {
			String[] missed = { "You can't catch me", "I'm over there", "Missed me" };
			speak(missed[new Random().nextInt(missed.length)]);
		}
	}
}
