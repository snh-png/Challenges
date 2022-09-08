package DataStructure.Array;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

public class TimeInterval {
    private int start;
    private int end;

    public TimeInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<TimeInterval> merge(List<TimeInterval> intervals) {
        if(intervals.size() <= 1) return intervals;

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        LinkedList<TimeInterval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (TimeInterval interval: intervals) {
            if(interval.start <= end)
                end = Math.max(interval.end, end);
            else {
                result.add(new TimeInterval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        result.add(new TimeInterval(start, end));
        return result;
    }
}
