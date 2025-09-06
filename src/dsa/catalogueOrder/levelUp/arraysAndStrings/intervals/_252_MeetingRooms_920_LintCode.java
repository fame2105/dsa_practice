package dsa.catalogueOrder.levelUp.arraysAndStrings.intervals;

import java.util.Collections;
import java.util.List;

// Easy
public class _252_MeetingRooms_920_LintCode {

    private class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

      /**
       * @param intervals: an array of meeting time intervals
       * @return: if a person could attend all meetings
       */

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start); // sort on the basis of start time
        Interval prevInterval = null;
        for(Interval interval : intervals) {
            if(prevInterval == null) {
                prevInterval = interval;
            } else {
                if(interval.start >= prevInterval.end) {
                    prevInterval = interval;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
