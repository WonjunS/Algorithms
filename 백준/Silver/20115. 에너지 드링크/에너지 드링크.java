import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Long[] drinks = new Long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            drinks[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(drinks, (o1, o2) -> (o2.compareTo(o1)));

        double total = drinks[0];
        for(int i = 1; i < N; i++) {
            long curr = drinks[i];

            total += curr / 2.0;
        }

        System.out.println(total);
    }

}