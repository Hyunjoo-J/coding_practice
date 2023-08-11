import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(ans);
	}
	private static void dfs(int x, int y, int dir) {
		if(x == n - 1  && y == n - 1) {
			ans++;
			return;
		}
		if(dir != 1 && y + 1 < n && arr[x][y + 1] == 0) {
			dfs(x, y + 1, 0);
		}
		if(dir != 0 && x + 1 < n && arr[x + 1][y] == 0) {
			dfs(x + 1, y, 1);
		}
		if(x + 1 < n && y + 1 < n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}
	}
}