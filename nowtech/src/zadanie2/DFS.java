package zadanie2;

import java.util.LinkedList;

public class DFS {

	/*
	 * W pe³ni sprawne przeszukiwanie DFS dla czworok¹tów
	 */

//	protected int[][] maze = {
//			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
//			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0,0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0,1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0,1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
//			{ 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0,1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
//			{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0,1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1 },
//			{ 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
//			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1,1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//			{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
//			{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1,1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
//			{ 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0,1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
//			{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0,1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0,1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0,1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0,0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1,1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
//			{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0,0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1,1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0,0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
//			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0,1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0,1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1,1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0,0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
//			{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0,1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
//			{ 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
//			{ 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0,1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
//			{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0,1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1,1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
//			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0,0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
//			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1,1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0,0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0,1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1 },
//			{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0,0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
//			{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1,1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0,1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
//			{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1,1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
//			{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
//			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	protected boolean[][] visited = new boolean[41][41];

	protected int startX = 1;
	protected int startY = 1;
	protected int endX = 39;
	protected int endY = 1;

	protected String direction = "down";

	protected LinkedList<Integer> cords;
	protected LinkedList<LinkedList<Integer>> path = new LinkedList<LinkedList<Integer>>();

	protected LinkedList<Integer> neigbor;
	protected LinkedList<LinkedList<Integer>> neighbors = new LinkedList<LinkedList<Integer>>();

	public LinkedList<LinkedList<Integer>> dfs(int[][] maze, int startX,
			int startY, boolean[][] visited) {

		int x = startX;
		int y = startY;
		int xUp = 0;
		int xDown = 0;
		int yLeft = 0;
		int yRight = 0;

		if (x > 0) {
			xUp = x - 1;
		}
		if (x < 40) {
			xDown = x + 1;
		}
		if (y > 0) {
			yLeft = y - 1;
		}
		if (y < 40) {
			yRight = y + 1;
		}
		if (x == endX && y == endY) {
			LinkedList<Integer> cords = new LinkedList<Integer>();

			cords.add(x);
			cords.add(y);
			path.add(cords);

			return path;
		}

		else {
			switch (direction) {
			case "up":

				// Dodawanie wspó³rzêdnych odwiedzonego punktu do œcie¿ki
				LinkedList<Integer> cords = new LinkedList<Integer>();
				cords.add(x);
				cords.add(y);
				path.add(cords);

				visited[x][y] = true;

				isNeighborVisited(x, y, neighbors);
				findNeighbors(maze, x, y, visited, xUp, xDown, yLeft, yRight);

				/*
				 * Jezeli jest mo¿liwe przejœcie zgodnie z wybranym kierunkien
				 * up, down, left, right to metoda jest wywo³ywana rekurencyjnie
				 * przechodz¹c coraz dalej zgodnie z wybranym kierunkiem
				 */
				if (maze[xUp][y] == 0 && !visited[xUp][y]) {
					return dfs(maze, x - 1, y, visited);
				} else {
					direction = "switchDirection";
					return dfs(maze, x, y, visited);
				}
			case "down":

				// Dodawanie wspó³rzêdnych odwiedzonego punktu do œcie¿ki
				LinkedList<Integer> cords1 = new LinkedList<Integer>();
				cords1.add(x);
				cords1.add(y);
				path.add(cords1);

				visited[x][y] = true;

				isNeighborVisited(x, y, neighbors);
				findNeighbors(maze, x, y, visited, xUp, xDown, yLeft, yRight);

				if (maze[xDown][y] == 0 && !visited[xDown][y]) {
					return dfs(maze, x + 1, y, visited);
				} else {
					direction = "switchDirection";
					return dfs(maze, x, y, visited);
				}
			case "left":

				// Dodawanie wspó³rzêdnych odwiedzonego punktu do œcie¿ki
				LinkedList<Integer> cords2 = new LinkedList<Integer>();
				cords2.add(x);
				cords2.add(y);
				path.add(cords2);

				visited[x][y] = true;

				isNeighborVisited(x, y, neighbors);
				findNeighbors(maze, x, y, visited, xUp, xDown, yLeft, yRight);

				if (maze[x][yLeft] == 0 && !visited[x][yLeft]) {
					return dfs(maze, x, y - 1, visited);
				} else {
					direction = "switchDirection";
					return dfs(maze, x, y, visited);
				}
			case "right":

				// Dodawanie wspó³rzêdnych odwiedzonego punktu do œcie¿ki
				LinkedList<Integer> cords3 = new LinkedList<Integer>();
				cords3.add(x);
				cords3.add(y);
				path.add(cords3);

				visited[x][y] = true;

				isNeighborVisited(x, y, neighbors);
				findNeighbors(maze, x, y, visited, xUp, xDown, yLeft, yRight);

				if (maze[x][yRight] == 0 && !visited[x][yRight]) {
					return dfs(maze, x, y + 1, visited);
				} else {
					direction = "switchDirection";
					return dfs(maze, x, y, visited);
				}
			case "back":
				/*
				 * Powrót polega na pobraniu ostatniej pozycji z listy s¹siadów
				 * i dodaniu jej jako kolejny element œcie¿ki
				 */
				int xN = neighbors.getLast().getFirst();
				int yN = neighbors.getLast().getLast();

				LinkedList<Integer> cords4 = new LinkedList<Integer>();
				cords4.add(xN);
				cords4.add(yN);
				path.add(cords4);

				// zaznaczenie ¿e nowy punkt zosta³ odwiedzony
				visited[xN][yN] = true;

				isNeighborVisited(xN, yN, neighbors);
				findNeighbors(maze, xN, yN, visited, xUp, xDown, yLeft, yRight);

				direction = "switchDirection";

				return dfs(maze, cords4.getFirst(), cords4.getLast(), visited);

			case "switchDirection":

				if (maze[xUp][y] == 0 && !visited[xUp][y]) {
					direction = "up";
					return dfs(maze, xUp, y, visited);
				}
				if (maze[xDown][y] == 0 && !visited[xDown][y]) {
					direction = "down";
					return dfs(maze, xDown, y, visited);
				}
				if (maze[x][yLeft] == 0 && !visited[x][yLeft]) {
					direction = "left";
					return dfs(maze, x, yLeft, visited);
				}
				if (maze[x][yRight] == 0 && !visited[x][yRight]) {
					direction = "right";
					return dfs(maze, x, yRight, visited);
				} else {
					direction = "back";
					return dfs(maze, x, y, visited);
				}

			}
		}
		return path;
	}

