import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int N = priorities.length;
        int[] orders = new int[priorities.length];
        
        Queue<int[]> waitingQueue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            waitingQueue.add(new int[]{i, priorities[i]});
        }
        
        int rank = 1;
        while(!waitingQueue.isEmpty()) {
            int[] arr = waitingQueue.poll();
            int idx = arr[0];
            int p = arr[1];
            
            Queue<int[]> temp = new LinkedList<>();
            boolean flag = true;
            while(!waitingQueue.isEmpty()) {
                int[] temp_arr = waitingQueue.poll();
                int x = temp_arr[1];
                if(x > p) {
                    flag = false;
                }
                temp.add(temp_arr);
            }
            
            while(!temp.isEmpty()) {
                waitingQueue.add(temp.poll());
            }
            
            if(flag) {
                orders[idx] = rank++;
            } else {
                waitingQueue.add(arr);
            }
        }
        
        return orders[location];
    }
}