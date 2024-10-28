import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<String> shorcuts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        shorcuts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String option = br.readLine();

            String[] str = option.split(" ");

            // 1. 왼쪽에서 오른쪽으로 단어의 첫글자가 단축키로 지정되었는지 확인
            int idx1 = checkStep1(str);
            if(idx1 > -1) {
                for(int j = 0; j < str.length; j++) {
                    for(int k = 0; k < str[j].length(); k++) {
                        String s = str[j].charAt(k) + "";
                        if(j == idx1 && k == 0) {
                            sb.append("[").append(s).append("]");
                        } else {
                            sb.append(s);
                        }
                    }
                    sb.append(" ");
                }
                sb.append('\n');
                continue;
            }

            // 2. 왼쪽에서부터 알파벳을 확인하여 단축키로 지정되었는지 확인
            int idx2 = checkStep2(option);
            if(idx2 > -1) {
                for(int j = 0; j < option.length(); j++) {
                    String s = option.charAt(j) + "";
                    if(j == idx2) {
                        sb.append("[").append(s).append("]");
                    } else {
                        sb.append(s);
                    }
                }
                sb.append('\n');
                continue;
            }

            // 3. 어떠한 것도 단축키로 지정할 수 없는 경우
            sb.append(option).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int checkStep1(String[] str) {
        int idx = -1;
        for(int i = 0; i < str.length; i++) {
            String s = str[i].substring(0, 1);
            if(!shorcuts.contains(s.toUpperCase())) {
                shorcuts.add(s.toUpperCase());
                idx = i;
                break;
            }
        }

        return idx;
    }

    private static int checkStep2(String word) {
        int idx = -1;
        for(int i = 0; i < word.length(); i++) {
            String s = word.charAt(i) + "";
            if(s.equals(" ")) continue;
            if(!shorcuts.contains(s.toUpperCase())) {
                shorcuts.add(s.toUpperCase());
                idx = i;
                break;
            }
        }

        return idx;
    }

}