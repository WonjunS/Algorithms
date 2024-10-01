import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            list.add(x);
        }

        list.sort((o1, o2) -> o2 - o1);

        int max = 0;
        for(int i = 1; i <= N; i++) {
            int curr = list.get(i - 1);

            int w1 = curr;
            int w2 = curr * i;
            
            max = Math.max(max, w1);
            max = Math.max(max, w2);
        }

        System.out.println(max);
    }

}