	/*
	 * sprawdzanie czy s¹ rozwidlenia nieodwiedzone œcierzki je¿eli tak, to
	 * dodanie ich do listy s¹siadów
	 */
	public LinkedList<LinkedList<Integer>> findNeighbors(int[][] maze, int x,
			int y, boolean[][] visited, int xUp, int xDown, int yLeft, int yRight) {

			if (maze[x][yLeft] == 0 && !visited[x][yLeft]) {
				LinkedList<Integer> neigbor = new LinkedList<Integer>();
				neigbor.add(x);
				neigbor.add(yLeft);
				neighbors.add(neigbor);
			}
			if (maze[x][yRight] == 0 && !visited[x][yRight]) {
				LinkedList<Integer> neigbor = new LinkedList<Integer>();
				neigbor.add(x);
				neigbor.add(yRight);
				neighbors.add(neigbor);
			}
			if (maze[xUp][y] == 0 && !visited[xUp][y]) {
				LinkedList<Integer> neigbor = new LinkedList<Integer>();
				neigbor.add(xUp);
				neigbor.add(y);
				neighbors.add(neigbor);
			}
			if (maze[xDown][y] == 0 && !visited[xDown][y]) {
				LinkedList<Integer> neighbor = new LinkedList<Integer>();
				neighbor.add(xDown);
				neighbor.add(y);
				neighbors.add(neighbor);
			}
		return neighbors;
	}

	/*
	 * Sprawdzenie czy odwiedzany punkt znajdujê siê na liœcie s¹siadów je¿eli
	 * tak to usuniêcie go z tej listy
	 */
	public LinkedList<LinkedList<Integer>> isNeighborVisited(int x, int y,
			LinkedList<LinkedList<Integer>> neighbors) {
		if (!neighbors.isEmpty()) {
			for (int i = 0; i < neighbors.size(); i++) {
				if (x == neighbors.get(i).getFirst()
						&& y == neighbors.get(i).getLast()) {
					neighbors.remove(i);
				}
			}
		}
		return neighbors;
	}
}

