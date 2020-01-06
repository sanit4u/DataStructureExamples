package Problem;

public class HouseRobber {

	public static void main(String[] args) {

	}

	public static int findMaxHouseRobber(int[] array) {

		if (array.length == 1) {
			return array[0];
		}

		if (array.length == 2) {
			return Math.max(array[0], array[1]);
		}

		for (int i = 2; i < array.length; i++) {
			array[i] = Math.max(array[i - 1], array[i] + array[i - 2]);
		}

		return array[array.length - 1];
	}
}
