import java.util.*;
import java.io.*;

public class Main {
    
    private static int[][][] w;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        w = new int[101][101][101];
        for(int i = 0; i <= 50; i++) {
            for(int j = 0; j <= 100; j++) {
                for(int k = 0; k <= 100; k++) {
                    w[i][j][k] = 1;
                }
            }
        }
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 50; j++) {
                for(int k = 0; k <= 100; k++) {
                    w[i][j][k] = 1;
                }
            }
        }
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                for(int k = 0; k <= 50; k++) {
                    w[i][j][k] = 1;
                }
            }
        }
        
        for(int i = 51; i <= 100; i++) {
            for(int j = i + 1; j <= 100; j++) {
                for(int k = j + 1; k <= 100; k++) {
                    w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] - w[i][j - 1][k];
                }
            }
        }
        
        for(int i = 51; i <= 100; i++) {
            for(int j = 51; j <= 100; j++) {
                for(int k = 51; k <= 100; k++) {
                    if(w[i][j][k] != 0) continue;
                    w[i][j][k] = 
                        w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i - 1][j][k - 1] - w[i - 1][j - 1][k - 1];
                }
            }
        }

        for(int i = 71; i <= 100; i++) {
            for(int j = 51; j <= 100; j++) {{
                for(int k = 51; k <= 100; k++) {
                    w[i][j][k] = w[70][70][70];
                }
            }}
        }

        for(int i = 51; i <= 100; i++) {
            for(int j = 71; j <= 100; j++) {{
                for(int k = 51; k <= 100; k++) {
                    w[i][j][k] = w[70][70][70];
                }
            }}
        }

        for(int i = 51; i <= 100; i++) {
            for(int j = 51; j <= 100; j++) {{
                for(int k = 71; k <= 100; k++) {
                    w[i][j][k] = w[70][70][70];
                }
            }}
        }
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == -1 && b == -1 && c == -1) {
                break;
            }
            
            int result = w[a + 50][b + 50][c + 50];
            
            String msg = "w(" + a + ", " + b + ", " + c + ") = " + result;
            sb.append(msg).append('\n');
        }
        
        System.out.println(sb.toString());
    }

}