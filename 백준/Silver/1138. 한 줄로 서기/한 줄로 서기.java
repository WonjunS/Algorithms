import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int count = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= N; j++) {
                if(count == 0) {
                    if(line[j] == 0) {
                        line[j] = i;
                        break;
                    } else {
                        continue;
                    }
                } else if(line[j] == 0) {
                    count--;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(line[i]).append(' ');
        }
        
        System.out.println(sb.toString());
    }
    
}