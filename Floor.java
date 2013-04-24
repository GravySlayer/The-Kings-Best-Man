package csc122.projects.kings;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Floor {
  pathTile[][] roomPathData;
  renderTile[][] roomRenderData;
  ArrayList<Enemy> enemyList;
  private int dimX, dimY, level;

	// Takes a floor number(string) as an argument and loads it into a pathTile[][] and a renderTile[][] from #-path.png & #-render.png
	// Files are to be placed in the classpath csc122.projects.kings.data.floors.# in this case
	// All coordinates begin in the top left corner at (0,0)
	protected Floor(String filename) {
		Scanner levelReader = new Scanner(filename);
		levelReader.useDelimiter("-");
		level = levelReader.nextInt();
		levelReader.close();
		try {
			BufferedImage room = (ImageIO.read(getClass().getResource("data/floors/" + filename + '/' + filename +"-path.png")));
			dimX = room.getWidth();
			dimY = room.getHeight();
			roomPathData = convertImageToPath(room);
			room = (ImageIO.read(getClass().getResource("data/floors/" + filename + '/' + filename + "-render.png")));
			roomRenderData = convertImageToRender(room);
			enemyList = monsterSpawn(roomPathData, dimX, dimY, level);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Prints the roomPathData to the console in shorthand
	public void printPathData(){
		for (int row = 0; row < dimY; row++) {
			System.out.println();
	         for (int col = 0; col < dimX; col++) {
	        	 System.out.print(" " + roomPathData[row][col].shorthand);
	         }
		}
	}
	
	// Prints the roomRenderData room to the console in shorthand
	public void printRenderData(){
		for (int row = 0; row < dimY; row++) {
			System.out.println();
	         for (int col = 0; col < dimX; col++) {
	        	 System.out.print(" " + roomRenderData[row][col].shorthand);
	         }
		}
	}
	
	// Prints the enemyList on the floor to the console
	public void printEnemyList(){
		System.out.println('\n');
		for (Enemy enemy : enemyList) {
			System.out.println(enemy.name + "  (" + enemy.x + ',' + enemy.y + ')');
		}
	}
	
	// Returns the level of the floor
	public int getLevel (){
		return level;		
	}
	
	// Returns the pathTile at target
	public pathTile getPathTile(int x, int y){
		return roomPathData[x][y];
	}
	
	// Returns the vertical dimension of the floor
	public int getdimX(){
		return dimX;
	}
	
	// Returns the horizontal dimension of the floor
	public int getdimY(){
		return dimY;
	}

	// Converts an image into a pathTile[][]
	private static pathTile[][] convertImageToPath(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		pathTile[][] result = new pathTile[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = pathTile.toPathTile(image.getRGB(col, row));
			}
		}
		
		return result;
	}
	
	// Converts an image into a renderTile[][]
	private static renderTile[][] convertImageToRender(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		renderTile[][] result = new renderTile[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				result[row][col] = renderTile.toRenderTile(image.getRGB(col, row));
			}
		}
		
		return result;
	}
	
	// Returns an ArrayList of Enemys generated from pathTile data. Use to populate floors
	private static ArrayList<Enemy> monsterSpawn(pathTile[][] pathData, int width, int height, int level) {
		ArrayList<Enemy> result;
		result = new ArrayList<Enemy>();
		int nameCounter = 0;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				switch (pathData[row][col]) {
				case SPAWN:
					result.add(new Enemy(level, row, col, "actor_" + nameCounter));
					nameCounter++;
					break;
				case SPAWN_RANDOM:
					break;
				default:
					break;
				}
			}
		}
		return result;
	}
}
