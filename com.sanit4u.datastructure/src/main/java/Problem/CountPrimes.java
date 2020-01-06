package Problem;

/**
 * count the number of prime number from 1 to N
 *
 */
public class CountPrimes {

	public static void main(String[] args) {

		System.out.println(countPrimes(10));
	}

	private static int countPrimes(int N) {
		int count = 0;

		for (int i = 2; i < N; i++) {
			count = isPrime(i) ? ++count : count;
		}

		return count;
	}

	static boolean isPrime(int number) {

		if (number == 2 || number == 3) {
			return true;
		}

		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}

		for (int i = 3; i < Math.sqrt(number); i += 2) {
			if ((number % i == 0) || (number % Math.sqrt(number) == 0)) {
				return false;
			}
		}

		return true;
	}
}
