import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        while(N-- > 0) {
            String s = br.readLine();
            
            if(s.length() < M) {
                continue;
            }
            
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        br.close();

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> {
            if(map.get(o1) != map.get(o2)) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
            if(o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb.toString());
    }
    
}