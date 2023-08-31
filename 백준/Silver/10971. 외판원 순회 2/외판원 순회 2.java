import java.util.*;
import java.io.*;

//결국 원점으로 돌아와야 되기 때문에 어느 도시에서 출발해도 결과는 같다
public class Main {
	static int N;
	static long ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N]; // 각각의 도시를 방문했는가
		visited[0] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	private static void dfs(int city, long dist, int cnt) {
		if (cnt == N) {
			if (map[city][0] != 0)
				ans = Math.min(ans, dist + map[city][0]);
			return;
		}
		for (int i = 1; i < N; ++i) {
			if (visited[i] || map[city][i] == 0)
				continue;
			visited[i] = true;
			dfs(i, dist + map[city][i], cnt + 1);
			visited[i] = false;
		}
	}

}