package dsa.leetcodeANDgfg;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _252_MeetingRooms_920_Lintcode {


//      Definition of Interval:
      static class Interval {
          int start, end;
          Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }
    public boolean canAttendMeetings(List<Interval> intervals) {
          if(intervals.size() == 1)
              return true;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });
        boolean canAttend = true;
        for(int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i+1);

            if(current.end > next.start) {
                canAttend = false;
                break;
            }
        }
        return canAttend;
    }
}
