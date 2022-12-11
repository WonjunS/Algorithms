import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] Dy;
    
    static void dfs(int x, int prev) {
        Dy[x] = 1;
        for(int y : tree[x]) {
            if(y == prev) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }
    
    static void input() {
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();
        
        tree = new ArrayList[N + 1];
        Dy = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        
        for(int i = 1; i <= N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            tree[a].add(b);
            tree[b].add(a);
        }
    }
    
    static void pro() {
        dfs(R, -1);
        
        for(int i = 1; i <= Q; i++) {
            int U = sc.nextInt();
            sb.append(Dy[U]).append('\n');
        }
        System.out.println(sb);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}