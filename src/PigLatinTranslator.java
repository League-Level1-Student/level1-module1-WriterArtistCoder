/** 
 * Translation icon is by https://www.flaticon.com/authors/freepik
*/

import java.awt.Dimension;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PigLatinTranslator {
	
	public JFrame frame = new JFrame();
	public JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		PigLatinTranslator instance = new PigLatinTranslator();
		instance.setupGUI();
	}
	
	public void setupGUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		
		JButton go = new JButton();
		JLabel platin = new JLabel();
		JTextField en = new JTextField(10);
		
		try {
			Icon i = (Icon) new ImageIcon(ImageIO.read(new PigLatinTranslator().getClass().getResourceAsStream("translate.png")));
			go.setIcon(i);
		} catch (Exception e1) {
			
		}
		
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				platin.setText(translate(en.getText()));
			}
		});
		
		panel.add(en);
		panel.add(go);
		panel.add(platin);
		
		frame.setMinimumSize(new Dimension(600, 600));
	}
	
     /**
     * Method to test whether a character is a letter or not.
     * @param c The character to test
     * @return True if it's a letter
     */
     private static boolean isLetter(char c) {
          return ( (c >= 'A' && c <= 'Z') || (c >='a' && c <= 'z') );
     }

     /**
     * Method to translate one word into pig latin.
     * @param word The word in English
     * @return The pig latin version
     */
     private static String pigWord(String word) {
          int split = firstVowel(word);
          return word.substring(split)+"-"+word.substring(0, split)+"ay";
     }

     /**
     * Method to translate a sentence word by word.
     * @param s The sentence in English
     * @return The pig latin version
     */
     public String translate(String s) {
          String latin = "";
          int i = 0;
          while (i < s.length()) {

     // Take care of punctuation and spaces
          while (i < s.length() && !isLetter(s.charAt(i))) {
               latin = latin + s.charAt(i);
               i++;
          }

     // If there aren't any words left, stop.
          if (i>=s.length()) break;

     // Otherwise we're at the beginning of a word.
          int begin = i;
          while (i < s.length() && isLetter(s.charAt(i))) {
               i++;
          }
     // Now we're at the end of a word, so translate it.
          int end = i;
          latin = latin + pigWord(s.substring(begin, end));
          }
          return latin;
     }

     /**
     * Method to find the index of the first vowel in a word.
     * @param word The word to search
     * @return The index of the first vowel
     */
      private static int firstVowel(String word) {
          word = word.toLowerCase();
          for (int i=0; i < word.length(); i++)
               if (word.charAt(i)=='a' || word.charAt(i)=='e' ||
                    word.charAt(i)=='i' || word.charAt(i)=='o' ||
                    word.charAt(i)=='u')
                    return i;
               return 0;
     }
}