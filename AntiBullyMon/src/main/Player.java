package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
	int x, dx, nx2, y, dy, ny2, ny, bully, bullylim;
	public int points, bullies, answer;
	public boolean north, south, east, west, answergiven, dialogopen, end = false;
	public boolean start = true;
	public boolean movementallowed = true;
	
	Image still;
	String cardinal; 
	String cardinall = "abw/" + cardinal;;
	Bully b;

	public Player() {
		points = 0;
		x = 275;
		nx2 = 700;
		ny2 = 500;
		ny = 0;
		y = 175;
	}

	public void move() {
		
		//Game Borders//
				// This is used to define whether the character can move past certain points.
				//		If the player is moving in any direction (dx or dy) and hits a coordinate
			    //			limit, the movement will be reset to 0 (stopped). This helps to restrict
				//			the four corners of this game environment and prevents 'glitching' out
				//			of the playing area.
				//		Variables: dx, dy, x, y.
							
				if(dx == -1 && x <= 193){ dx = 0;}
				if(dx == 1 && x >= 350){ dx = 0; }
				if(dy == -1 && y < 159){ dy = 0; }
				if(dy == 1 && y > 1934){ dy = 0; }
	     //End of//Game Borders//
				
				
		//Movement Updating//
		//		This is used to update the player's position based on the setting of dx and dy.
		//			Nothing much else to see here.
		//	Variables Used: x, dx, y, dy, nx2, ny2, ny.
		x = x + dx;
		y = y + dy;
		nx2 = nx2 + dx;
		ny2 = ny2 + dy;
		ny = ny + dy;
		//End of//Movement Updating//
		
		
		//End Game//
		//		This is used to decide whether the player has started (bool start) or finished
	    //			(bool end), based on the player's coordinates. These booleans are then used
		//			in other functions to decide how the game should act.
		//	Variables used: y, start, end.
		if(y > 250){
			start = false;
		}
		if(y > 1920 ){
			end = true;
		}
		//End of//End Game//
		
		
		//Bully Activation//
		//		This segment is used to activate the bully dialog and allow the player to earn
	    //			points. This is mostly used to activate other functions and also has a
		//          counter built in to avoid players glitching points.
		if(y == 651 && !(bullylim == 1)){
			dialogopen = true;
			answergiven = false;
			bully = 1;
			bullylim++;
		}
		
		
		if(y == 1256 && !(bullylim == 2)){
			dialogopen = true;
			answergiven = false;
			bully = 2;
			bullylim++;
		}
		
		if(y == 1600 && !(bullylim == 3)){
			dialogopen = true;
			answergiven = false;
			bully = 3;
			bullylim++;
		}
		//End of//Bully Activation//
		

		//Sprite Management//
		//		This section handles how the player sprite is displayed. This
		// 			is done using the movement variables (dy, dx) to define 
		//			which way the player is currently facing/moving. The only
		//			current flaw with this is that a player can move diagonally
		//			whilst displaying a vertical/horizontal sprite.
		//	Variables Used: dy, dx, cardinal, movementallowed.
		
		ImageIcon i = new ImageIcon((this.getClass().getResource(cardinall))); // This sets the sprite of the player according to Sprite Management
		
		if(dy == -1){
			if(dy == 0 && movementallowed){
				cardinal = "north.png";
			}else
				if(!(dy == 0)){
					cardinal = "north.png";
				}
			
		}
		if(dy == 1){
			if(dy == 0 && movementallowed){
				cardinal = "south.png";
			}else
				if(!(dy == 0)){
					cardinal = "south.png";
				}

		}
		if(dx == 1){
			if(dx == 0 && movementallowed){
				cardinal = "east.png";
			}else
				if(!(dx == 0)){
					cardinal = "east.png";
				}
			
		}
		if(dx == -1){			
			if(dx == 0 && movementallowed){
				cardinal = "west.png";
			}else
				if(!(dx == 0)){
					cardinal = "west.png";
				}

		}
		still = i.getImage();
		//End of//Sprite Management//

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return still;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

				
				
		//Bully Response//
		//		This section handles how the player responds to the bully, using either the
		//			1, 2, 3, or 4 keys on the keyboard. These keys only work whilst the dialog
		//			is open to prevent 'glitching of points'.
		//	Variables used: answer, dialogopen, points.
		
		if(key == KeyEvent.VK_1 && dialogopen){
			answer = 1;
			dialogopen = false;
			points += 1;
		}
		if(key == KeyEvent.VK_2 && dialogopen){
			answer = 2;
			answergiven = true;
			dialogopen = false;
			
		}
		if(key == KeyEvent.VK_3 && dialogopen){
			answer = 3;
			answergiven = true;
			dialogopen = false;
			points += 1;
		}
		if(key == KeyEvent.VK_4 && dialogopen){
			answer = 4;
			answergiven = true;
			dialogopen = false;
		}
		//End of//Bully Response//
		
		
		//Player Movement//
		//		This section controls player movement using the WASD keys and regular arrows.
		//			If the player attempts to move diagonally or is not allowed to move the
		//			movement (dy or dx) is locked at 0.
		//	Variables used: dy, dx, movementallowed.
		if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && movementallowed && !dialogopen){
		    
			dx = -1;
		    dy = 0;
		}
		if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && movementallowed && !dialogopen){
			dx = 1;
			dy = 0;
	    }
		if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && movementallowed && !dialogopen){
			dy = 1;
			dx = 0;
		}
		if ((key == KeyEvent.VK_UP  || key == KeyEvent.VK_W) && movementallowed && !dialogopen){
			dy = -1;
			dx = 0;
		}
		//End of//Player Movement//
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		//Player Stopping//
				//		This section controls player stopping using the WASD keys and regular arrows.
				//			If the player attempts to release the keys, the player will stop moving
				//			(dx and dy reset to 0).
				//	Variables used: dy, dx, movementallowed.
		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
			dy = 0;
		}
		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
			dy = 0;
		}
		//End of//Player Stopping//
	}

}
