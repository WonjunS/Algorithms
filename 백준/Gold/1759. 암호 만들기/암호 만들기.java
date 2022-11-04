import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static int M, N;
    static char[] chars;
    static int[] selected;
    
    static void rec_func(int k) {
        if (k == M + 1) {
            int vowel = 0, consonant = 0;
            for (int i = 1; i <= M; i++) {
                if (isVowel(chars[selected[i]])) vowel++;
                else consonant++;
            }
            if (vowel >= 1 && consonant >= 2) {
                for (int i = 1; i <= M; i++) sb.append(chars[selected[i]]);
                sb.append('\n');
            }
        } else {
            for (int cand = selected[k - 1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }
    
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        
        chars = new char[N + 1];
        selected = new int[M + 1];
        for(int i = 1; i <= N; i++) {
            String s = sc.next();
            chars[i] = s.charAt(0);
        }
        
        Arrays.sort(chars, 1, N + 1);
        
        rec_func(1);
        
        System.out.println(sb.toString());
    }
}