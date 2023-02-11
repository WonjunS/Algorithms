import java.util.*;

class Solution {
    
    static int result;
    static boolean[] target;
    static List<Integer> answer;
    
    public List<Integer> solution(long[] numbers) {
        answer = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            
            int len = (int) Math.floor(Math.log(number) / Math.log(2)) + 1;
            
            int k = 1;
            int treeLen = 0;
            while(true) {
                treeLen = (int) Math.pow(2, k++) - 1;
                if(treeLen >= len) break;
            }
            target = new boolean[treeLen];
            
            int idx = treeLen - 1;
            while(number > 0) {
                long mod = number % 2;
                
                if(mod == 1) {
                    target[idx--] = true;
                } else {
                    target[idx--] = false;
                }
                
                number /= 2;
            }
            
            result = 1;
            dfs(0, treeLen - 1, false);
            answer.add(result);
        }
        
        return answer;
    }
    
    static void dfs(int start, int end, boolean isEnd) {
        int mid = (start + end) / 2;
        
        boolean cur = target[mid];
        
        if(isEnd && cur) {
            result = 0;
            return;
        }
        
        if(start != end) {
            dfs(start, mid - 1, !cur);
            dfs(mid + 1, end, !cur);
        }
    }
}