package onePlayer;

import java.util.concurrent.Semaphore;

public class Block implements Piece{
	//SINGLE BLOCK
	char color;
	Coordinate coor;
	DMPlayer player;
	Block connected;
	Semaphore lock;

	public Block(char col, Coordinate cord, DMPlayer p ){
		color = col;
		coor=cord;
		player=p;
	}
	
	/** 
	 * removes itself from board by replacing itself with a gremblin
	 * also drops its attachment if it had one
	 * RETURNS 1 IF IT WAS ATTACHED
	 */
	public int remove() {
		if(connected!=null){//detach yourself
			connected.connected=null;
			connected.drop();
			new Gremblin(coor,player);
			return 1;
		}
		new Gremblin(coor,player);
		return 0;
	}

	/**
	 * Drop until you hit something.
	 */
	public int drop() {
		int moves =0;
		Piece[][] board =player.board;
		//SEPERATE IDEA FOR IF IT IS CONNECTED
		
		
		while(coor.row<15){
			if(board[coor.row+1][coor.col].getColor()=='-'){//if thing below you is '-'
				coor.row++;
				moves++;
			}
		}
		return moves;
	}

	public char getColor(){
		return color;
	}
	
	public boolean isConnected() {
		return connected!=null;
	}



}
