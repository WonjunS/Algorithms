import java.util.*;

public class Main {

    static int min, max;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        while(T-- > 0) {
            String W = sc.next();
            int K = sc.nextInt();

            adj = new ArrayList[26];
            for(int i = 0; i < 26; i++) adj[i] = new ArrayList<>();
            max = 0;
            min = 10000;
            for(int i = 0; i < W.length(); i++) {
                char c = W.charAt(i);
                if(adj[c - 'a'].size() < K - 1) {
                    adj[c - 'a'].add(i);
                    continue;
                }
                adj[c - 'a'].add(i);
                int size = adj[c - 'a'].size();
                int len = adj[c - 'a'].get(size - 1) - adj[c - 'a'].get(size - K) + 1;
                min = Math.min(min, len);
                max = Math.max(max, len);

            }

            if(max == 0 && min == 10000) {
                sb.append("-1").append('\n');
            } else {
                sb.append(min + " " + max).append('\n');
            }
        }

        System.out.println(sb);
    }
}