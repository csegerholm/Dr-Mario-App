package onePlayer;

public class MoveDownThread implements Runnable{
	DMPlayer player;
	
	public MoveDownThread(DMPlayer p){
		player=p;
	}
	
	public void start(){
		Thread t = new Thread (this, "mdThread"+player.number);
        t.start ();
	}
	
	/**
	 * Thread safe- locks and unlocks pending moves when adding 'd' to index 0
	 */
	public void run() {
		while(player.gameplay!='i'){
			System.out.println("Waiting to start signaling blocks down...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("INTERRUPT EXCEPTION @MDThread line 22");
				e.printStackTrace();
			}
		}
		
		
		while(player.gameplay=='i'){
			try {
				//hi
				Thread.sleep(1000);
				if(player.speed==1){ //med
					Thread.sleep(1000);
				}
				if(player.speed==0){//lo
					Thread.sleep(2000);
				}
				player.lock.acquire();
				if(player.pendingMoves.get(0)!='d'){ //not already moving down or waiting to move down
					player.pendingMoves.add(0,'d');
				}
				player.lock.release();
				
			} catch (InterruptedException e) {
				System.out.println("INTERRUPT EXCEPTION @MDThread line 46");
				e.printStackTrace();
			}
		}
	}
}
