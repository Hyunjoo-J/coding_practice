import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[][] matrix;
	static int small, tall;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int u, v;
		matrix = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			matrix[u][v] = true;
		}
		int ans = 0;
		for (int i = 1; i <= N; ++i) {
			small = tall = 0;
			findS(i);
			findT(i);
			if (small + tall + 1 == N)
				++ans;
		}
		System.out.println(ans);

	}

	private static void findT(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		q.add(cur);
		visited[cur] = true;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 1; i <= N; ++i) {
				if (visited[i] || matrix[cur][i] == false)
					continue;
				++tall;
				q.add(i);
				visited[i] = true;
			}
		}
	}

	private static void findS(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		q.add(cur);
		visited[cur] = true;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 1; i <= N; ++i) {
				if (visited[i] || matrix[i][cur] == false)
					continue;
				++small;
				q.add(i);
				visited[i] = true;
			}
		}
	}
}