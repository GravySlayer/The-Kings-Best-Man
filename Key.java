package csc122.projects.kings;

//Note: This class is relative to user interaction with the keyboard.
//As of now, if a certain key is pressed, it'll return a string (mess), but we can change that later.
//This is more of a base to get us started - still a work in progress

import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key extends Core implements KeyListener
{
public static void main(String[] args)
	{
		new Key().run();
	}
	private String mess = "";

	//init also call init from superclass
	public void init()
	{
		super.init();
		Window w = s.getFullScreenWindow();
		w.setFocusTraversalKeysEnabled(false);
		w.addKeyListener(this);
		mess = "Press escape to exit.";
	}

	//if key pressed method
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		//Note: every key on keyboard has keycode - VK_derp derp=keycode
		if(keyCode == KeyEvent.VK_ESCAPE)
		{
			stop();
		}
		else
		{
			mess = "Pressed : " + KeyEvent.getKeyText(keyCode);
			e.consume();
			//consume means no combinations (i.e. alt+tab won't work)
		}

	}

	//key released
	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		mess = "Released : " + KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	//last method from interface - handles button
	public void keyTyped(KeyEvent e)
	{
		e.consume();
	}

	//draw
	public synchronized void draw(Graphics2D g)
	{
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 30, 30);
	}

}

