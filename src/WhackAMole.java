import java.applet.AudioClip;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*;

public class WhackAMole implements ActionListener {

	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	public Date timeAtStart;
	public int whackTimesCorrect = 0;
	public int whackTimesWrong = 0;

	public static void main(String[] args) {
		WhackAMole instance = new WhackAMole();
		instance.setupGUI();
		instance.drawButtons();
		
		instance.timeAtStart = new Date();
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
	
	private void endGameWin() {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / whackTimesCorrect)
	          + " moles per second.");
	}
	
	private void endGameLose() {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / whackTimesCorrect)
	          + " moles per second.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (button.getText().equals("MOLE!")) {
			playSound("pong copy.wav");
			whackTimesCorrect++;
		} else {
			String[] missed = { "You can't catch me", "I'm over there", "Missed me" };
			speak(missed[new Random().nextInt(missed.length)]);
			whackTimesWrong++;
		}
		
		frame.dispose();
		frame = new JFrame();
		panel.removeAll();
		setupGUI();
		
		if (whackTimesCorrect >= 10) {
			JLabel label = new JLabel("You won! *applause and cheering* *rose hits your shirt*");
			panel.add(label);
			
			endGameWin();
		} else if (whackTimesWrong >= 5) {
			JLabel label = new JLabel("You lost! *booing* *tomato hits your shirt*");
			panel.add(label);
			
			endGameLose();
		} else {
			drawButtons();
		}

		try {
			Thread.sleep(1000);
		} catch (Exception x) {

		}
	}
}
