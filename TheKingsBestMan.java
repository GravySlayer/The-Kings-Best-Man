package csc122.projects.kings;

import java.util.ArrayList;


public class TheKingsBestMan {
  

	public static void main(String[] args) {
		
		
	}

	public void MonsterSpawn(floor level)
	{
		for (int row = 0; row < level.getdimY(); row++) {
			for (int col = 0; col < level.getdimX(); col++) {
				switch(level.getPathTile(row, col)){
				case SPAWN:
					//stuffs
					break;
				case SPAWN_RANDOM:
					enemyList.add(new Enemy(level.getLevel(), row, col));
					break;
				default:
					break;
				}
			}
		}
	}
	

	ArrayList <Enemy> enemyList = new ArrayList<Enemy>();

}
