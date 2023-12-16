import java.util.*;
import java.io.*;

public class Main {
    
    private static List<String> vowels;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] arr = {"a", "e", "i", "o", "u"};
        vowels = Arrays.asList(arr);

        while(true) {
            int vowel = 0; // 모음
            int consonant = 0; // 자음
            String prev = "";
            
            String password = br.readLine();
            
            if(password.equals("end")) break;
            
            if(!rule1(password)) {
                sb.append("<" + password + "> is not acceptable.");
                sb.append('\n');
                continue;
            }

            boolean acceptable = true;
            
            for(int i = 0; i < password.length(); i++) {
                String s = password.substring(i, i + 1);
                
                if(vowels.contains(s)) {
                    vowel++;
                    consonant = 0;
                } else {
                    consonant++;
                    vowel = 0;
                }
                
                if(vowel == 3 || consonant == 3) {
                    acceptable = false;
                    break;
                }

                if(prev.equals(s)) {
                    if(!s.equals("e") && !s.equals("o")) {
                        acceptable = false;
                        break;
                    }
                }
                
                prev = s;
            }

            if(acceptable) {
                sb.append("<" + password + "> is acceptable.");
                sb.append('\n');
            } else {
                sb.append("<" + password + "> is not acceptable.");
                sb.append('\n');
            }
        }
        
        System.out.println(sb.toString());
    }
    
    private static boolean rule1(String password) {
        for(String s : vowels) {
            if(password.contains(s)) {
                return true;
            }
        }
        
        return false;
    }
    
}