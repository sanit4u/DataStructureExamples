package MAXSLIce;

public class MaxSlice {

	public static void main(String[] args) {
		MaxSlice slice = new MaxSlice();

		int[] A = { 3, 2, -6, 4, 0 };
		System.out.println(slice.solution(A));
	}

	public int solution(int[] A) {
		int highestSum = 0;

		if (A == null || A.length < 0) {
			return highestSum;
		}
		highestSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum = A[i] + sum;

			if (sum > highestSum) {
				highestSum = sum;
			}
		}

		return highestSum;
	}
}
