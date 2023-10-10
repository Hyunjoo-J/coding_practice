import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			st = new StringTokenizer(br.readLine());
			int max = 0;
			for(int i = 0; i < N; ++i) {
				int t = Integer.parseInt(st.nextToken());
				tree[i] = t;
				max = Math.max(max, t);
			}
			int even = 0, odd = 0;
			for(int i = 0; i < N; ++i) {
				int diff = max - tree[i];
				even += diff / 2;
				odd += diff % 2;
			}
			int ans = 0;
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even -= 1;
					odd += 2;
				}
			}
			if(odd > even) {
				ans = odd * 2 -1;
			}else if(odd < even) {
				ans = even * 2;
			}else {
				ans = even + odd;
			}
			sb.append("#"+tc+" "+ ans + "\n");
		}
		System.out.println(sb.toString());
	}

}