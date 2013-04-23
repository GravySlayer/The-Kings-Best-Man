package csc122.projects.kings;

public class Characters {

	protected String name;
	protected int x;
	protected int y;
	protected int maxVitality;
	protected int currentVitality;
	protected int strength;

	public int attackDamage(int strength) {
		int chance = (int) (100 * Math.random());
		boolean miss = (chance > 90) ? true : false;
		return (miss) ? 0 : (int) (0.5 * Math.random() * strength + strength);
	}

	public boolean isAlive() {
		return (currentVitality <= 0) ? false:true;
	}
	
	public void takeDamage(int damage){
		currentVitality -= damage;
	}
}
