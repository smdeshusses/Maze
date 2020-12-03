package maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

enum space{
	WALL,
	SOLVED,
	UNSOLVED
}

public class Maze {
	
	static int count = 0;
	static int initialMinMoves;

	public static void main(String[] args) throws IOException {
		//singlePlayer(17);
		firstSolver(20);
	}

	public static void firstSolver(int mazeNum) {
		long start = System.currentTimeMillis();
		GenerateMaze m = new GenerateMaze();
		MazeState mazeState = m.makeMaze(mazeNum);
		initialMinMoves = Lookahead.look(mazeState);
		recursiveSolver(mazeState);
		long end = System.currentTimeMillis();
		System.out.println("It took: " + (end-start)/1000.0 + " seconds and " + count + " iterations");
	}

	public static void recursiveSolver(MazeState mazeState) {
		int knownFewestMoves = 31;
		boolean possibleFinish=true;
		if(knownFewestMoves-initialMinMoves<=mazeState.getMoves()) {
			if(Lookahead.look(mazeState)+mazeState.getMoves()>knownFewestMoves) {
				possibleFinish=false;
			}
		}
		count++;
		if(getUnsolvedCount(mazeState)==0) {
			System.out.println("SOLVED in " + mazeState.getMoves());
		}
		else if(mazeState.getMoves()<knownFewestMoves && possibleFinish) {
			ArrayList<MazeState> moves = getPossibleMoves(mazeState);
			for(int i=0; i<moves.size(); i++) {
				MazeState deepCopy = new MazeState(moves.get(i));
				recursiveSolver(deepCopy);
			}
		}
	}

	public static ArrayList<MazeState> getPossibleMoves(MazeState mazeState) {
		ArrayList<MazeState> possibleMoves = new ArrayList<MazeState>();

		int[] coords = mazeState.getCoords();
		int x = coords[0];
		int y = coords[1];	
		
		if(mazeState.getMaze()[x+1][y]!=MazeState.space.WALL) { //R
			MazeState mazeStateR = new MazeState(mazeState);
			MazeState.space[][] maze = mazeStateR.getMaze();
			int x1 = x;
			int y1 = y; 
			
			MazeState.space val = maze[x1+1][y1];
			while(val!=MazeState.space.WALL) {
				if(maze[x1+1][y1]==MazeState.space.UNSOLVED) {
					maze[x1+1][y1]=MazeState.space.SOLVED;
				}
				x1++;
				val = maze[x1+1][y1];
			}
			mazeStateR.setXCoord(x1);
			//implied setYCoord (should not have changed)
			mazeStateR.setMaze(maze);
			mazeStateR.incrementMoves();
			possibleMoves.add(mazeStateR);
		}	

		if(mazeState.getMaze()[x-1][y]!=MazeState.space.WALL) { //L
			MazeState mazeStateL = new MazeState(mazeState);
			MazeState.space[][] maze = mazeStateL.getMaze();
			int x1 = x;
			int y1 = y; 
			
			MazeState.space val = maze[x1-1][y1];
			while(val!=MazeState.space.WALL) {
				if(maze[x1-1][y1]==MazeState.space.UNSOLVED) {
					maze[x1-1][y1]=MazeState.space.SOLVED;
				}
				x1--;
				val = maze[x1-1][y1];
			}
			mazeStateL.setXCoord(x1);
			//implied setYCoord (should not have changed)
			mazeStateL.setMaze(maze);
			mazeStateL.incrementMoves();
			possibleMoves.add(mazeStateL);
		}

		if(mazeState.getMaze()[x][y+1]!=MazeState.space.WALL) { //U	
			MazeState mazeStateU = new MazeState(mazeState);
			MazeState.space[][] maze = mazeStateU.getMaze();
			int x1 = x;
			int y1 = y; 
			
			MazeState.space val = maze[x1][y1+1];
			while(val!=MazeState.space.WALL) {
				if(maze[x1][y1+1]==MazeState.space.UNSOLVED) {
					maze[x1][y1+1]=MazeState.space.SOLVED;
				}
				y1++;
				val = maze[x1][y1+1];
			}
			mazeStateU.setYCoord(y1);
			//implied setXCoord (should not have changed)
			mazeStateU.setMaze(maze);
			mazeStateU.incrementMoves();
			possibleMoves.add(mazeStateU);
		}

		if(mazeState.getMaze()[x][y-1]!=MazeState.space.WALL) { //D
			MazeState mazeStateD = new MazeState(mazeState);
			MazeState.space[][] maze = mazeStateD.getMaze();
			int x1 = x;
			int y1 = y; 
			
			MazeState.space val = maze[x1][y1-1];
			while(val!=MazeState.space.WALL) {
				if(maze[x1][y1-1]==MazeState.space.UNSOLVED) {
					maze[x1][y1-1]=MazeState.space.SOLVED;
				}
				y1--;
				val = maze[x1][y1-1];
			}
			mazeStateD.setYCoord(y1);
			//implied setXCoord (should not have changed)
			mazeStateD.setMaze(maze);
			mazeStateD.incrementMoves();
			possibleMoves.add(mazeStateD);
		}

		return possibleMoves;
	}

