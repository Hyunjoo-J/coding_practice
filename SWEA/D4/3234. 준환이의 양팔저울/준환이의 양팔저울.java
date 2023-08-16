import java.io.*;
import java.util.*;

public class Solution {
	static int n, ans;
	static int[] weight = new int[9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			ans = 0;
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight, 0, n);
			do {
				dfs(0, 0, 0);
			}while(np(weight));
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
	}
	private static void dfs(int num, int lsum, int rsum) {
		if(num == n) {
			++ans;
			return;
		}
		dfs(num + 1, lsum + weight[num], rsum);
		if (lsum >= rsum + weight[num]) {
			dfs(num + 1, lsum, rsum+weight[num]);
		}
	}
	private static boolean np(int[] p) {
		int len = n;
		int i = len - 1;
		while (i > 0 && p[i - 1] >= p[i]) --i;
		if(i == 0)
			return false;
		int j = len - 1;
		while(p[i - 1] >= p[j]) --j;
		swap(p, i - 1, j);
		int k = len - 1;
		while(i < k)
			swap(p, i++, k--);
		return true;
	}
	private static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;

	}

}