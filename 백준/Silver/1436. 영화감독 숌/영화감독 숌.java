import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int idx = 1;
        int num = 666;
        while(idx != N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                idx++;
            }
        }
        System.out.println(num);
    }
}