package csc122.projects.kings;

public class Enemy extends Characters {

	Enemy(int floor, int x, int y)
	{
		maxVitality = CalcHealth(floor);
		currentVitality = maxVitality;
		strength = CalcStrength(floor);
		this.x = x;
		this.y = y;
	}
  
	private static int CalcHealth(int floor)
 	{

		if (floor == 1)
			return (int)75;
		if (floor == 2)
			return (int)(Math.random()*50 + 100);
		if (floor == 3)
			return (int)(Math.random()*100 + 125);
		if (floor == 4)
			return (int)(Math.random()*150 + 150);
		else
			return (int)(Math.random()*200 + 200);

	}
  
 	private static int CalcStrength(int floor)
 	{
  		return (int)(Math.random()*20+25*floor);
 	}
}
