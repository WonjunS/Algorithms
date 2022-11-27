import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> container = new LinkedList<>();
        Stack<Integer> sub_container = new Stack<>();
        int answer = 0;
        int n = order.length;
        
        for(int i = 1; i <= n; i++) {
            container.add(i);
        }
        int idx = 0;
        for(idx = 0; idx < n; idx++) {
            if(container.isEmpty() && sub_container.peek() != order[idx]) break;
            if(!sub_container.isEmpty() && sub_container.peek() == order[idx]) {
                sub_container.pop();
                answer++;
                continue;
            }
            while(!container.isEmpty()) {
                if(container.peek() == order[idx]) {
                    container.poll();
                    answer++;
                    break;
                }
                sub_container.push(container.poll());
            }
        }
        
        return answer;
    }
}