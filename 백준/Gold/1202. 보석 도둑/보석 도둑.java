import java.util.*;
import java.io.*;

public class Main {

    static class Gem {
        private int weight;
        private int value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int N, K;
    static long ans;
    static int[] bags;
    static Gem[] gems;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new Gem[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(M, V);
        }

        Arrays.sort(gems, new Comparator<Gem>() {
            @Override
            public int compare(Gem g1, Gem g2) {
                if(g1.weight == g2.weight) {
                    return g2.value - g1.value;
                }
                return g1.weight - g2.weight;
            }
        });

        bags = new int[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i = 0, j = 0; i < K; i++) {
            int C = bags[i];

            while(j < N && gems[j].weight <= C) {
                pq.add(gems[j++].value);
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}