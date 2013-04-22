public class Playable extends Characters {

  public static int attack(int strength)
	{
		boolean miss;
		int chance = (int)(100*Math.random());
		if (chance > 90)
			miss = true;
		else
			miss = false;
		return (miss) ? 0:(int)(.5*Math.random()*strength+strength);
		
	};
}
