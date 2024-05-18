import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[200000][26];
        int idx = 0;
        while(true) {
            String word = br.readLine();
            if(word.equals("-")) break;

            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                arr[idx][c - 'A']++;
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        while(true) {
            String puzzle = br.readLine();
            if(puzzle.equals("#")) break;

            int[] count = new int[26];
            for(int i = 0; i < puzzle.length(); i++) {
                char c = puzzle.charAt(i);
                count[c - 'A']++;
            }

            int[] count2 = new int[9];
            for(int i = 0; i < puzzle.length(); i++) {
                char c = puzzle.charAt(i);

                for(int j = 0; j < idx; j++) {
                    if(arr[j][c - 'A'] == 0) continue;
                    boolean flag = true;
                    for(int k = 0; k < 26; k++) {
                        if(count[k] < arr[j][k]) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        count2[i]++;
                    }
                }
            }

            List<String> minList = new ArrayList<>();
            List<String> maxList = new ArrayList<>();
            
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int i = 0; i < puzzle.length(); i++) {
                String s = puzzle.substring(i, i + 1);
                int cnt = count2[i];

                if(cnt >= max) {
                    if(cnt > max) {
                        maxList.clear();
                        maxList.add(s);
                        max = cnt;
                    } else {
                        if(!maxList.contains(s)) {
                            maxList.add(s);
                        }
                    }
                    
                }
                if(cnt <= min) {
                    if(cnt < min) {
                        minList.clear();
                        minList.add(s);
                        min = cnt;
                    } else {
                        if(!minList.contains(s)) {
                            minList.add(s);
                        }
                    }
                }
            }

            maxList.sort((o1, o2) -> o1.compareTo(o2));
            minList.sort((o1, o2) -> o1.compareTo(o2));
            
            String maxStr = maxList.stream().collect(Collectors.joining());
            String minStr = minList.stream().collect(Collectors.joining());
            
            sb.append(minStr + " ")
                .append(min + " ")
                .append(maxStr + " ")
                .append(max)
                .append('\n');
            
        }

        System.out.println(sb.toString());
        
    }
}