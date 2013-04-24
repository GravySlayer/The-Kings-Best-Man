//Note: This class is relative to user interaction with the mouse.
//As of now, if the mouse is moved or drag clicked, it'll return a string (mess), but we can change that later.
//This is more of a base to get us started - still a work in progress

import java.awt.*;

public class Mouse extends Core implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener
{
  public static void main(String[] args)
	{
		new Mouse().run();
	}
	
	private String mes = "";
	
	//init calls super init
	public void init()
	{
		super.init();
		Window w = s.getFullScreenWindow();
		w.addMouseListener(this);
		w.addMouseMotionListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);
	}
	
	//draw method
	public synchronized void draw(Graphics2D g)
	{
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 40, 50);
	}
	
	//mouse listener interface
	public void mousePressed(MouseEvent e)
	{
		mess = "You pressed down the mouse";
	}
	
	public void mouseReleased(MouseEvent e)
	{
		mess = "You released the mouse";
	}
	
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	//mouse motion interface
	public void mouseDragged(MouseEvent e)
	{
		mess = "You are dragging the mouse";
	}
	
	public void mouseMoved(MouseEvent e)
	{
		mess = "you are moving the mouse";
	}
	
	//wheel interface
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		mess = "moving mouse wheel";
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
	
}
