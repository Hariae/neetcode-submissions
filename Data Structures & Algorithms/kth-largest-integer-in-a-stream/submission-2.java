class KthLargest {

    PriorityQueue<Integer> pq;
    int capacity;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.capacity = k;

        for (int num : nums) {
            if (pq.size() < capacity || pq.peek() <= num) {
                pq.add(num);
            }

            if (pq.size() > capacity) {
                pq.poll();
            }

            
        }

    }
    
    public int add(int val) {

        if (pq.size() < capacity || pq.peek() <= val) {
            pq.add(val);
        }

        if (pq.size() > capacity) {
            pq.poll();
        }

        

        return pq.peek();
        
    }
}
