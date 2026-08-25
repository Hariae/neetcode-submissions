class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(a[0], b[0]));

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (pq.size() < k) {
                pq.add(new int[]{entry.getValue(), entry.getKey()});
            } else if (pq.peek()[0] < entry.getValue()) {
                pq.poll();
                pq.add(new int[]{entry.getValue(), entry.getKey()});
            } else {
                // 
            }

            
            
            
            
            
        }

        int[] result = new int[k];
        int x = 0;

        while (!pq.isEmpty()) {
            result[x] = pq.poll()[1];
            x++;
        }

        return result;


    }
}
