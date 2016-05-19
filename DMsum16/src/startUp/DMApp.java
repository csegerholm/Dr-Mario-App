package startUp;

import java.awt.Dimension;
import javax.swing.JFrame;


/**
 * This will be the process that starts the game.
 * @author cms549
 */
public class DMApp {
	
	/**
	 * Will be in use the whole time
	 */
	JFrame frame;
	
	/**
	 * Holds the panel for selecting players and level
	 */
	StartMenu startMenu;
	
	public DMApp(){
		frame= new JFrame("Dr. Mario");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startMenu = new StartMenu(this);
		frame.setContentPane(startMenu);
		frame.pack();
		frame.setSize(new Dimension(1300,650));
	}
	
	public void startGame(Player[] p){
		if(p.length==1){
			//start game for 1 person
			
		}
		else{
			//start game for 2 people
		}
		
	
	}
	
	/**
	 * Starts application at the select amount of players screen
	 * @param args
	 */
	public static void main(String[] args) {
		new DMApp();
	}
}
