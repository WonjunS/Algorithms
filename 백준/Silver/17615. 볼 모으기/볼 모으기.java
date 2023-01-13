import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String str = sc.next();
        
        char last = str.charAt(str.length() - 1);
        int idx = str.length() - 1;
        while(idx >= 0) {
            if(str.charAt(idx) == last) idx--;
            else break;
        }
        
        int red = 0, blue = 0;
        for(int i = 0; i <= idx; i++) {
            if(str.charAt(i) == 'R') red++;
            else blue++;
        }
        
        int answer = Math.min(blue, red);
        
        System.out.println(answer);
    }
}