import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static int count = 0;
    static int N = 15;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        do {
        	N = Integer.parseInt(br.readLine());
        } while(N < 1);
        set(0);
        System.out.println(count);
    }
    
    static int[] pos = new int[N];
    static boolean[] flag_a = new boolean[N];
    static boolean[] flag_b = new boolean[(2 * N) - 1];
    static boolean[] flag_c = new boolean[(2 * N) - 1];
    
    public static void set(int i) {
        for(int j=0; j<N; j++) {
            if(flag_a[j] == false &&
              flag_b[i + j] == false &&
              flag_c[i - j + (N - 1)] == false) {
            	pos[i] = j;
            	if(i == (N - 1))
            		count++;
            	else {
            		flag_a[j] = flag_b[i + j] = flag_c[i - j + (N - 1)] = true;
            		set(i + 1);
            		flag_a[j] = flag_b[i + j] = flag_c[i - j + (N - 1)] = false;
            	}
            }
        }
    }
}