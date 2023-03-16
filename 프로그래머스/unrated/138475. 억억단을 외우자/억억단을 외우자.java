import java.util.*;

class Solution {
    public List<Integer> solution(int e, int[] starts) {
        List<Integer> answer = new ArrayList<>();
        int[] nums = new int[5000001];
        for(int i = 1; i <= 5000000; i++) {
            for(int j = 1; j <= 5000000; j++) {
                int product = i * j;
                if(product > 5000000) break;
                nums[product]++;
            }
        }
        
        int best = 1;
        for(int i = 2; i <= e; i++) {
            if(nums[i] > nums[best]) best = i;
        }
        
        for(int i = 0; i < starts.length; i++) {
            int s = starts[i];
            if(s <= best) {
                answer.add(best);
                continue;
            }
            int idx = s;
            for(int j = s + 1; j <= e; j++) {
                if(nums[j] > nums[idx]) idx = j;
            }
            
            answer.add(idx);
        }
        
        return answer;
    }
}