class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                int sum = 0;
                Integer prev = null, prev_1 = null;
                if (!stack.isEmpty()) {
                    prev = stack.pop();
                    sum += prev;
                }

                if (!stack.isEmpty()) {
                    prev_1 = stack.pop();
                    sum += prev_1;
                }                

                
                if (prev_1 != null) stack.push(prev_1);
                if (prev != null) stack.push(prev);
                if (prev != null) stack.push(sum);

            } else if (op.equals("C")) {
                stack.pop();

            } else if (op.equals("D")) {
                if (!stack.isEmpty()) {
                    stack.push(stack.peek() * 2);
                }
                
            } else {
                stack.push(Integer.parseInt(op));
            }      

           // System.out.println(stack)     ;
        }

        int sum = 0;

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}