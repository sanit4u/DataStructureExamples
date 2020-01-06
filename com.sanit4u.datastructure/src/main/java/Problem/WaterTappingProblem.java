package Problem;

import java.util.ArrayList;

// @formatter:off
/**
 * Given a non-negative n Integer array (that is an elevation map). we need to calculate the water containing volume in those gaps.
 *       |
 *   |www||w|
 * |w||w||||||
 * 
 * the above array is : {1,0,2,1,0,1,3,2,1,2,1}
 * Here, there are 6 water level volumes are present.
 */
// @formatter:on
public class WaterTappingProblem {

	public static void main(String[] args) {

		int[] array = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(getTotalWaterVolume(array));
		long currentTimeMillis1 = System.currentTimeMillis();
		System.out.println("Time: " + (currentTimeMillis1 - currentTimeMillis));
		System.out.println(getTotalWaterVolumeWithAux(array));
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println("Time: " + (currentTimeMillis2 - currentTimeMillis1));
	}

	private static int getTotalWaterVolume(int[] array) {
		int totalWater = 0;

		int leftMax = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			int currentElevation = array[i];
			leftMax = Math.max(leftMax, currentElevation);

			int rightMax = Integer.MIN_VALUE;

			int j = i + 1;

			if (j == array.length) {
				break;
			}

			for (; j < array.length; j++) {
				rightMax = Math.max(rightMax, array[j]);
			}

			int expectedWaterHeight = Math.min(leftMax, rightMax);

			int actualWaterHeight = expectedWaterHeight - currentElevation;

			totalWater = actualWaterHeight > 0 ? totalWater + actualWaterHeight : totalWater;

		}

		return totalWater;
	}

	private static int getTotalWaterVolumeWithAux(int[] height) {
		int totalWater = 0;

		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		leftMax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		rightMax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		for (int i = 0; i < height.length; i++) {
			int expectedWaterHeight = Math.min(leftMax[i], rightMax[i]);

			int actualHeight = expectedWaterHeight - height[i];
			totalWater = actualHeight > 0 ? totalWater + actualHeight : totalWater;
		}
		return totalWater;
	}
}
