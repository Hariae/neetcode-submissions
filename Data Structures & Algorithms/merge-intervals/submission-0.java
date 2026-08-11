class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        //System.out.println(Arrays.deepToString(intervals));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // merge

                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        int[][] resultArr = new int[result.size()][2];
        int k = 0;
        for (int[] item : result) {
            resultArr[k] = item;
            k++;
        }



        return resultArr;
        
    }
}
