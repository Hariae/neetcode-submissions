class Solution {
    public int lastStoneWeight(int[] stones) {

        if (stones.length < 2) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  b - a);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int diff = first-second;

            if (diff != 0) {
                pq.offer(diff);
            }
        }

        pq.offer(0);

        return pq.peek();


    }
}
