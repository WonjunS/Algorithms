import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer>[] adj = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            String str = sc.next();
            adj[i] = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                char c = str.charAt(j);
                if(c == 'Y') adj[i].add(j);
            }
        }

        boolean[][] checked = new boolean[N][N];
        int[] friends = new int[N];

        // A - B
        for(int a = 0; a < N; a++) {
            for(int b : adj[a]) {
                if(checked[a][b] || checked[b][a]) continue;
                friends[a]++;
                friends[b]++;

                checked[a][b] = true;
                checked[b][a] = true;
            }
        }

        // A - C && B - C
        for(int a = 0; a < N; a++) {
            for(int c : adj[a]) {
                for(int b : adj[c]) {
                    if(checked[a][b] || checked[b][a]) continue;
                    if(a == b) continue;

                    friends[a]++;
                    friends[b]++;

                    checked[a][b] = true;
                    checked[b][a] = true;
                }
            }
        }

        int answer = 0;
        for (int cnt : friends) {
            answer = Math.max(answer, cnt);
        }

        sc.close();

        System.out.println(answer);
    }

}