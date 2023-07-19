import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 3];
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++){
            if(i % 6 == 0)
                dp[i] = Math.min(dp[i/2], Math.min(dp[i/3], dp[i/2])) + 1;
            else if (i % 2 == 0)
                dp[i] = Math.min(dp[i/2], dp[i - 1]) + 1;
            else if (i % 3 == 0)
                dp[i] = Math.min(dp[i/3], dp[i - 1]) + 1;
            else
                dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[n]);
        
    }
}