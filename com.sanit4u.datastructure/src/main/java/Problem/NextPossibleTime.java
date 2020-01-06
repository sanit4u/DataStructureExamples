package Problem;

import java.util.HashSet;
import java.util.Set;

public class NextPossibleTime {

	public static void main(String[] args) {
		System.out.println(nextPossibleTime("19:34"));
		System.out.println(nextPossibleTime("23:59"));
	}

	private static String nextPossibleTime(String time) {

		int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
		minutes = minutes + Integer.parseInt(time.substring(3));

		// add on minutes and convert those minutes to time and check whether the
		// converted time has digits in the input time digits.
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < time.length(); i++) {
			set.add(time.charAt(i) - '0');
		}
		while (true) {

			minutes = minutes + 1;
			int hour = minutes / 60;
			if (hour > 23) {
				hour = 24 - hour;
				minutes = minutes * hour;
				continue;
			}

			int min = minutes % 60;
			if (min > 59) {
				min = 60 - min;
				minutes = minutes + min;
			}

			String hourStr = String.valueOf(hour);
			if (hour <= 9) {
				hourStr = "0" + hourStr;
			}
			String minStr = String.valueOf(min);
			if (min <= 9) {
				minStr = "0" + minStr;
			}
			String nextPosTime = hourStr + ":" + minStr;
			boolean isALLValid = true;
			for (char c : nextPosTime.toCharArray()) {

				int digit = c - '0';

				if (!set.contains(digit)) {
					isALLValid = false;
					continue;
				}
			}

			if (isALLValid) {
				return nextPosTime;
			}
		}

	}
}
