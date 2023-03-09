class Solution {
    
    static int answer;
    static boolean[] shouldPainted;
    
    public int solution(int n, int m, int[] section) {
        shouldPainted = new boolean[n + 1];
        for(int i = 0; i < section.length; i++) {
            shouldPainted[section[i]] = true;
        }
        
        for(int i = 1; i <= n - m + 1; i++) {
            if(!shouldPainted[i]) continue;
            if(shouldPainted[i]) paint(i, m);   
        }
        
        for(int i = n; i >= m; i--) {
            if(!shouldPainted[i]) continue;
            if(shouldPainted[i]) paint_reverse(i, m);   
        }
        
        return answer;
    }
    
    static void paint(int start, int m) {
        for(int i = start; i < start + m; i++) {
            shouldPainted[i] = false;
        }
        answer++;
    }
    
    static void paint_reverse(int start, int m) {
        for(int i = start; i > start - m; i--) {
            shouldPainted[i] = false;
        }
        answer++;
    }
}