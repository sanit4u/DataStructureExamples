package Problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

	static class Intervals {

		int start;
		int end;

	}

	public static void main(String[] args) {

		Intervals interval = new Intervals();
		interval.start = 0;
		interval.end = 30;
		Intervals interval2 = new Intervals();
		interval2.start = 5;
		interval2.end = 10;
		Intervals interval3 = new Intervals();
		interval3.start = 15;
		interval3.end = 20;
		Intervals[] intervals = new Intervals[] { interval, interval2, interval3 };

		System.out.println(getNoOfMeetingRooms(intervals));
	}

	/**
	 * 
	 * Idea is
	 * 
	 * check if there is a meeting going on and another interval came up, then we
	 * need another meeting room.
	 * 
	 * @param intervals
	 * @return
	 */
	private static int getNoOfMeetingRooms(Intervals[] intervals) {
		// TODO Auto-generated method stub

		Arrays.sort(intervals, new Comparator<Intervals>() {

			@Override
			public int compare(Intervals arg0, Intervals arg1) {
				// TODO Auto-generated method stub
				return arg0.start - arg1.start;
			}
		});

		PriorityQueue<Intervals> q = new PriorityQueue<Intervals>(new Comparator<Intervals>() {

			@Override
			public int compare(Intervals i1, Intervals i2) {
				return i1.end - i2.end;
			}
		});
		q.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Intervals earliest = q.poll();
			Intervals currentInterval = intervals[i];
			if (earliest.end <= currentInterval.start) {

				earliest.end = currentInterval.end;
			} else {
				q.add(currentInterval);
			}

			q.add(earliest);
		}

		return q.size();
	}
}
