import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int total = 0;
        
        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            while(true) {
                if(q.isEmpty()) {
                    q.add(truck);
                    total += truck;
                    answer++;
                    break;
                }
                else if(q.size() == bridge_length) {
                    total -= q.poll();
                }
                else {
                    if(total + truck <= weight) {
                        q.add(truck);
                        total += truck;
                        answer++;
                        break;
                    }
                    else {
                        q.add(0);
                        answer++;
                    }
                }
            }
        }
        
        answer = answer + bridge_length;
        
        return answer;
    }
}