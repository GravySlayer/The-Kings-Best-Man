package csc122.projects.kings;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class room {
  pathTile[][] roomMetaData;
	int dimX, dimY;

	// Construter takes a filename without an extension as an argument and loads it into a pathTile[][]
	protected room(String filename) {
		try {
			BufferedImage room = (ImageIO.read(getClass().getResource("data/rooms/" + filename + ".png")));
			roomMetaData = convertImage(room);
			dimX = room.getWidth();
			dimY = room.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Prints the pathTile room to the console
	public void printMetaData(){
		for (int row = 0; row < dimY; row++) {
			System.out.println("");
	         for (int col = 0; col < dimX; col++) {
	        	 System.out.print(" " + roomMetaData[row][col].shorthand);
	         }
		}
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
