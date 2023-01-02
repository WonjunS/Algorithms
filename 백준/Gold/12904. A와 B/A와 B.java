import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(T.length() > S.length()) {
            StringBuffer sb = new StringBuffer();
            if(T.endsWith("A")) {
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, T.length() - 1);
                T = sb.append(T).reverse().toString();
            }
        }

        if(T.equals(S)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}