package maze;

public class Lookahead {

	public static int look(MazeState mazeState) {

		MazeState.space[][] maze = mazeState.getMaze();
		int ySize = maze[0].length;
		int xSize = maze.length;
		boolean[][] boolArray = new boolean[xSize-2][ySize-2];
		for(int j=1; j<ySize-1; j++) {
			for(int i=1; i<xSize-1; i++) {
				if(maze[i][j].equals(MazeState.space.UNSOLVED)) {
					boolArray[i-1][j-1] = true;
				}
				else {
					boolArray[i-1][j-1] = false;
				}

			}
		}
		return maxMatching(boolArray);
	}

	public static int maxMatching(boolean[][] boolArray) {
		int xSize = boolArray.length;
		int ySize = boolArray[0].length;
		int[] assign = new int[ySize];
		for (int i=0; i<ySize; i++) {
			assign[i] = -1; //right side
		}
		int count = 0;

		for(int x=0; x<xSize; x++) {
			boolean[] visited = new boolean[ySize];

			if(biPartiteMatch(boolArray, x, visited, assign)) {
				count++;
			}
		}
		return count;
	}

	private static boolean biPartiteMatch(boolean[][] boolArray, int x, boolean[] visited, int[] assign) {
		int ySize = boolArray[0].length;
		for(int y = 0; y<ySize; y++) {
			//if edge between the two exists and has not been visited yet
			if(boolArray[x][y]==true && !visited[y]) {
				visited[y] = true; //mark as visited

				//if not yet assigned OR if y can be assigned to another job
				int assignX = assign[y];
				if(assignX <0 || biPartiteMatch(boolArray, assignX, visited, assign)) {
					assign[y] = x; //
					return true;
				}
			}
		}
		return false;
	}

}
