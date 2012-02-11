package main;

import java.awt.*;

import javax.swing.ImageIcon;

public class Bully {
	Image img;
	int x, y, nx, ny;
	boolean isAlive = true;
	Player p;

	public Bully(int startX, int startY, String location)
	{
		x = startX;
		y = startY;
		ImageIcon l = new ImageIcon(location);
		img = l.getImage();
		nx = 22;
		ny = 32;
		
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean Alive()
	{
		return isAlive;
	}
	public Image getImage()
	{
		return img;
	}
	
	public void move(int dx, int dy)
	{
		//Bully Movement//
		//		Exactly the same process as with the player's movement, except
		//			it is based off of how the player is moving (dx, dy) and not
		//			the bully.
		//	Variables Used: x, y, dx, dy.
		x = x - dx;
		y = y - dy;
		//End of//Bully Movement//
		
		
	}
}