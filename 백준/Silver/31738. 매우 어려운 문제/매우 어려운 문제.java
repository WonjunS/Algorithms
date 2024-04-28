import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long answer = -1;
        if(N >= M) {
            answer = 0;
        } else {
            long value = factorial(N, M);
            answer = value % M;
        }

        System.out.println(answer);
    }

    private static long factorial(long n, long M) {
        if(n == 1) {
            return 1;
        }

        return (n * factorial(n - 1, M)) % M;
    }

}