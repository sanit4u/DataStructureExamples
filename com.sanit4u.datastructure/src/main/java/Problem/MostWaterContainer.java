package Problem;

//@formatter:off
/**
 * Given N Integer, Find out the max area of water can be contained inside.
 * 
 * Example: {1,8,6,2,5,4,8,3,7}
 * 
 * 
 **/ 
//@formatter:on
public class MostWaterContainer {

	public static void main(String[] args) {

		int[] A = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(getMaxArea(A));
	}

	private static int getMaxArea(int[] height) {

		if (height == null || height.length < 2) {
			return 0;
		}

		int maxArea = Integer.MIN_VALUE;

		int low = 0, high = height.length - 1;
		while (low < high) {

			if (height[low] < height[high]) {
				int areaTemp = height[low] * (high - low);
				maxArea = Math.max(areaTemp, maxArea);
				low++;
			} else {
				int areaTemp = height[high] * (high - low);
				maxArea = Math.max(areaTemp, maxArea);
				high--;
			}
		}
		return maxArea;
	}
}
