class Solution {                
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<intervals.length;i++) {
            int[] currInterval = intervals[i];

            if (newInterval == null || currInterval[1] < newInterval[0]) {
                // completely after ; add currInterval to result
                result.add(List.of(currInterval[0], currInterval[1]));
            } else if (currInterval[0] > newInterval[1]) {
                // completely before; add new to result
                result.add(List.of(newInterval[0], newInterval[1]));
                result.add(List.of(currInterval[0], currInterval[1]));
                newInterval = null;
            } else {
                // 
                newInterval[0] = Math.min(currInterval[0], newInterval[0]); 
                newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            }
        }


        //System.out.println(result);

        if (newInterval != null) {
            result.add(List.of(newInterval[0], newInterval[1]));
        }

        int[][] resultArray = new int[result.size()][2];
        int k = 0;
        for (List<Integer> item : result) {
            resultArray[k] = new int[] {item.get(0), item.get(1)};
            k++;
        }

        return resultArray;
    }
}
