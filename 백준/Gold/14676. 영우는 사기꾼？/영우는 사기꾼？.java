import java.util.*;

public class Main {
    
    static int N, M, K;
    static int[] indeg, count, satisfaction;
    static ArrayList<Integer>[] adj;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        indeg = new int[N + 1];
        count = new int[N + 1];
        satisfaction = new int[N + 1];
        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            adj[x].add(y);
            indeg[y]++;
        }
        boolean flag = false;
        for(int i = 1; i <= K; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            
            if(t == 1) {
                if(satisfaction[a] < indeg[a]) {
                    flag = true;
                }
                count[a]++;
                if(count[a] == 1) {
                    for(int y : adj[a]) {
                        satisfaction[y]++;
                    }
                }
            } else {
                if(count[a] == 0) {
                    flag = true;
                }
                count[a]--;
                if(count[a] == 0) {
                    for(int y : adj[a]) {
                        satisfaction[y]--;
                    }
                }
            }
        }
        if(!flag) {
            System.out.println("King-God-Emperor");
        } else {
            System.out.println("Lier!");
        }
    }
}