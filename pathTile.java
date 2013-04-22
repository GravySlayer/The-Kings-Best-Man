package csc122.projects.kings;

public enum pathTile {
  FLOOR(-1, '`' ), // (0,0,0)
	WALL(-16777216, 'W'), // (255,255,255)
	STAIR_DOWN(-16711936, '_'), // (0,255,0)
	STAIR_UP(-65536, '^'), // (255,0,0)
	//TRAPDOOR(-16776961, 'T'), // (0,0,255)
	DOOR(-65281, '|'), // (255,0,255)
	EMPTY(-256, ' '), // (255,255,0)
	UNKNOWN(0, '?'); // (-1,-1,-1)
	
	
	protected final int value;
	protected final char shorthand;

	 pathTile(int value, char shorthand){
		this.value = value;
		this.shorthand = shorthand;		
	}
	 // Converts the color int values into enumerated tiles
	static pathTile toPathTile(int in){
		pathTile result;
		switch(in){
		case -1:
			result = FLOOR;
			break;
		case -256:
			result = EMPTY;
			break;
		case -65536:
			result = STAIR_UP;
			break;
		case -16711936:
			result = STAIR_DOWN;
			break;
		case -65281:
			result = DOOR;
			break;
		case -16777216:
			result = WALL;
			break;
		//case -16776961:
		//	result = TRAPDOOR;
		//	break;
		default:
			result = UNKNOWN;
			break;
		}
		return result;
	}
}
