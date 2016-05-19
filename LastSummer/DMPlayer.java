package onePlayer;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class DMPlayer implements Runnable {

	char number;
	Block[] currBlock, nextBlock;
	Semaphore lock;//for pending Moves
	ArrayList<Character> pendingMoves;
	int speed;
	int level;
	Piece[][] board;
	int numGremsLeft;
	char gameplay; //p=pause, i = in, w= won, l = lost
	
	private static char getRandColor(){
		double ran = Math.random();
		//red
		if(ran<=.333){
			return 'R';
		}
		//blue
		if(ran<.667){
			return 'B';
		}
		//yellow
		return 'Y';
	}
	
	public Block[] createDoubleBlock(){
		Block[] b = new Block[2];
		b[0] = new Block(getRandColor(), new Coordinate(-1,-1), this);
		b[1]= new Block(getRandColor(), new Coordinate(-1,-2),this);
		b[0].connected= b[1];
		b[1].connected=b[0];
		return b;
	}
	
	public DMPlayer(char num, int s,int l){
		number = num;
		pendingMoves = new ArrayList<Character>();
		lock = new Semaphore(1);
		speed=s;
		level=l;
		board = new Piece[8][16];
		setupBoard();
		gameplay ='i';
	}
	
	/**
	 * Sets up the piece board with all of the greblins
	 */
	public void setupBoard(){
		Functions.initBoardUsingTxtFile(this);
		nextBlock = createDoubleBlock();
	}

	/**
	 * Reads in Input from user until someone else wins or I loose or i win
	 * @return
	 * @throws InterruptedException 
	 */
	public int gamePlayThread() throws InterruptedException{
		while(gameplay!='i'){
			System.out.println("Waiting to start playing game thread...");
			Thread.sleep(100);
		}
		char cMove;
		//listens to user and sends requests to current block
		while(gameplay=='i'){
			lock.acquire();
			if(pendingMoves.size()!=0){
				cMove= pendingMoves.get(0);
				pendingMoves.remove(0);
			}
			cMove ='n'; 
			lock.release();
			if(cMove!='n'){
				move(cMove);
			}
		}
		
		return 0;
	}

	/**
	 * Makes the move
	 * @param m = l,r,d,f
	 */
	private void move(char m){
		boolean placed = false;
		if(m=='l'){
				
		}
		else if(m=='r'){
			
		}
		else if(m=='f'){
			
		}
		else{//down
			
		}
		
		//check for four in a row
		Functions.findFour(singleBlock);
		//if four in a row
		Functions.afterMath();
	}
	
	public void run() {
		try {
			gamePlayThread();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void start() {
		Thread t = new Thread (this, "DMPlayer"+number);
        t.start ();
	}

}
