package Problem;

public class MaximumAreaIsland {

	public static void main(String[] args) {

	}

	public static int getMaxAreaOfIsland(int[][] grid) {
		int maxArea = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int area = getAreaFromThisIsland(grid, i, j);
					maxArea = Math.max(area, maxArea);
				}
			}
		}

		return maxArea;
	}

	private static int getAreaFromThisIsland(int[][] grid, int i, int j) {
		if (i < 0 || i > grid.length || j < 0 || j > grid[i].length || grid[i][j] == 0) {

			return 0;
		}

		// to make the cell visited, that this cell has been covered for next iterations
		grid[i][j] = 0;
		int count = 1;
		// Move
		count += getAreaFromThisIsland(grid, i + 1, j);// down
		count += getAreaFromThisIsland(grid, i - 1, j); // up
		count += getAreaFromThisIsland(grid, i, j + 1); // right
		count += getAreaFromThisIsland(grid, i, j - 1); // left

		return count;
	}
}
