import java.util.*;

class Solution {
    
    static int[] answer;
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations) {
            String[] str = s.split(" ");
            
            if(str[0].equals("I")) {
                pq.add(Integer.parseInt(str[1]));
                maxPq.add(Integer.parseInt(str[1]));
            }
            if(str[0].equals("D")) {
                if(pq.isEmpty()) continue;
                if(str[1].equals("1")) {
                    int max = maxPq.poll();
                    pq.remove(max);
                    continue;
                }
                if(str[1].equals("-1")) {
                    int min = pq.poll();
                    maxPq.remove(min);
                    continue;
                }
            }
        }
        
        int max = 0;
        int min = 0;
        
        if(pq.size() == 0) {
            answer = new int[]{max, min};
            return answer;
        }
        
        if(pq.size() > 0) {
            max = maxPq.poll();
            min = pq.poll();
            answer = new int[]{max, min};
        }
        
        return answer;
    }
}