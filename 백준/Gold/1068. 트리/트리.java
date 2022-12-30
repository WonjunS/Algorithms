import java.util.*;

public class Main {
    
    static int N, erased, root;
    static int[] leaf;
    static ArrayList<Integer>[] adj;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        leaf = new int[N];
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int par = sc.nextInt();
            if(par == -1) {
                root = i;
                continue;
            }
            adj[par].add(i);
        }
        erased = sc.nextInt();
    }
    
    static void pro() {
        for(int i = 0; i < N; i++) {
            if(adj[i].contains(erased)) {
                adj[i].remove(adj[i].indexOf(erased));
            }
        }
        
        if(root != erased) dfs(root, -1);
        
        System.out.println(leaf[root]);
    }
    
    static void dfs(int x, int par) {
        if(adj[x].size() == 0) {
            leaf[x] = 1;
            return;
        }
        for(int y : adj[x]) {
            if(y == par) continue;
            dfs(y, x);
            leaf[x] += leaf[y];
        }
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}