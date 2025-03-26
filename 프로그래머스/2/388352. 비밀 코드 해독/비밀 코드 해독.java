import java.util.*;

class Solution {
    
    private static int answer, max, m;
    private static List<Integer> list;
    
    public int solution(int n, int[][] q, int[] ans) {
        max = n;
        m = ans.length;
        
        init();
        
        makeCombination(0, 1, q, ans);
        
        return answer;
    }
    
    private static void init() {
        list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        list.add(-1);
        list.add(-1);
        list.add(-1);
    }
    
    private static void makeCombination(int idx, int k, int[][] q, int[] ans) {
        if(idx == 5) {
            List<Integer> temp = list;
            checkCondition(temp, q, ans);
            return;
        }
        
        for(int i = k; i <= max - (4 - idx); i++) {
            list.set(idx, i);
            makeCombination(idx + 1, i + 1, q, ans);
            list.set(idx, -1);
        }
    }
    
    private static void checkCondition(List<Integer> obj, int[][] q, int[] ans) {
        boolean flag = true;
        for(int i = 0; i < m; i++) {
           int cnt = 0;
           int target = ans[i];
           
           for(int j = 0; j < q[i].length; j++) {
               int k = q[i][j];
               if(obj.contains(k)) cnt++;
           }
           
           if(cnt != target) {
               flag = false;
               break;
           }
       }
        
        if(flag) {
            answer++;
        }
    }
    
}