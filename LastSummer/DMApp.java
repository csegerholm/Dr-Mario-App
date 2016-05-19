package onePlayer;

import java.io.IOException;
import javax.swing.JApplet;

public class DMApp extends JApplet {

	private static final long serialVersionUID = 1L;
	DMPlayer player;
	
	public DMApp() throws IOException, InterruptedException {
		//set up
		player= new DMPlayer('1',0,0);//level 10 slow
		//start each player
		startGame();
		//play again?
		System.out.println("Game over.");
	}
	
	private void startGame() throws IOException, InterruptedException {
		//make a thread for:
		//1 = gamePlay
		player.start();
		
		//3 = going down- one for each player
		MoveDownThread mdthread = new MoveDownThread(player);
		mdthread.start();
		
		//2 = reading inputs
		readInput();
	}

	/**
	 * Thread safe, locks before adding l,r,f
	 * Sends each buffer the users input (l=left, r = right, f= flip)
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	private void readInput() throws IOException, InterruptedException{
		//player one  = asd
		while(player.gameplay!='i'){
			System.out.println("Waiting to start reading user input...");
			Thread.sleep(100);
		}
		char curr;
		while(player.gameplay=='i'){
			curr = (char) System.in.read();
			if(curr == 'a'){
				player.lock.acquire();
				player.pendingMoves.add('l');
				player.lock.release();
			}
			else if(curr == 'd'){
				player.lock.acquire();
				player.pendingMoves.add('r');
				player.lock.release();
			}
			else if(curr =='s'){
				player.lock.acquire();
				player.pendingMoves.add('f');
				player.lock.release();
			}
		}	
	}

	
}
