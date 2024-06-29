import java.util.*;
import java.io.*;

public class Main {

    private static int[] D;

    private static void init() {
        D = new int[1001];

        D[1] = 1;
        D[2] = 3;
        
        for(int i = 3; i <= 1000; i++) {
            D[i] = (D[i - 1] + D[i - 2] * 2) % 10007;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        init();

        int n = Integer.parseInt(br.readLine());

        System.out.println(D[n]);
    }

}