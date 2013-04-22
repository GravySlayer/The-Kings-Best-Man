package csc122.projects.kings;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class room {
  pathTile[][] roomPathData;
	int dimX, dimY;

	// Construter takes a filename without an extension as an argument and loads it into a pathTile[][]
	// Files are place in the classpath csc122.projects.kings.data.rooms in this case
	protected room(String filename) {
		try {
			BufferedImage room = (ImageIO.read(getClass().getResource("data/rooms/" + filename + ".png")));
			roomPathData = convertImage(room);
			dimX = room.getWidth();
			dimY = room.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Prints the pathTile room to the console
	public void printPathData(){
		for (int row = 0; row < dimY; row++) {
			System.out.println("");
	         for (int col = 0; col < dimX; col++) {
	        	 System.out.print(" " + roomPathData[row][col].shorthand);
	         }
		}
	}
	
	public pathTile getPathTile(int x, int y){
		return roomPathData[x][y];
	}

	// Converts the image into a pathTile[][]
	private static pathTile[][] convertImage(BufferedImage image) {
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
}
