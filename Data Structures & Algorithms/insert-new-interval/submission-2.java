class Solution {   

    // 1. find insertion point
    // 2. merge if overlap

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int left = 0, right = intervals.length-1;
        

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] < newInterval[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        // left is the insertion point

        List<int[]> merged = new ArrayList<>();

        for (int i=0;i<left;i++) {
            merged.add(intervals[i]);
        }
        merged.add(newInterval);
        for(int i=left;i<intervals.length;i++) {
            merged.add(intervals[i]);
        }

        List<int[]> result = new ArrayList<>();
       // result.add(merged.get(0));

        for (int i=0;i<merged.size();i++) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < merged.get(i)[0]) {
                result.add(merged.get(i));
            } else {
                // merge

                result.get(result.size() - 1)[1] = Math.max(
                    result.get(result.size() - 1)[1], 
                    merged.get(i)[1]);
            }
        }
// System.out.println(result);

        int[][] resultArray = new int[result.size()][2];
        int k = 0;
        for (int[] item : result) {
            resultArray[k] = item;
            k++;
        }

        return resultArray;

    }



    // public int[][] insert(int[][] intervals, int[] newInterval) {
    //     List<List<Integer>> result = new ArrayList<>();

    //     for (int i=0;i<intervals.length;i++) {
    //         int[] currInterval = intervals[i];

    //         if (newInterval == null || currInterval[1] < newInterval[0]) {
    //             // completely after ; add currInterval to result
    //             result.add(List.of(currInterval[0], currInterval[1]));
    //         } else if (currInterval[0] > newInterval[1]) {
    //             // completely before; add new to result
    //             result.add(List.of(newInterval[0], newInterval[1]));
    //             result.add(List.of(currInterval[0], currInterval[1]));
    //             newInterval = null;
    //         } else {
    //             // 
    //             newInterval[0] = Math.min(currInterval[0], newInterval[0]); 
    //             newInterval[1] = Math.max(currInterval[1], newInterval[1]);
    //         }
    //     }


    //     //System.out.println(result);

    //     if (newInterval != null) {
    //         result.add(List.of(newInterval[0], newInterval[1]));
    //     }

    //     int[][] resultArray = new int[result.size()][2];
    //     int k = 0;
    //     for (List<Integer> item : result) {
    //         resultArray[k] = new int[] {item.get(0), item.get(1)};
    //         k++;
    //     }

    //     return resultArray;
    // }
}
