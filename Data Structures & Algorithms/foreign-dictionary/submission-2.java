class Solution {
    public String foreignDictionary(String[] words) {
      // create adjMap and indegree map
        HashMap<Character, List<Character>> adjMap = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for (int i=0;i<words.length;i++) {
            for (int j=0;j<words[i].length();j++) {
                char c = words[i].charAt(j);
                adjMap.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }            
        }

        // populate adjmap, indegree
        for (int i=0;i<words.length-1;i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j=0;j<Math.min(word1.length(), word2.length());j++) {
                char w1 = word1.charAt(j), w2 = word2.charAt(j);
                if (w1 != w2) {
                    adjMap.get(w1).add(w2);
                    indegree.put(w2, indegree.get(w2) + 1);
                    break;
                }
            }
        }

        // BFS
        Queue<Character> q = new LinkedList<>();

        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.add(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);

            for (Character ch : adjMap.get(c)) {
                indegree.put(ch, indegree.get(ch) - 1);
                if (indegree.get(ch) == 0) {
                    q.add(ch);
                }
            }
            
        }

        if (sb.length() < indegree.size()) {
            return "";
        }


        return sb.toString();


    }
}
