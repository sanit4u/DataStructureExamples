package Problem;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		System.out.println(coinChangeMinimum(coins, 11));
		System.out.println(coinChangePossibilities(coins, 11));
		System.out.println(numberOfSolutionsOnSpace(11, coins));
	}

	public static int coinChangeMinimum(int[] coins, int amount) {

		int[] combinations = new int[amount + 1];
		Arrays.fill(combinations, amount + 1);
		combinations[0] = 0;

		for (int j = 0; j < coins.length; j++) {
			for (int i = 1; i < combinations.length; i++) {
				if (i >= coins[j]) {
					// Minimum is taken, because we need fewest number of coins.
					combinations[i] = Math.min(combinations[i], 1 + combinations[i - coins[j]]);

					System.out.println("i :" + i + " Coin : " + coins[j] + " - " + Arrays.toString(combinations));
				}
			}
		}

		return combinations[amount] > amount ? -1 : combinations[amount];

	}

	public static int coinChangePossibilities(int[] coins, int amount) {

		int[][] tempTable = new int[coins.length + 1][amount + 1];

		for (int i = 0; i < coins.length; i++) {
			tempTable[i][0] = 1; // initializing for 0's
		}
//		for (int i = 0; i < tempTable[0].length; i++) {
//			tempTable[0][i] = 1; // initializing for 0's
//		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j < amount + 1; j++) {
				if (coins[i - 1] > j) {
					tempTable[i][j] = tempTable[i - 1][j];
				} else {
					tempTable[i][j] = tempTable[i - 1][j] + tempTable[i][j - coins[i - 1]];
				}
			}
		}

		return tempTable[coins.length][amount];
	}

	/**
	 * Space efficient DP solution
	 */
	public static int numberOfSolutionsOnSpace(int total, int coins[]) {

		int temp[] = new int[total + 1];

		temp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j >= coins[i]) {
					temp[j] += temp[j - coins[i]];
				}
			}
		}
		return temp[total];
	}

}
