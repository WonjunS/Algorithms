import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Long> pq;

    static void input() {
        Scanner sc = new Scanner(System.in);
        pq = new PriorityQueue<>();

        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            pq.add(sc.nextLong());
        }
    }

    static void pro() {
        long sum = 0;
        while(pq.size() > 1) {
            long x = pq.poll();
            long y = pq.poll();
            sum += x + y;
            pq.add(x + y);
        }
        
        System.out.println(sum);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}