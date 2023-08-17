import java.util.*;
import java.io.*;

public class Solution {
	static int n, k, ans;
	static int[][] map = new int[8][8];
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			int max = 0;
			ans = 0;
			visited = new boolean[8][8];
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(map[i][j] == max) {
						dfs(i,j,1,false);
						visited[i][j] = false;
					}
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());

	}
	private static void dfs(int x, int y, int len, boolean cut) {
		visited[x][y] = true;
		ans = Math.max(ans, len);
		int nx, ny;
		for(int i = 0; i < 4; ++i) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if(visited[nx][ny])
				continue;
			if(map[nx][ny] < map[x][y]) {
				dfs(nx, ny,len+1, cut);
				visited[nx][ny] = false;
			}
			else if(map[nx][ny] - k < map[x][y] && cut == false) {
				int tmp = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				dfs(nx, ny, len+1, true);
				map[nx][ny] = tmp;
				visited[nx][ny] = false;
			}
		}
		
	}

}