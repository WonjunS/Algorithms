import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long ans;
    static PriorityQueue<Integer> negative, zero, positive;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        negative = new PriorityQueue<Integer>();
        zero = new PriorityQueue<Integer>();
        positive = new PriorityQueue<Integer>(Comparator.reverseOrder());

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x > 0) positive.add(x);
            else if(x == 0) zero.add(x);
            else negative.add(x);
        }
    }

    static void pro() {
        while(positive.size() > 1) {
            int a = positive.poll();
            int b = positive.poll();
            if(a > 1 && b > 1) ans += ((long) a * b);
            else ans += (a + b);
        }
        if(positive.size() == 1) ans += positive.poll();

        while(negative.size() > 1) {
            int a = negative.poll();
            int b = negative.poll();
            ans += ((long) a * b);
        }
        if(zero.size() == 0) {
            if(negative.size() > 0) {
                ans += negative.poll();
            }
        }
        if(zero.size() > 0) {
            if(negative.size() > 0) {
                ans += (long) negative.poll() * zero.poll();
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}