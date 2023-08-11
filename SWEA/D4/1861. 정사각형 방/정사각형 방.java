import java.util.*;
import java.io.*;

public class Solution {
	static int n;
	static int ans, max;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; ++tc) {
			ans = Integer.MAX_VALUE;
			max = 1;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			dp = new int[n][n];
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					dfs(i,j);					
				}
			}
			sb.append("#"+(tc+1)+" "+ans+" "+max+"\n");
		}
		System.out.println(sb.toString());

	}
	private static int dfs(int x, int y) {
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		dp[x][y] = 1;
		int nx, ny;
		for(int i = 0; i < 4; ++i) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >=0 && nx < n && ny >= 0 && ny < n && map[x][y] + 1 == map[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
				if(max < dp[x][y]) {
					max = dp[x][y];
					ans = map[x][y];
				}else if(max == dp[x][y] && ans > map[x][y]) {
					ans = map[x][y];
				}
				break;
			}
		}
		return dp[x][y];
	}

}