package onePlayer;


public interface Piece {
	/*
	Semaphore lock;
	char color;
	boolean isMoveable;
	Piece connectedPiece;
	Coordinate coor;
	DMPlayer player; //used to access grem count
	 */
	
	/**
	 * Remove yourself and add a blank space where you are and adjust player data
	 * @return 0 on success
	 */
	public int remove();
	
	/**
	 * Call this to drop the piece (should be called when things under it disappear).
	 * @return number of spaces it dropped
	 */
	public int drop();
	
	public char getColor();
	public boolean isConnected();
}
