import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        int m, k, n;
        int arr[] = new int[51];
        double p[] = new double[51];
        double ans;
        n = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            n += arr[i];
        }
        st = new StringTokenizer(bf.readLine());
        k = Integer.parseInt(st.nextToken());
        ans = 0.0;
        for (int i = 0; i < m; i++){
            if (arr[i] >= k){
                p[i] = 1.0;
                for (int j = 0; j < k; j++){
                    p[i] *= (double)(arr[i] - j) / (n - j);
                }
                ans += p[i];
            }
        }
        System.out.println(ans);
    }
}