class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // adjmap
        HashMap<Integer, List<int[]>> adjMap = new HashMap<>();

        for (int[] flight : flights) {
            List<int[]> neis = adjMap.getOrDefault(flight[0], new ArrayList<>());
            neis.add(new int[]{flight[1], flight[2]});
            adjMap.put(flight[0], neis);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        // dest, cost, flights taken
        pq.add(new int[]{src, 0, 0});
        

        while (!pq.isEmpty()) {

            int[] node = pq.poll();
            int currDest = node[0];
            int cost = node[1];
            int steps = node[2];

            if (steps >= stops[currDest] || steps > k + 1) {
                continue;
            }
            
            stops[currDest] = steps;
            if (currDest == dst) {
                return cost;
            }



           

            // if not dest explore neis

            if (!adjMap.containsKey(currDest)) {
                continue;
            }

            for (int[] nei : adjMap.get(currDest)) {
                pq.add(new int[]{nei[0], cost + nei[1], steps + 1});
                
            }
        }

        return -1;

    }
}
