import java.io.*;
import java.util.*;
public class Solution {
	static class Cell implements Comparable<Cell>{
		int x, y, life, time;

		public Cell(int x, int y, int life, int time) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.time = time;
		}

		@Override
		public int compareTo(Cell o) {
			return -Integer.compare(this.life, o.life);
		}
		
	}
	static int N, M, K;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Cell> q;
	static Queue<Cell> que;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			map = new int[351][351];
			visited = new boolean[351][351];
			q = new PriorityQueue<Cell>();
			que = new LinkedList<Cell>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; ++j) {
					map[150 + i][150 + j] = Integer.parseInt(st.nextToken());
					if(map[150 + i][150 + j] != 0) {
						q.offer(new Cell(150 + i, 150 + j, map[150 + i][150 + j], map[150+i][150+j]*2));
						visited[150 + i][150 + j] = true;
					}
				}
			}
			bfs();
			sb.append("#" + tc + " " + q.size() + "\n");
		}
		System.out.print(sb.toString());
	}
	private static void bfs() {
		for(int time = 1; time <= K; ++time) {
			while(!q.isEmpty()) {
				Cell tmp = q.poll();
				tmp.time = tmp.time - 1;
				if(tmp.life > tmp.time) { //활성화
					for(int i = 0; i < 4; ++i) {
						int nx = tmp.x + dx[i];
						int ny = tmp.y + dy[i];
						
						if(!visited[nx][ny]) {
							visited[nx][ny] = true;
							que.offer(new Cell(nx, ny, tmp.life, tmp.life*2));
						}
					}
				}
				if(tmp.time != 0)
					que.offer(new Cell(tmp.x, tmp.y, tmp.life, tmp.time));
			}
			while(!que.isEmpty())
				q.offer(que.poll());
		}
	}

}