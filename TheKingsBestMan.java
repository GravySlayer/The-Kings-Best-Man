package csc122.projects.kings;

import java.util.ArrayList;

public class TheKingsBestMan { 
	static ArrayList<Enemy> enemyList;
	
	public static void main(String[] args) {
		/*floor one = new floor("1");
		monsterSpawn(one);
		one.printPathData();
		System.out.println('\n');
		for (Enemy enemy : enemyList) {
			System.out.println(enemy.name + "  (" + enemy.x + ',' + enemy.y + ')');
		}*/		
	}

	public static void monsterSpawn(floor level) {
		enemyList = new ArrayList<Enemy>();
		int nameCounter = 0;
		for (int row = 0; row < level.getdimY(); row++) {
			for (int col = 0; col < level.getdimX(); col++) {
				switch (level.getPathTile(row, col)) {
				case SPAWN:
					enemyList.add(new Enemy(level.getLevel(), row, col, "actor_" + nameCounter));
					nameCounter++;
					break;
				case SPAWN_RANDOM:
					break;
				default:
					break;
				}
			}
		}
	}
}
