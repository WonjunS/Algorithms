import java.util.*;

public class Main {
    
    static int N;
    static int[] nums;
    static int[][] Dy;
    static ArrayList<Integer>[] adj;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        Dy = new int[N + 1][2];
        nums = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            adj[a].add(b);
            adj[b].add(a);
        }
    }
    
    static void pro() {
        dfs(1, -1);
        
        System.out.println(Math.max(Dy[1][0], Dy[1][1]));
    }
    
    static void dfs(int x, int prev) {
        Dy[x][1] = nums[x];
        for(int y : adj[x]) {
            if(y == prev) continue;
            dfs(y, x);
            Dy[x][0] += Math.max(Dy[y][0], Dy[y][1]);
            Dy[x][1] += Dy[y][0];
        }
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}