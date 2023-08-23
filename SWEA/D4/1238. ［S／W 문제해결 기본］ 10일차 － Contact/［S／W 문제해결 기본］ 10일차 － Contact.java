import java.util.*;
import java.io.*;

public class Solution {
	static int L, S;
	static boolean[][] link;
	static boolean[] visited;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; ++tc) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken()) / 2;
			S = Integer.parseInt(st.nextToken());
			link = new boolean[101][101];
			visited = new boolean[101];
			q = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L; ++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				link[from][to] = true;
			}
			int max = bfs(S);
			sb.append("#"+tc+" "+max+"\n");
		}
		System.out.print(sb.toString());
	}

	private static int bfs(int s) {
		q.offer(s);
		visited[s] = true;
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			int size = q.size();
			max = 0;
			for (int i = 0; i < size; ++i) {
				int cur = q.poll();
				for (int j = 1; j < 101; ++j) {
					if (link[cur][j] && !visited[j]) {
						q.offer(j);
						visited[j] = true;
						max = Math.max(max, j);
					}
				}
			}
			list.add(max);
		}
		return list.get(list.size() - 2);
	}

}