import java.util.*;
import java.io.*;

public class Main {
    
    private static int numOfSwitches, numOfStudents;
    private static int[] switches;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        numOfSwitches = Integer.parseInt(br.readLine());

        switches = new int[numOfSwitches + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= numOfSwitches; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        numOfStudents = Integer.parseInt(br.readLine());
        for(int i = 0; i < numOfStudents; i++) {
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for(int j = k; j <= numOfSwitches; j += k) {
                    switches[j] = (switches[j] == 0) ? 1 : 0;
                }
            } else {
                checkSymmetric(k);
            }
        }

        String answer = "";
        for(int i = 1; i <= numOfSwitches; i++) {
            if(i != 1 && (i - 1) % 20 == 0) answer = answer + "\n";
            answer = answer + switches[i] + " ";
        }

        System.out.println(answer);
    }

    private static void checkSymmetric(int k) {
        int left = k;
        int right = k;
        while(true) {
            if(left < 1 || right > numOfSwitches) break;

            if(switches[left] == switches[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }

        for(int i = left + 1; i < right; i++) {
            switches[i] = (switches[i] == 0) ? 1 : 0;
        }
    }

}