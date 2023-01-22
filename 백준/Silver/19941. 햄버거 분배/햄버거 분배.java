import java.util.*;

public class Main {

    static int N, K;
    static String[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        A = new String[N + 1];

        String str = sc.next();
        for(int i = 1; i <= N; i++) {
            A[i] = String.valueOf(str.charAt(i - 1));
        }

        for(int i = 1; i <= N; i++) {
            if(!A[i].equals("P")) continue;
            int left = i - K;
            if(left < 1) left = 1;
            int right = i + K;
            if(right > N) right = N;
            for(int j = left; j <= right; j++) {
                if(A[j].equals("H")) {
                    A[j] = "";
                    break;
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(A[i].equals("")) count++;
        }

        System.out.println(count);
    }
}