import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; ++i)
            arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (p == 1) {
                for (int j = num; j <= n; j += num) {
                    arr[j] = 1 - arr[j];
                }
            } else {
                arr[num] = 1 - arr[num];
                for (int j = 0; num + j <= n && num - j >= 1 && arr[num + j] == arr[num - j]; j++) {
                    arr[num + j] = 1 - arr[num + j];
                    arr[num - j] = 1 - arr[num - j];

                }
            }
        }
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if(i%20==0)
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}