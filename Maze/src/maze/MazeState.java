package maze;

public class MazeState {
	public enum space{
		WALL,
		SOLVED,
		UNSOLVED
	}

	private int[] coords = new int[2];
	private space[][] maze;
	private int moves;
	
	public MazeState(space[][] maze, int[] coords, int movecount) {
		this.maze = maze;
		this.coords = coords;
		this.moves = movecount;
	}
	
	public MazeState(MazeState mazeState)  { //copy constructor
		
		space[][] maze = mazeState.getMaze();
		int[] coords = mazeState.getCoords();
		int movecount = mazeState.getMoves();
		
		int x = maze.length;
		int y = maze[0].length;
		MazeState.space[][] copyMaze = new MazeState.space[x][y];
		for(int j=0; j<y; j++) {
			for(int i=0; i<x; i++) {
				copyMaze[i][j] = maze[i][j];
			}
		}
		int[] copyCoords = new int[2];
		for(int i=0; i<coords.length; i++) {
			copyCoords[i] = coords[i];
		}
		int copyMovecount = movecount;
		
		this.maze = copyMaze;
		this.coords = copyCoords;
		this.moves = copyMovecount;
	}
	
	public space[][] getMaze() {
		return this.maze;
	}
	
	public void setMaze(space[][] maze) {
		this.maze = maze;
	}
	
	public int[] getCoords() {
		return this.coords;
	}
	
	public void setCoords(int[] coords) {
		this.coords = coords;
	}
	
	public void setXCoord(int x) {
		this.coords[0] = x;
	}
	public void setYCoord(int y) {
		this.coords[1] = y;
	}
	
	public int getMoves() {
		return this.moves;
	}
	
	public void setMoves(int moves){
		this.moves = moves;
	}
	
	public void incrementMoves(){
		this.moves = this.moves+1;
	}
	
	
}
