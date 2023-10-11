import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N, x, y;
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			int[] dist = new int[N];
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				dist[i] = Math.abs(x) + Math.abs(y);
			}
			int max = dist[0];
			for (int i = 1; i < N; i++) {
				if (dist[i] % 2 != dist[i - 1] % 2) {
					max = -1;
					break;
				} else {
					max = Math.max(dist[i], max);
				}
			}
			int ans = 0;
			if(max != -1) {
				long sum = 0;
				while(true) {
					sum += ans;
					if(sum >= max && (sum - max) % 2 == 0) {
						break;
					}
					++ans;
				}
				
			}else {
				ans = -1;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}