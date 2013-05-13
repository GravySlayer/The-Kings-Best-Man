package csc122.projects.kings;

import java.awt.*;
import javax.swing.JFrame;

public class Screen
{
  //allows access to graphics card
	private GraphicsDevice videocard;

	public Screen()
	{
		//graphics environment - collection of all graphics device objects
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		videocard = env.getDefaultScreenDevice();
	}

	public void setFullScreen(DisplayMode dm, JFrame window)
	{
		//gets rid of everything aside from image
		window.setUndecorated(true);	
		//doesn't let you resize
		window.setResizable(false);
		//sets to full screen
		videocard.setFullScreenWindow(window);

		if(dm != null && videocard.isDisplayChangeSupported())
		{
			try 
			{
				videocard.setDisplayMode(dm);
			}
			catch(Exception e){}
		}
	}

	public Window getFullScreenWindow()
	{
		return videocard.getFullScreenWindow();
	}

	//method so you're not stuck in King's Best Man forever
	public void restoreScreen()
	{
		Window w = videocard.getFullScreenWindow();
		if (w != null)
		{
			w.dispose();
		}
		videocard.setFullScreenWindow(null);
	}

}
