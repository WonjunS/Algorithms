import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        
        Map<String, Integer> userMap = new HashMap<>();
        
        while(N-- > 0) {
            String username = br.readLine();
            
            userMap.put(username, userMap.getOrDefault(username, 0) + 1);
        }
        
        int answer = -1;
        
        if(game.equals("Y")) {
            answer = userMap.size() / 1;
        } else if(game.equals("F")) {
            answer = userMap.size() / 2;
        } else {
            answer = userMap.size() / 3;
        } 
        
        System.out.println(answer);
    }
    
}