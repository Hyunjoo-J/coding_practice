import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[][] arr = new int[101][101];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = x; j < x+10;j++){
                for(int k = y; k < y + 10; k++){
                    if(arr[j][k] == 0) {
                        ++arr[j][k];
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}