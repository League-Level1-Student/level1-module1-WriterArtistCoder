import java.awt.event.*;

import javax.swing.*;

public class CatRunner {

	public static void main(String[] args) {
		Cat test = new Cat("Fatso the Catso");
		test.meow();
		test.printName();
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Kill cat");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				test.kill();
			}
		});
		
		frame.add(button);
		frame.pack();
	}

}
