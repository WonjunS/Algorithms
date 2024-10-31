import java.util.*;
import java.io.*;

public class Main {

    private static int[] D;

    private static final int MAX_VALUE = 50000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        int n = Integer.parseInt(br.readLine());

        System.out.println(D[n]);
    }

    private static void init() {
        D = new int[MAX_VALUE + 1];

        for(int i = 1; i <= MAX_VALUE; i++) {
            D[i] = i;
        }

        for(int i = 2; i <= MAX_VALUE; i++) {
            for(int j = 1; j * j <= i; j++) {
                D[i] = Math.min(D[i], D[i - j * j] + 1);
            }
        }
    }

}