package csc122.projects.kings;

public enum renderTile {
  STONE(-1, 'S', ""); // (255,255,255)

	
	protected final int value;
	protected final char shorthand;
	protected final String filePath;

	 renderTile(int value, char shorthand, String filePath){
		this.value = value;
		this.shorthand = shorthand;
		this.filePath = filePath;		
	}
	 // Converts the color int values into enumerated tiles
	static renderTile toRenderTile(int in){
		renderTile result;
		switch(in){
		default:
			System.out.println("Unknown value: " + in);
			result = STONE;
			break;
		}
		return result;
	}
}
