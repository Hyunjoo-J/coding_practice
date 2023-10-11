import java.util.*;
import java.io.*;

public class Main {
	private static final int MOD = 10007;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] fac = new long[N + 1];
		fac[0] = 1;
		for(int i = 1; i <= N; ++i)
			fac[i] = fac[i - 1] * i % MOD;
		long bottom = (fac[K] * fac[N - K]) % MOD;
		bottom = cal(bottom, MOD - 2);
		long ans = (fac[N] * bottom) % MOD;
		System.out.println(ans);
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