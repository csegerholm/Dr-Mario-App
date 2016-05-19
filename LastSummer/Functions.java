package onePlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Functions {
	
	//produces a random colored Gremblin 
	private static Gremblin getRandomGrem(DMPlayer p){
		double ran = Math.random();
		//red
		if(ran<=.333){
			return new Gremblin('r',p);
		}
		//blue
		if(ran<.667){
			return new Gremblin('b',p);
		}
		//yellow
		return new Gremblin('y',p);
	}

	
	/**
	 * Looks if this block makes four in a row
	 * @param block = block to examine
	 * @return array of pieces that must disappear
	 */
	public static Piece[] findFour(Piece singleBlock){
		
		
		return null;
	}
	
	/**
	 * If I delete p, each piece in Piece[] must be dropped
	 */
	public static Piece[] afterMath(Piece p){
		return null;
		
	}

	public static void initBoardUsingTxtFile(DMPlayer player){
		player.numGremsLeft=0;
		char c='0';
		String filename = "Level"+player.level;
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("LevelDesigns\\"+filename+".txt"));
			for(int i = 0; i< player.board.length; i++){
				for(int j=0; j< player.board[i].length; j++){
					//get the next char from the file
					c = (char)br.read();
					Coordinate coor = new Coordinate(i,j);
					if(c=='x'){
						Gremblin grem = getRandomGrem(player);
						grem.coor = coor;
						player.board[i][j]= grem;
						player.numGremsLeft++;
					}
					else{
						Gremblin grem = new Gremblin(coor,player);
						player.board[i][j]= grem;
					}
					//READ THE SPACE CHAR
					br.read();
				}
				//READ NEW LINE CHAR
				br.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
