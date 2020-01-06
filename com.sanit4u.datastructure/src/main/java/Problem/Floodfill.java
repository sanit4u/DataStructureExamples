package Problem;

public class Floodfill {

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		floodFill(image, 0, 0, 2);

		System.out.println(image);
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		
		fillAllConnectedCells(image, sr, sc, newColor);

		return image;

	}

	private static void fillAllConnectedCells(int[][] image, int sr, int sc, int colour) {

		if (image[sr][sc] == 0 || image[sr][sc] == 2 ) {
			return;
		}

		image[sr][sc] = 2;
		fillAllConnectedCells(image, sr + 1, sc, colour);
		fillAllConnectedCells(image, sr - 1, sc, colour);
		fillAllConnectedCells(image, sr, sc + 1, colour);
		fillAllConnectedCells(image, sr, sc - 1, colour);

	}
}
