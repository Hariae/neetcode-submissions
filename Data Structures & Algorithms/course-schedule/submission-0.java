class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[1]]++;

            List<Integer> adjList = adj.getOrDefault(prerequisite[0], new ArrayList<>());
            adjList.add(prerequisite[1]);
            adj.put(prerequisite[0], adjList);
        }

      //  System.out.println(adj);

        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<indegree.length;i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }        
        }
        

        int finish = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            finish++;
           // System.out.println(course);
            for (int nei : adj.getOrDefault(course, new ArrayList<>())) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
       

        
    }
}
