import java.util.*;

public class Main {
    
    static int N, max, min;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        max = 0;
        min = Integer.MAX_VALUE;
    }
    
    static void pro() {
        dfs(N, count_odd_num(N));
        System.out.println(min + " " + max);
    }
    
    static int count_odd_num(int x) {
        int cnt = 0;
        while(x > 0) {
            int n = x % 10;
            if(n % 2 == 1) cnt++;
            x /= 10;
        }
        return cnt;
    }
    
    static void dfs(int x, int count) {
        if(x < 10) {
            max = Math.max(count, max);
            min = Math.min(count, min);
            return;
        }
        if(x < 100) {
            int num = (x / 10) + (x % 10);
            dfs(num, count + count_odd_num(num));
            return;
        }
        String s = String.valueOf(x);
        for(int i = 0; i < s.length() - 2; i++) {
            for(int j = i + 1; j < s.length() - 1; j++) {
                String s1 = s.substring(0, i + 1);
                String s2 = s.substring(i + 1, j + 1);
                String s3 = s.substring(j + 1);
                
                int num = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                
                dfs(num, count + count_odd_num(num));
            }
        }
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}