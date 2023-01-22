import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static Set<String> list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String keyword = br.readLine();
            list.add(keyword);
        }
        
        for(int i = 0; i < M; i++) {
            String[] str = br.readLine().split(",");
            for(String keyword : str) {
                if(list.isEmpty() || !list.contains(keyword)) continue;
                else list.remove(keyword);
            }
            sb.append(list.size()).append('\n');
        }
        
        System.out.println(sb);
    }
}