import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        Map<String, String> map = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String status = st.nextToken();
            
            map.put(name, status);
        }
        
        List<String> list = new ArrayList<>();
   
        for(String name : map.keySet()) {
            if(map.get(name).equals("enter")) {
                list.add(name);
            }
        }
        
        list.sort((o1, o2) -> (o2.compareTo(o1)));
        
        StringBuilder sb = new StringBuilder();
        for(String name : list) {
            sb.append(name).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}