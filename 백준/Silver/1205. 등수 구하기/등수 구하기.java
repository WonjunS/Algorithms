import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println("1");
            return;
        }
        
        int[] A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            A[i] = score;
        }
        
        int rank = 1;
        int answer = 1;
        if(N == P && newScore <= A[N - 1]) {
            answer = -1;
        } else {
            for(int i = 0; i < N; i++) {
                if(A[i] > newScore) {
                    rank++;
                } else {
                    break;
                }
            }
            answer = rank;
        }
        
        System.out.println(answer);
    }
    
}