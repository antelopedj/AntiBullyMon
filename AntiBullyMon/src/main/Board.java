package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {
	Player p;
	Bully b, b1, b2;
	String BullyName, ChatText, ChatText2;
	boolean bullytalk;
	
	public Image bg;
	Timer time;

	//Font Definition//
	//		Used to define the fonts used during the game.
    static Font font = new Font("SanSerif", Font.BOLD, 24);
    static Font font1 = new Font("SanSerif", Font.BOLD, 20);
    static Font font2 = new Font("SanSerif", Font.BOLD, 16);
    static Font name = new Font("SanSerif", Font.BOLD, 13);
    static Font conv = new Font("SanSerif", Font.BOLD, 11);
    //End of//Font Definition//
	
    public Board() {
		p = new Player();
		b = new Bully(240, 730, "/abw/eastb.png"); b1 = new Bully(240, 1300,  "/abw/eastb.png"); b2 = new Bully(240, 1610,  "/abw/eastb.png");
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("/abw/bgfull.png");
		bg = i.getImage();
		time = new Timer(5, this);
		time.start();
		
	}

	public void actionPerformed(ActionEvent e) {
		p.move();
		b.move(p.dx, p.dy);
		b1.move(p.dx, p.dy);
		b2.move(p.dx, p.dy);
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		
		//Scene spawning//
		//		This section draws the screen using the x and y 
		//			coordinates provided by each instance.
		//	Variables used: .
		    g2d.drawImage(bg, 615-p.nx2, 400-p.ny2, null);
		    g2d.drawImage(p.getImage(), 300, 200, null);
			g2d.drawImage(b.getImage(), b.getX(), b.getY(), null);
			g2d.drawImage(b1.getImage(), b1.getX(), b1.getY(), null);
			g2d.drawImage(b2.getImage(), b2.getX(), b2.getY(), null);
			
		//End of//Scene Spawning//
			
			
		//Dialog Activation//
		//		This section defines whether the bullytalk dialog should be open
		//			and when it should be closed. Also defines onscreen content.
		//	Variables used: .
		if(!p.dialogopen){
			bullytalk = false;
			p.movementallowed = true;
		}
		if(p.dialogopen == true){
			
			switch(p.bully){
			case 0:
				p.cardinal = "west.png";
					dialogMenu("Bob", "You're an idiot,", "nobody likes you!");
					g2d.setFont(name);
					g2d.setColor(Color.RED);
					g2d.drawString(BullyName, 300, 400);
					g2d.setFont(conv);
					g2d.setColor(Color.WHITE);
					g2d.drawString(ChatText, 300, 420);
					g2d.drawString(ChatText2, 300, 440);
						if(!p.answergiven){
							g2d.setFont(name);
							g2d.setColor(Color.RED);
							g2d.drawString("Answer:", 400, 180);
							g2d.setFont(conv);
							g2d.setColor(Color.WHITE);
							g2d.drawString("1 - Ignore him.", 400, 200);
							g2d.drawString("2 - Snarky Remark.", 400, 220);
							g2d.drawString("3 - Report him.", 400, 240);
							g2d.drawString("4 - Insult him back.", 400, 260);
						}


				break;
			case 1:
				p.cardinal = "west.png";
				dialogMenu("Fred", "Go kill yourself,", "you bloody emo!");
				g2d.setFont(name);
				g2d.setColor(Color.RED);
				g2d.drawString(BullyName, 300, 300);
				g2d.setFont(conv);
				g2d.setColor(Color.WHITE);
				g2d.drawString(ChatText, 300, 320);
				g2d.drawString(ChatText2, 300, 340);
				if(!p.answergiven){
					g2d.setFont(name);
					g2d.setColor(Color.RED);
					g2d.drawString("Answer:", 400, 180);
					g2d.setFont(conv);
					g2d.setColor(Color.WHITE);
					g2d.drawString("1 - Ignore him.", 400, 200);
					g2d.drawString("2 - Snarky Remark.", 400, 220);
					g2d.drawString("3 - Report him.", 400, 240);
					g2d.drawString("4 - Insult him back.", 400, 260);
				}

				break;
			case 2:
				p.cardinal = "west.png";
				dialogMenu("Alan", "Give me your phone,", "you don't have friends to text anyway!");
				g2d.setFont(name);
				g2d.setColor(Color.RED);
				g2d.drawString(BullyName, 300, 300);
				g2d.setFont(conv);
				g2d.setColor(Color.WHITE);
				g2d.drawString(ChatText, 300, 320);
				g2d.drawString(ChatText2, 300, 340);
				if(!p.answergiven){
					g2d.setFont(name);
					g2d.setColor(Color.RED);
					g2d.drawString("Answer:", 400, 180);
					g2d.setFont(conv);
					g2d.setColor(Color.WHITE);
					g2d.drawString("1 - Ignore him.", 400, 200);
					g2d.drawString("2 - Snarky Remark.", 400, 220);
					g2d.drawString("3 - Report him.", 400, 240);
					g2d.drawString("4 - Insult him back.", 400, 260);
				}
				break;
			case 3:
				p.cardinal = "west.png";
				dialogMenu("Luke", "Your mother is so fat", "she has her own postcode!");
				g2d.setFont(name);
				g2d.setColor(Color.RED);
				g2d.drawString(BullyName, 300, 300);
				g2d.setFont(conv);
				g2d.setColor(Color.WHITE);
				g2d.drawString(ChatText, 300, 320);
				g2d.drawString(ChatText2, 300, 340);				
				if(!p.answergiven){
					g2d.setFont(name);
					g2d.setColor(Color.RED);
					g2d.drawString("Answer:", 400, 180);
					g2d.setFont(conv);
					g2d.setColor(Color.WHITE);
					g2d.drawString("1 - Ignore him.", 400, 200);
					g2d.drawString("2 - Snarky Remark.", 400, 220);
					g2d.drawString("3 - Report him.", 400, 240);
					g2d.drawString("4 - Insult him back.", 400, 260);
				}

				break;
			default:
				p.cardinal = "west.png";
				dialogMenu("Luke", "Your mother is so fat", "she has her own postcode!");
				g2d.setFont(name);
				g2d.setColor(Color.RED);
				g2d.drawString(BullyName, 300, 300);
				g2d.setFont(conv);
				g2d.setColor(Color.WHITE);
				g2d.drawString(ChatText, 300, 320);
				g2d.drawString(ChatText2, 300, 340);				
				if(!p.answergiven){
					g2d.setFont(name);
					g2d.setColor(Color.RED);
					g2d.drawString("Answer:", 400, 180);
					g2d.setFont(conv);
					g2d.setColor(Color.WHITE);
					g2d.drawString("1 - Ignore him.", 400, 200);
					g2d.drawString("2 - Snarky Remark.", 400, 220);
					g2d.drawString("3 - Report him.", 400, 240);
					g2d.drawString("4 - Insult him back.", 400, 260);
				}
				break;
			}
		}
		//End of//Dialog Activation//
		
		
		//Screen Text//
		//		Used to display the start and end dialog + points count.
		//	Variables used: .
		if(p.start == true){
			//menu			
			 g2d.setFont(font);
	        g2d.setColor(Color.WHITE);
	        g2d.drawString("The Walk Home...", 300, 300);
	        g2d.setFont(font2);
	        g2d.drawString("You've finished a day at school,", 300, 320);
	        g2d.drawString("try to get home without being beaten", 300, 340);
	        g2d.drawString("by the bullies.", 300, 360);
	        //controls
	        g2d.setFont(font1);
	        g2d.drawString("Controls", 10, 50);
	        g2d.setFont(font2);
	        g2d.drawString("W Key - Up.", 10, 70);
	        g2d.drawString("S Key - Down.", 10, 90);
	        g2d.drawString("A Key - Left.", 10, 110);
	        g2d.drawString("D Key - Right.", 10, 130);
	        g2d.drawString("1-4 - Option Keys.", 130, 70);

		}
		if(p.end == true){
			 g2d.setFont(font);
             g2d.setColor(Color.WHITE);
             g2d.drawString("Level Complete!", 300, 200);
             g2d.setFont(font1);
             g2d.drawString("You scored " + p.points + " points.", 300, 220);
             g2d.drawString("", 300, 240);
             g2d.drawString("Thanks for playing!", 300, 260);
             p.dx = 0;
             p.dy = 0;
		}
		g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString("Points: " + p.points, 450, 20);
        //End of//Screen Text//
		

	}

	public void dialogMenu(String name, String conv1, String conv2){
		BullyName = name;
		ChatText = conv1;
		ChatText2 = conv2;
		
	}
	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}
	}
}
