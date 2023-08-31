import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int x, y, k, cnt;

		public Node(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
		
	}
	static int K, R, C, ans;
	static boolean[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {0, -1, 0, 1, -1, -2, -2, -1, 1, 2, 2, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		visited = new boolean[R][C][K + 1];
		for(int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; ++j) {
				if(Integer.parseInt(st.nextToken()) == 1)
					map[i][j] = true;
			}
		}
		if(R == 1) {
			System.out.println(C - 1);
			return;
		}else if(C == 1) {
			System.out.println(R - 1);
			return;
		}
		System.out.println(bfs());

	}
	private static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int nx, ny;
			for(int i = 0; i < 4; ++i) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				if(nx == R - 1 && ny == C - 1) {
					return cur.cnt + 1;
				}
				if(nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				if(map[nx][ny] || visited[nx][ny][cur.k])
					continue;
				visited[nx][ny][cur.k] = true;
				q.offer(new Node(nx, ny, cur.k, cur.cnt+1));
			}
			if(cur.k < K) {
				for(int i = 4; i < 12; ++i) {
					nx = cur.x + dx[i];
					ny = cur.y + dy[i];
					if(nx == R - 1 && ny == C - 1) {
						return cur.cnt + 1;
					}
					if(nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;
					if(map[nx][ny] || visited[nx][ny][cur.k + 1])
						continue;
					visited[nx][ny][cur.k + 1] = true;
					q.offer(new Node(nx, ny, cur.k + 1, cur.cnt + 1));
				}
			}
		}
		return -1;
	}
}