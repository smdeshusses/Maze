package maze;

public class GenerateMaze {

	private MazeState.space[][] maze;
	private int[] coords;
	private int movecount;

	public MazeState makeMaze(int mazeNum) {

		if(mazeNum==0) {
			simpleMaze();
		}
		else if(mazeNum==1) {
			easyMaze();
		}
		else if(mazeNum==4) {
			lvl4Maze();
		}
		else if(mazeNum==14) {
			lvl14Maze();
		}
		else if(mazeNum==17) {
			lvl17Maze();
		}
		else if(mazeNum==20) {
			lvl20Maze();
		}

		MazeState mazeState = new MazeState(maze, coords, movecount);
		return mazeState;	
	}

	public void simpleMaze(){
		MazeState.space[][] maze = new MazeState.space[5][6];
		for(int j=0; j<6; j++) {
			for(int i=0; i<5;i++) {
				maze[i][j] = MazeState.space.UNSOLVED;
			}
		}

		for(int i=0;i<5;i++) {
			maze[i][0] = MazeState.space.WALL;
			maze[i][5] = MazeState.space.WALL;
		}
		for(int j=0;j<6;j++) {
			maze[0][j] = MazeState.space.WALL;
			maze[4][j] = MazeState.space.WALL;
		}
		maze[1][2] = MazeState.space.WALL;
		maze[3][4] = MazeState.space.WALL;

		maze[1][1] = MazeState.space.SOLVED;
		int coords[] = {1,1};
		int movecount = 0;

		this.maze = maze;
		this.coords = coords;
		this.movecount = movecount;
	}

	public void easyMaze(){
		MazeState.space[][] maze = new MazeState.space[5][5];
		for(int j=0; j<5; j++) {
			for(int i=0; i<5;i++) {
				maze[i][j] = MazeState.space.UNSOLVED;
			}
		}

		for(int i=0;i<5;i++) {
			maze[i][0] = MazeState.space.WALL;
			maze[i][4] = MazeState.space.WALL;
		}
		for(int j=0;j<5;j++) {
			maze[0][j] = MazeState.space.WALL;
			maze[4][j] = MazeState.space.WALL;
		}
		maze[2][2] = MazeState.space.WALL;

		maze[1][1] = MazeState.space.SOLVED;
		int coords[] = {1,1};
		int movecount = 0;

		this.maze = maze;
		this.coords = coords;
		this.movecount = movecount;
	}

	public void lvl4Maze(){
		MazeState.space[][] maze = new MazeState.space[13][12];
		for(int j=0; j<12; j++) {
			for(int i=0; i<13;i++) {
				maze[i][j] = MazeState.space.UNSOLVED;
			}
		}

		for(int i=0;i<13;i++) {
			maze[i][0] = MazeState.space.WALL;
			maze[i][11] = MazeState.space.WALL;
		}
		for(int j=0;j<12;j++) {
			maze[0][j] = MazeState.space.WALL;
			maze[12][j] = MazeState.space.WALL;
		}

		for(int j=3; j<=8; j++) {
			for(int i=3; i<=9;i++) {
				maze[i][j] = MazeState.space.WALL;
			}
		}

		maze[1][10] = MazeState.space.WALL;
		maze[1][9] = MazeState.space.WALL;
		maze[2][10] = MazeState.space.WALL;
		maze[11][2] = MazeState.space.WALL;
		maze[11][1] = MazeState.space.WALL;
		maze[10][1] = MazeState.space.WALL;

		maze[1][1] =  MazeState.space.SOLVED;
		int coords[] = {1,1};
		int movecount = 0;

		this.maze = maze;
		this.coords = coords;
		this.movecount = movecount;
	}

	public void lvl14Maze(){
		MazeState.space[][] maze = new MazeState.space[13][13];
		for(int j=0; j<13; j++) {
			for(int i=0; i<13;i++) {
				maze[i][j] = MazeState.space.UNSOLVED;
			}
		}

		for(int i=0;i<13;i++) {
			maze[i][0] = MazeState.space.WALL;
			maze[i][12] = MazeState.space.WALL;
		}
		for(int j=0;j<12;j++) {
			maze[0][j] = MazeState.space.WALL;
			maze[12][j] = MazeState.space.WALL;
		}
		
		maze[1][8] = MazeState.space.WALL;
		maze[2][2] = MazeState.space.WALL;
		maze[2][4] = MazeState.space.WALL;
		maze[2][5] = MazeState.space.WALL;
		maze[2][6] = MazeState.space.WALL;
		maze[2][8] = MazeState.space.WALL;
		maze[2][10] = MazeState.space.WALL;
		maze[3][2] = MazeState.space.WALL;
		maze[4][2] = MazeState.space.WALL;
		maze[4][4] = MazeState.space.WALL;
		maze[4][6] = MazeState.space.WALL;
		maze[4][8] = MazeState.space.WALL;
		maze[4][10] = MazeState.space.WALL;
		maze[4][11] = MazeState.space.WALL;
		maze[5][2] = MazeState.space.WALL;
		maze[5][4] = MazeState.space.WALL;
		maze[5][6] = MazeState.space.WALL;
		maze[5][8] = MazeState.space.WALL;
		maze[5][10] = MazeState.space.WALL;
		maze[5][11] = MazeState.space.WALL;
		maze[6][6] = MazeState.space.WALL;
		maze[7][1] = MazeState.space.WALL;
		maze[7][2] = MazeState.space.WALL;
		maze[7][4] = MazeState.space.WALL;
		maze[7][6] = MazeState.space.WALL;
		maze[7][8] = MazeState.space.WALL;
		maze[7][10] = MazeState.space.WALL;
		maze[9][2] = MazeState.space.WALL;
		maze[9][4] = MazeState.space.WALL;
		maze[9][6] = MazeState.space.WALL;
		maze[9][8] = MazeState.space.WALL;
		maze[9][10] = MazeState.space.WALL;
		maze[10][2] = MazeState.space.WALL;
		maze[10][3] = MazeState.space.WALL;
		maze[10][4] = MazeState.space.WALL;
		maze[10][6] = MazeState.space.WALL;
		maze[10][8] = MazeState.space.WALL;
		maze[10][10] = MazeState.space.WALL;
		maze[11][8] = MazeState.space.WALL;
		

		maze[1][1] =  MazeState.space.SOLVED;
		int coords[] = {1,1};
		int movecount = 0;

		this.maze = maze;
		this.coords = coords;
		this.movecount = movecount;
	}
	
