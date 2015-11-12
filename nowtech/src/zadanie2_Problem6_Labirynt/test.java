package zadanie2_Problem6_Labirynt;

public class test {

	public static void main(String[] args) {
		
		SquareMaze sm = new SquareMaze();
		int[][] maze = sm.generateMaze();
//		sm.generateOutputData(maze);
		
		DFS dfs = new DFS();
		System.out.println(dfs.dfs(maze, dfs.startX, dfs.startY, dfs.visited));

	}

}
