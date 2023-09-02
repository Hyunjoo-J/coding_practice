import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static long[][][] dp;
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10][1024]; //숫자길이, 마지막으로 사용된 숫자, 0~9까지 모든 수를 사용했는지 확인 2^10
        for(int i = 1; i <= 9; ++i){
            dp[1][i][1 << i] = 1;
        }
        for(int i = 2; i <= N; ++i){
            for(int j = 0; j <= 9; ++j){
                for(int k = 0; k < 1024; ++k){
                    int next = k | 1 << j; //지금까지 쓴 숫자들 | 이번에 쓸 숫자(j : 마지막 자릿수)
                    if(j == 0)
                        dp[i][j][next] += dp[i - 1][j + 1][k] % MOD; //하나 작은 자리수의 마지막 숫자는 1일 때를 더함
                    else if(j == 9)
                        dp[i][j][next] += dp[i - 1][j - 1][k] % MOD;
                    else{
                        dp[i][j][next] += dp[i - 1][j - 1][k] % MOD + dp[i - 1][j + 1][k] % MOD;
                    }
                    dp[i][j][next] %= MOD;
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < 10; ++i){
            ans += dp[N][i][1023] % MOD; //비트의 모든 카운트가 1 => 0~9까지 다 사용
            ans %= MOD;
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}