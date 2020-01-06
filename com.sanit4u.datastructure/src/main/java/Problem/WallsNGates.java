package Problem;

public class WallsNGates {

	public static void main(String[] args) {

		//@formatter:off
		int[][] grid = new int[][] { 
				{ Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1}, 
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
				{ 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };
		//@formatter:on

		applyWallsNGates(grid);

		print(grid);
	}

	private static void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	// Gist:
	// Take the gates and calculate the distance from the gate to other cells.
	// if the value of cells is greater than the evaluated count, then check the
	// count
	private static void applyWallsNGates(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					applyWallNGates(grid, i, j, 0);
				}
			}
		}
	}

	private static void applyWallNGates(int[][] grid, int row, int col, int count) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] < count) {
			return;
		}

		grid[row][col] = count;
		applyWallNGates(grid, row + 1, col, count + 1);
		applyWallNGates(grid, row, col + 1, count + 1);
		applyWallNGates(grid, row - 1, col, count + 1);
		applyWallNGates(grid, row, col - 1, count + 1);

	}
}
