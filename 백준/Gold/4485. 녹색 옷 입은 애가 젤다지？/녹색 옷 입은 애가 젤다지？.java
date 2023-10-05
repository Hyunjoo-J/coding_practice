import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int x, y, w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		map = new int[125][125];
		dist = new int[125][125];
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; ++i)
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			dijkstra();
			sb.append("Problem "+tc+": "+dist[N - 1][N - 1]+"\n");
			++tc;
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		dist[0][0] = map[0][0];
		pq.add(new Node(0, 0, map[0][0]));
		visited[0][0] = true;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int cost;
			for(int i = 0; i < 4; ++i) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if(visited[nx][ny])
					continue;
				cost = tmp.w + map[nx][ny];
				if(dist[nx][ny] > cost) {
					dist[nx][ny] = cost;
					visited[nx][ny] = true;
					pq.add(new Node(nx, ny, cost));
				}
			}
		}	
	}

}