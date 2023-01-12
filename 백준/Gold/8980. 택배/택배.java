import java.util.*;
import java.io.*;

public class Main {

    static class Box {
        private int from;
        private int to;
        private int amount;

        public Box(int from, int to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }
    }

    static int N, C, M;
    static int[] truck;
    static ArrayList<Box> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        truck = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            list.add(new Box(from, to, amount));
        }

        Arrays.fill(truck, C);
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Box b1, Box b2) {
                if(b1.to == b2.to) {
                    return b1.from - b2.from;
                }
                return b1.to - b2.to;
            }
        });

        int total = 0;
        for(Box b : list) {
            Box box = b;
            int from = box.from;
            int to = box.to;
            int amount = box.amount;

            int min = Integer.MAX_VALUE;
            for(int i = from; i < to; i++) {
                min = Math.min(min, truck[i]);
            }
            int load = amount;
            load = Math.min(load, min);

            total += load;

            for(int i = from; i < to; i++) {
                truck[i] -= load;
            }
        }

        System.out.println(total);
    }
}