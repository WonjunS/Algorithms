import java.util.*;

class Solution {
    
    private static int N;
    private static Set<Integer> set;
    private static boolean[] used;
    
    public int solution(String numbers) {
        N = numbers.length();
        used = new boolean[N];
        set = new HashSet<>();
        
        dfs("", numbers);
        
        return set.size();
    }
    
    private static void dfs(String str, String numbers) {
        int num = str.length() == 0 ? 0 : Integer.parseInt(str);
        if(str.length() > N) return;
        if(str.length() > 0 && isPrimeNumber(num)) {
            set.add(num);
        }
        
        for(int i = 0; i < N; i++) {
            if(used[i]) continue;
            used[i] = true;
            dfs(str + numbers.charAt(i), numbers);
            used[i] = false;
        }
    }
    
    private static boolean isPrimeNumber(int k) {
        if(k == 2 || k == 3) {
            return true;
        }
        if(k == 0 || k == 1 || k % 2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(k); i+=2) {
            if(k % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}