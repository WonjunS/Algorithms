import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int N = S.length();
        
        char[] arr = new char[N];
        
        int count0 = 0, count1 = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = S.charAt(i);
            if(arr[i] == '0') count0++;
            else count1++;
        }
        
        count0 /= 2;
        count1 /= 2;
        
        for(int i = 0; i < N; i++) {
            if(count1 == 0) break;
            if(arr[i] == '1') {
                arr[i] = 'x';
                count1--;
            }
        }
        
        for(int i = N - 1; i >= 0; i--) {
            if(count0 == 0) break;
            if(arr[i] == '0') {
                arr[i] = 'x';
                count0--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(arr[i] != 'x') {
                sb.append(arr[i]);
            }
        }
        
        System.out.println(sb.toString());
    }
    
}