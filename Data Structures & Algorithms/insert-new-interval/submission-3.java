class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int i=0;i<intervals.length;i++) {

            // if (newInterval == null) {
            //     result.add(intervals[i]);
            // }

            // after

            if (newInterval == null || intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                continue;
            } else if (intervals[i][0] > newInterval[1]) {
                // found the place
                result.add(newInterval);
                result.add(intervals[i]);
                newInterval = null;
            } else {
                // overlap
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }            

            

            
        }

        if (newInterval != null) {
            result.add(newInterval);
        }

        int[][] resultArr = new int[result.size()][2];
        int k = 0;
        for (int[] item : result) {
            resultArr[k][0] = result.get(k)[0];
            resultArr[k][1] = result.get(k)[1];
            k++;
        }

        return resultArr;
        
    }
}