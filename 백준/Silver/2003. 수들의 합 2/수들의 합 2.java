import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[N];
        for(int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(find(a, M));
    }
    
    public static int find(int[] a, int M) {
        int count = 0;
        int sum = 0;
        for(int i=0; i<a.length; i++) {
            for(int j=i; j<a.length; j++) {
                sum += a[j];
                if(sum == M) {
                    count++;
                    break;
                } else if(sum > M) {
                    break;
                } else {
                    continue;
                }
            }
            sum = 0;
        }
        return count;
    }
}