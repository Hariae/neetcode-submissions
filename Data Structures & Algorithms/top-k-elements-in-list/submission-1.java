class Solution {

    class Pair {
        int key;
        int count;

        Pair(int key, int count) {
            this.key = key;
            this.count = count;
        }


    }
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> Integer.compare(a.count, b.count));

        HashMap<Integer, Integer> freqMap = new HashMap<>();


        for(int i=0;i<nums.length;i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            pq.add(pair);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i=0;
        while(k > 0) {
            Pair pair = pq.poll();
            result[i] = pair.key;
            i++;
            k--;
        }

        return result;

    }
}
