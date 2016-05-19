package startUp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Select the amount of players you wish to play with
 * @author cms549
 *
 */
public class StartMenu extends JPanel{
	/**
	 * This will be used to switch screens
	 */
	public DMApp home;
	
	/**
	 * This is screen for switching the levels
	 */
	public LevelMenu levMenu;
	
	
	//JTextFields to draw out the screen
	private JTextField textField;
	
	/**
	 * Constructor - creates player amount selection screen
	 * @param dmApp 
	 */
	public StartMenu(DMApp dmApp){
		home = dmApp;
		levMenu = new LevelMenu(home);
		//Set color to blue
		setBackground(Color.ORANGE);
		//Array layout where you pick coordinates of each component
		setLayout(null);
		updateScreen();
	}
	
	/**
	 * Redraws the screen using current data.
	 */
	public void updateScreen() {
		removeAll();
		makeHeaderText();
		makeOptions();
		revalidate();
	}

	/**
	 * Sets up the Header Text "Please Select Player Amount:" as a JTextField that is non editable
	 */
	private void makeHeaderText(){
		textField = new JTextField("Please Select Player Amount:");
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(500, 20, 200, 30);
		add(textField);
	}
	
	/**
	 * Draws buttons for amount of players
	 */
	private void makeOptions(){
		JButton one = new JButton("1");
		one.setBounds(500, 150, 200, 100);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to level screen
				toLevelMenu(1);
			}
		});
		add(one);
		
		JButton two = new JButton("2");
		two.setBounds(500, 350, 200, 100);
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//switch to level screen
				toLevelMenu(2);
			}
		});
		add(two);
	}
	
	private void toLevelMenu(int players){
		//set frame
		home.frame.setContentPane(levMenu);
		levMenu.updateScreen(players);
	}
	
}