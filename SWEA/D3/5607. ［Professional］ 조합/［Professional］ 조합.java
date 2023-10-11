import java.io.*;
import java.util.*;

public class Solution {
	private static final int MOD = 1234567891;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, R;
		for(int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long[] fac = new long[N + 1];
			fac[0] = 1;
			for(int i = 1; i <= N; ++i) {
				fac[i] = (fac[i - 1] * i) % MOD;
			}
			long bottom = (fac[R] * fac[N - R]) % MOD;
			bottom = cal(bottom, MOD - 2);
			long ans = (fac[N] * bottom) % MOD;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);

	}
	private static long cal(long bottom, int num) {
		if(num == 0) {
			return 1;
		}
		long tmp = cal(bottom, num / 2);
		long res = tmp * tmp % MOD;
		if(num % 2 == 0)
			return res;
		else
			return (res * bottom) % MOD;
	}
}