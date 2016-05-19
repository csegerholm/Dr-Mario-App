package startUp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LevelMenu extends JPanel {
	
	/**
	 * This will be used to switch screens
	 */
	public DMApp home;
	
	private ArrayList<Player> players;
	
	public LevelMenu(DMApp home2) {
		home = home2;
		players = new ArrayList<Player>();
		//Set color to blue
		setBackground(Color.CYAN);
		//Array layout where you pick coordinates of each component
		setLayout(null);
	}

	/**
	 * Redraws the screen using current data.
	 */
	public void updateScreen(int playerAmt) {
		if(playerAmt>0){
			players=new ArrayList<Player>();
			for(int i=0; i<playerAmt; i++){
				players.add(new Player());
			}
		}
		removeAll();
		makeBackButton();
		makeStartButton();
		for(int i=0; i<players.size(); i++){
			makePlayerOption(i);
		}
		revalidate();
	}
	
	/**
	 * Sets up the Back Button to go back to start screen
	 */
	private void makeBackButton(){
		
		JButton back = new JButton("Back");
		back.setForeground(Color.WHITE);
		back.setBackground(Color.RED);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//go back to startMenu
				players=new ArrayList<Player>();
				home.startMenu.updateScreen();
				home.frame.setContentPane(home.startMenu);
			}
		});
		back.setBounds(1000, 0, 200, 30);
		add(back);
		
	}
	
	/**
	 * Draws the options of level and speed for each player
	 * @param playerNum
	 */
	private void makePlayerOption(int playerNum){
		int y=200*playerNum;
		Player p = players.get(playerNum);

		//LEVEL
		JSlider slider = new JSlider();
		slider.setForeground(Color.RED);
		slider.setBackground(Color.YELLOW);
		slider.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		slider.setValue(p.level);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum(20);
		slider.setMajorTickSpacing(1);
		slider.setBounds(100, y, 400, 50);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				p.level= slider.getValue();
			}
		});
		add(slider);
		//SPEED
		JSlider speedsld = new JSlider();
		speedsld.setForeground(Color.BLUE);
		speedsld.setBackground(Color.WHITE);
		speedsld.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		speedsld.setValue(p.speed);
		speedsld.setSnapToTicks(true);
		speedsld.setPaintTicks(true);
		speedsld.setPaintLabels(true);
		speedsld.setMaximum(3);
		speedsld.setMajorTickSpacing(1);
		speedsld.setBounds(100, y+100, 400, 50);
		speedsld.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				p.speed= speedsld.getValue();
			}
		});
		add(speedsld);
		
	}
	
	/**
	 * Creates the Start button which starts the game with the selected values.
	 */
	private void makeStartButton(){
		JButton start = new JButton("Start Game");
		start.setForeground(Color.WHITE);
		start.setBackground(Color.GREEN);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.startGame(players.toArray(new Player[players.size()]));
			}
		});
		start.setBounds(1000, 560, 200, 30);
		add(start);
	}
	
}
