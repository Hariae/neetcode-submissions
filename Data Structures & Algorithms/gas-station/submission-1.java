/*

[1, 2, 3, 4]
[2, 2, 4, 1]
 *      * 



*/

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;


        for (int i=0;i<gas.length;i++) {
            int diff = gas[i] - cost[i];

            total += diff;
            tank += diff;

            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }

        }

        return total >= 0 ? start : -1;
    }    

    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     Queue<Integer> q = new LinkedList<>();

    //     for (int i=0;i<gas.length;i++) {
    //         int c = cost[i];
    //         int g = gas[i];

    //         if (g >= c) {
    //             q.add(i);
    //         }
    //     }


    //     while (!q.isEmpty()) {
    //         int start = q.poll();
    //         int curr = start;

    //         int k = 0;
            
    //         int tank = 0;
    //         tank = tank + gas[curr] - cost[curr];
    //         curr = (curr+1) % gas.length;

    //         while(curr != start) {
    //             int c = cost[curr];
    //             int g = gas[curr];

    //             if ((tank + g) >= c) {
    //                 tank += g;
    //                 tank -= c;
    //                 curr = (curr+1) % gas.length;
                    
    //             } else {
    //                 break;
    //             }
    //             k++;
    //         }

    //         if (curr == start) {
    //             return start;
    //         }
    //     }

    //     return -1;
    // }
}
