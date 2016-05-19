package onePlayer;


public class Gremblin implements Piece{

	char color;
	Coordinate coor;
	DMPlayer player;
	
	public Gremblin(char color, DMPlayer player){
		this.color=color;
		this.player = player;
	}

	//Easier way to create a blank space
	public Gremblin( Coordinate cord,DMPlayer p){
		this.color='-';
		this.player = p;
		coor = cord;
		player.board[coor.row][coor.col]=this;
	}
	
	/**
	 * Removes the gremblin from the game. 
	 * Decreases numGremsLeft for the player and changes its color to -
	 */
	public int remove(){
		
		if(color!='-'){//check if was already removed
			player.numGremsLeft--;
			color = '-';
		}
		return 0;
	}

	public int drop() {
		//Gremblin's don't drop neither do empty pieces
		return 0;
	}
	public char getColor(){
		return color;
	}
	public boolean isConnected() {
		return false;
	}
}
