import java.util.*;
import java.io.*;

public class Main {
    
    private static class Title {
        private String name;
        private int power;
        
        public Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
    
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static Title[] titles;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        titles = new Title[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            
            titles[i] = new Title(name, power);
        }
        
        while(M-- > 0) {
            int x = Integer.parseInt(br.readLine());
            
            binarySearch(0, N - 1, x);
        }
        
        System.out.println(sb.toString());
    }
    
    private static void binarySearch(int left, int right, int x) {
        while(left < right) {
            int mid = (left + right) / 2;
            
            Title title = titles[mid];
            if(x <= title.power) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        sb.append(titles[left].name).append('\n');
    }
    
}