	public static void singlePlayer(int mazeNum) throws IOException {
		GenerateMaze m = new GenerateMaze();
		MazeState mazeState = m.makeMaze(mazeNum);

		while (getUnsolvedCount(mazeState)>0) {
			printMaze(mazeState);
			ArrayList<MazeState> a = getPossibleMoves(mazeState);
			byte input = getInput();
			makeMove(mazeState, input);
		}
		printMaze(mazeState);
		System.out.println();
		System.out.println("Solved! It took you " + mazeState.getMoves() + " moves!");
	}

	public static void printMaze(MazeState mazeState){
		
		MazeState.space[][] maze = mazeState.getMaze();
		for(int j=maze[0].length-1; j>=0; j--) {
			for(int i=0; i<maze.length;i++) {
				MazeState.space temp = maze[i][j];
				String toPrint = "";
				if(temp==MazeState.space.UNSOLVED) {
					toPrint = "  ";
				}
				else if(temp==MazeState.space.WALL) {
					toPrint = "W ";
				}
				else if(temp==MazeState.space.SOLVED) {
					toPrint = "* ";
				}
				if(mazeState.getCoords()[0] == i && mazeState.getCoords()[1] ==j) {
					toPrint = "x ";
				}
				System.out.print(toPrint);
			}
			System.out.println();
		}
	}

	public static void makeMove(MazeState mazeState, byte move) {
		MazeState.space[][] maze = mazeState.getMaze();
		int x = mazeState.getCoords()[0];
		int y = mazeState.getCoords()[1];
		if(move == 'R') {
			MazeState.space val = maze[x+1][y];
			while(val!=MazeState.space.WALL) {
				if(maze[x+1][y]==MazeState.space.UNSOLVED) {
					maze[x+1][y]=MazeState.space.SOLVED;
				}
				x++;
				val = maze[x+1][y];
			}
			mazeState.setXCoord(x);
		}
		if(move == 'L') {
			MazeState.space val = maze[x-1][y];
			while(val!=MazeState.space.WALL) {
				if(maze[x-1][y]==MazeState.space.UNSOLVED) {
					maze[x-1][y]=MazeState.space.SOLVED;
				}
				x--;
				val = maze[x-1][y];
			}
			mazeState.setXCoord(x);
		}
		if(move == 'U') {
			MazeState.space val = maze[x][y+1];
			while(val!=MazeState.space.WALL) {
				if(maze[x][y+1]==MazeState.space.UNSOLVED) {
					maze[x][y+1]=MazeState.space.SOLVED;
				}
				y++;
				val = maze[x][y+1];
			}
			mazeState.setYCoord(y);
		}
		if(move == 'D') {
			MazeState.space val = maze[x][y-1];
			while(val!=MazeState.space.WALL) {
				if(maze[x][y-1]==MazeState.space.UNSOLVED) {
					maze[x][y-1]=MazeState.space.SOLVED;
				}
				y--;
				val = maze[x][y-1];
			}
			mazeState.setYCoord(y);
		}
		if(move == 'C') { //for testing only
			System.out.println("Min cover: " + Lookahead.look(mazeState));
			//decrement
		}

		mazeState.incrementMoves();
	}

	public static byte getInput() throws IOException {
		BufferedReader reader =  
				new BufferedReader(new InputStreamReader(System.in)); 
		String val = reader.readLine(); 
		while(!(val.equals("L") || val.equals("R") || val.equals("U") || val.equals("D") || val.equals("C"))) {
			System.out.println("Invalid input, try again");
			val = reader.readLine(); 
		}
		return val.getBytes()[0];
	}

	public static int getUnsolvedCount(MazeState mazeState) {
		MazeState.space[][] maze = mazeState.getMaze();
		int count = 0;
		for(int j=maze[0].length-1; j>=0; j--) {
			for(int i=0; i<maze.length-1;i++) {
				if(maze[i][j]==MazeState.space.UNSOLVED) {
					count++;
				}
			}
		}
		return count;
	}

	public static LinkedList<int[]> getUnsolvedVals(MazeState mazeState) {
		LinkedList<int[]> val = new LinkedList<int[]>();
		MazeState.space[][] maze = mazeState.getMaze();
		for(int j=maze[0].length-1; j>=0; j--) {
			for(int i=0; i<maze.length-1;i++) {
				if(maze[i][j]==MazeState.space.UNSOLVED) {
					int[] arr = {i,j};
					val.add(arr);
				}
			}
		}
		return val;
	}

}
