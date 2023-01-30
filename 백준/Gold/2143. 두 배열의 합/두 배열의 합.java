import java.util.*;
import java.io.*;

public class Main {

    static int T, N, M;
    static int[] A, B;
    static ArrayList<Integer> listA, listB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        listA = new ArrayList<>();
        listB = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum += A[j];
                listA.add(sum);
            }
        }

        for(int i = 0; i < M; i++) {
            int sum = 0;
            for(int j = i; j < M; j++) {
                sum += B[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        System.out.println(getCount());
    }

    static long getCount() {
        int left = 0, right = listB.size() - 1;
        long count = 0;

        while(left < listA.size() && right >= 0) {
            long sum = listA.get(left) + listB.get(right);

            if(sum == T) {
                int a = listA.get(left);
                int b = listB.get(right);
                long aCnt = 0, bCnt = 0;

                while(left < listA.size() && listA.get(left) == a) {
                    left++;
                    aCnt++;
                }
                while(right >= 0 && listB.get(right) == b) {
                    right--;
                    bCnt++;
                }

                count += aCnt * bCnt;
            } else if(sum < T) {
                left++;
            } else if(sum > T) {
                right--;
            }
        }

        return count;
    }
}