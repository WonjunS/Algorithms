import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for(int[] route : routes) {
            list.add(route);
        }
        
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        while(!list.isEmpty()) {
            int position = list.get(0)[1];
            
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i)[0] <= position) {
                    list.remove(i);
                    i--;
                }
            }
            answer++;
        }
        
        return answer;
    }
}