import java.util.*;

public class Main {
    
    static int N, ans;
    static int[] arr;
    
    static void input() {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }
    
    static void pro() {
        Arrays.sort(arr);
        
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
            ans += sum;
        }
        
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        input();
        pro();
    }
}