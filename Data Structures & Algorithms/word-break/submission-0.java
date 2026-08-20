class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] seen = new boolean[s.length() + 1];

        q.add(0);

        while(!q.isEmpty()) {
            int start = q.poll();

            if (start == s.length()) return true;

            

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) continue;
                if (dict.contains(s.substring(start, end))) {
                    q.add(end);
                    seen[end] = true;
                }
            }
            
        }

        return false;
    }
}