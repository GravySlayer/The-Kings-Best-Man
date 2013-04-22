public class Playable extends Characters {

public int attackDamage(int strength)
{
	int chance = (int)(100*Math.random());
	boolean miss = (chance > 90) ? true:false;
	return (miss) ? 0:(int)(0.5 * Math.random() * strength + strength);	
};
