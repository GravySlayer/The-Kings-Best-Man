package csc122.projects.kings;

public enum RenderTile {
	STONE(-1, 'S', ""), // (255,255,255)
	UNKNOWN(0, '?', ""); //(-1, -1, -1)

	
	protected final int value;
	protected final char shorthand;
	protected final String filePath;

	 RenderTile(int value, char shorthand, String filePath){
		this.value = value;
		this.shorthand = shorthand;
		this.filePath = filePath;		
	}
	 // Converts the color int values into enumerated tiles
	static RenderTile toRenderTile(int in){
		RenderTile result;
		switch(in){
		case -1:
			result = STONE;
			break;
		default:
			System.out.println("Unknown value: " + in);
			result = UNKNOWN;
			break;
		}
		return result;
	}
}