	public void lvl17Maze(){
		MazeState.space[][] maze = new MazeState.space[12][12];
		for(int j=0; j<12; j++) {
			for(int i=0; i<12;i++) {
				maze[i][j] = MazeState.space.UNSOLVED;
			}
		}

		for(int i=0;i<12;i++) {
			maze[i][0] = MazeState.space.WALL;
			maze[i][11] = MazeState.space.WALL;
		}
		for(int j=0;j<12;j++) {
			maze[0][j] = MazeState.space.WALL;
			maze[1][j] = MazeState.space.WALL;
			maze[11][j] = MazeState.space.WALL;
		}
		maze[1][1] = MazeState.space.SOLVED;

		maze[2][2] = MazeState.space.WALL;
		maze[3][2] = MazeState.space.WALL;
		maze[4][2] = MazeState.space.WALL;
		maze[5][2] = MazeState.space.WALL;
		maze[6][2] = MazeState.space.WALL;
		maze[7][2] = MazeState.space.WALL;
		maze[9][2] = MazeState.space.WALL;
		maze[5][4] = MazeState.space.WALL;
		maze[6][4] = MazeState.space.WALL;
		maze[7][4] = MazeState.space.WALL;
		maze[9][4] = MazeState.space.WALL;
		maze[9][5] = MazeState.space.WALL;
		maze[2][6] = MazeState.space.WALL;
		maze[8][7] = MazeState.space.WALL;
		maze[2][10] = MazeState.space.WALL;
		maze[5][9] = MazeState.space.WALL;
		maze[6][9] = MazeState.space.WALL;
		maze[8][9] = MazeState.space.WALL;
		maze[10][9] = MazeState.space.WALL;
		maze[10][10] = MazeState.space.WALL;
		
		int coords[] = {1,1};
		int movecount = 0;

		this.maze = maze;
		this.coords = coords;
		this.movecount = movecount;
	}
	
	public void lvl20Maze(){
		MazeState.space[][] maze = new MazeState.space[13][13];
		for(int j=0; j<13; j++) {
			for(int i=0; i<13;i++) {
				maze[i][j] = MazeState.space.UNSOLVED;
			}
		}

		for(int i=0;i<=12;i++) {
			maze[i][0] = MazeState.space.WALL;
			maze[i][12] = MazeState.space.WALL;
		}
		for(int j=0;j<=12;j++) {
			maze[0][j] = MazeState.space.WALL;
			maze[12][j] = MazeState.space.WALL;
		}

		maze[1][1] = MazeState.space.WALL;
		maze[1][2] = MazeState.space.WALL;
		maze[1][3] = MazeState.space.WALL;
		maze[1][10] = MazeState.space.WALL;
		maze[1][11] = MazeState.space.WALL;
		maze[2][1] = MazeState.space.WALL;
		maze[2][11] = MazeState.space.WALL;
		maze[3][1] = MazeState.space.WALL;
		maze[3][3] = MazeState.space.WALL;
		maze[3][6] = MazeState.space.WALL;
		maze[3][8] = MazeState.space.WALL;
		maze[3][9] = MazeState.space.WALL;
		maze[4][1] = MazeState.space.WALL;
		maze[4][6] = MazeState.space.WALL;
		maze[4][8] = MazeState.space.WALL;
		maze[4][9] = MazeState.space.WALL;
		maze[5][4] = MazeState.space.WALL;
		maze[6][4] = MazeState.space.WALL;
		maze[6][6] = MazeState.space.WALL;
		maze[6][11] = MazeState.space.WALL;
		maze[7][6] = MazeState.space.WALL;
		maze[7][8] = MazeState.space.WALL;
		maze[7][10] = MazeState.space.WALL;
		maze[7][11] = MazeState.space.WALL;
		maze[8][4] = MazeState.space.WALL;
		maze[8][5] = MazeState.space.WALL;
		maze[8][6] = MazeState.space.WALL;
		maze[8][8] = MazeState.space.WALL;
		maze[8][10] = MazeState.space.WALL;
		maze[8][11] = MazeState.space.WALL;
		maze[9][1] = MazeState.space.WALL;
		maze[9][4] = MazeState.space.WALL;
		maze[9][5] = MazeState.space.WALL;
		maze[9][6] = MazeState.space.WALL;
		maze[9][8] = MazeState.space.WALL;
		maze[10][1] = MazeState.space.WALL;
		maze[11][1] = MazeState.space.WALL;
		maze[11][6] = MazeState.space.WALL;
		maze[11][7] = MazeState.space.WALL;
		maze[11][10] = MazeState.space.WALL;
		maze[11][11] = MazeState.space.WALL;
		

		maze[1][4] =  MazeState.space.SOLVED;
		int coords[] = {1,4};
		int movecount = 0;

		this.maze = maze;
		this.coords = coords;
		this.movecount = movecount;
	}
	
}
