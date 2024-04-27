import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            String s = sc.next();
            words[i] = s;
        }

        Arrays.sort(words);

        List<String> list = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            if(check(curr, next)) list.add(curr);
        }

        int answer = N - list.size();

        sc.close();

        System.out.println(answer);
    }

    private static boolean check(String s1, String s2) {
        int max = Math.min(s1.length(), s2.length());


        for(int i = 0; i < max; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }

}