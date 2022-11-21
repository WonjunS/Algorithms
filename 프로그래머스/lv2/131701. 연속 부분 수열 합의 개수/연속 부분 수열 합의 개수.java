import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            for(int j = i; j < i + elements.length; j++) {
                sum += elements[j % elements.length];
                set.add(sum);
            }
        }
        
        int answer = set.size();
        
        return answer;
    }
}