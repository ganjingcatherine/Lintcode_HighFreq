/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


public class Solution {
    /*
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        
        // Search place to insert
        int i;
        for (i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start >= newInterval.start) {
                break;
            }
        }
        intervals.add(i, newInterval);
        
        // Merge intervals
        List<Interval> ans = new ArrayList<>();
        
        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end);
            }
        }
        
        return ans;
    }
}