/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        int result = 0;
        for (Interval interval : intervals) {
            if (!pq.isEmpty() && interval.start >= pq.peek().end) {
                pq.poll();                
            }                 
            pq.add(interval);                        
            result = Math.max(result, pq.size());
        }

        return result;

    }
}
