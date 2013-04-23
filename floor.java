package csc122.projects.kings;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class floor {
  pathTile[][] roomPathData;
  renderTile[][] roomRenderData;
	private int dimX, dimY;
	int level;

	// Construter takes a floor file name without an extension as an argument and loads it into a pathTile[][] and a renderTile[][]
	// Files are place in the classpath csc122.projects.kings.data.rooms in this case
	protected floor(String filename) {
		Scanner levelReader = new Scanner(filename);
		levelReader.useDelimiter("-");
		level = levelReader.nextInt();
		levelReader.close();
		try {
			BufferedImage room = (ImageIO.read(getClass().getResource("data/floors/" + filename + "-path.png")));
			dimX = room.getWidth();
			dimY = room.getHeight();
			roomPathData = convertImageToPath(room);
			room = (ImageIO.read(getClass().getResource("data/floors/" + filename + "-render.png")));
			roomRenderData = convertImageToRender(room);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Prints the pathTile room to the console
	public void printPathData(){
		for (int row = 0; row < dimY; row++) {
			System.out.println();
	         for (int col = 0; col < dimX; col++) {
	        	 System.out.print(" " + roomPathData[row][col].shorthand);
	         }
		}
	}
	
	public void printRenderData(){
		for (int row = 0; row < dimY; row++) {
			System.out.println();
	         for (int col = 0; col < dimX; col++) {
	        	 System.out.print(" " + roomRenderData[row][col].shorthand);
	         }
		}
	}
	
	public int getLevel (){
		return level;		
	}
	
	public pathTile getPathTile(int x, int y){
		return roomPathData[x][y];
	}
	public int getdimX(){
		return dimX;
	}
	public int getdimY(){
		return dimY;
	}

	// Converts the image into a pathTile[][]
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
}
