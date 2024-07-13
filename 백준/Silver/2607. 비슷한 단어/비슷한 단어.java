import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String word = br.readLine();

        int answer = 0;

        while(N-- > 1) {
            String compWord = br.readLine();

            if(Math.abs(word.length() - compWord.length()) >= 2) continue;
            
            Map<Character, Integer> map1 = new HashMap<>();
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(map1.containsKey(c)) {
                    int cnt = map1.get(c);
                    map1.put(c, cnt + 1);
                } else {
                    map1.put(c, 1);
                }
                
            }
            Map<Character, Integer> map2 = new HashMap<>();
            for(int i = 0; i < compWord.length(); i++) {
                char c = compWord.charAt(i);
                if(map2.containsKey(c)) {
                    int cnt = map2.get(c);
                    map2.put(c, cnt + 1);
                } else {
                    map2.put(c, 1);
                }
            }

            int diff = 0;
            for(int i = 0; i < 26; i++) {
                char c = (char) ((int) 'A' + i);

                int cnt1 = map1.getOrDefault(c, 0);
                int cnt2 = map2.getOrDefault(c, 0);

                diff += Math.abs(cnt1 - cnt2);
            }

            if(diff <= 2) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}