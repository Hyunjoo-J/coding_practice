import java.io.*;
import java.util.*;

public class Solution {
	static class Cell {
		int x, y, active, life, time;

		public Cell(int x, int y, int active, int life, int time) {
			this.x = x;
			this.y = y;
			this.active = active;
			this.life = life; // 생명 주기
			this.time = time; // cell이 활성화 비활성화 상태에서 얼마나 지났는지
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N, M, K;
	static int[][] map, time;
	static Deque<Cell> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			map = new int[351][351];
			time = new int[351][351];
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			q = new ArrayDeque<Cell>();
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					map[150 + i][150 + j] = Integer.parseInt(st.nextToken());
					if (map[150 + i][150 + j] != 0)
						q.offer(new Cell(150 + i, 150 + j, -1, map[150 + i][150 + j], 0));
				}
			}
			for (int i = 0; i < K; ++i)
				bfs(i);
			int cnt = 0;
			while (!q.isEmpty()) {
				Cell tmp = q.poll();
				if (tmp.life == map[tmp.x][tmp.y])
					++cnt;
			}
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.print(sb.toString());
	}

	private static void bfs(int now) {
		int size = q.size();
		for (int i = 0; i < size; ++i) {
			Cell tmp = q.poll();
			int next = tmp.time + 1;
			if (tmp.life != map[tmp.x][tmp.y])
				continue;
			if (tmp.active == 1 && tmp.time == 0) {
				for (int d = 0; d < 4; ++d) {
					int nx = tmp.x + dx[d];
					int ny = tmp.y + dy[d];

					if (map[nx][ny] != 0) { // 이미 map에 무언가 심어져 있음
						if (time[nx][ny] < now) // 이전에 심어진 것
							continue;
						else if (time[nx][ny] == now) {
							if (map[nx][ny] < tmp.life) {
								map[nx][ny] = tmp.life;
								q.offer(new Cell(nx, ny, -1, tmp.life, 0));
							}
						}
					} else {
						map[nx][ny] = tmp.life;
						time[nx][ny] = now;
						q.offer(new Cell(nx, ny, -1, tmp.life, 0));
					}
				}
			}
			if (next == tmp.life) { // 활성화하거나 죽이거나
				if (tmp.active == -1) {
					next = 0;
					q.offer(new Cell(tmp.x, tmp.y, 1, tmp.life, next)); // 0부터 life초까지 주위 번식
				}
			} else {
				q.offer(new Cell(tmp.x, tmp.y, tmp.active, tmp.life, next));
			}
		}
	}
}