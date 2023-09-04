import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] time = new int[N];
		int[] dp = new int[N];
		ArrayList<Integer>[] list = new ArrayList[N];
		int[] degree = new int[N];
		for (int i = 0; i < N; ++i)
			list[i] = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; ++j) {
				list[Integer.parseInt(st.nextToken()) - 1].add(i);
				++degree[i];
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; ++i) {
			if (degree[i] == 0) {
				q.offer(i);
				dp[i] = time[i];
				ans = Math.max(dp[i], ans);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int tmp : list[cur]) {
				dp[tmp] = Math.max(dp[tmp], dp[cur] + time[tmp]);
				ans = Math.max(ans, dp[tmp]);
				if (--degree[tmp] == 0) {
					q.offer(tmp);
				}
			}
		}
		bw.write(ans + "\n");
		bw.flush();
	}

}