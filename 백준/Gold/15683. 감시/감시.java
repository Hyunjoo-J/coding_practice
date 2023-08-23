import java.util.*;
import java.io.*;
public class Main {
	static class Camera{
		int x, y, num;

		public Camera(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
	static int N, M, cnt, min;
	static int[][] map; 
	static Camera[] cctv = new Camera[8];
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][][] mode = {{{0}}, {{0},{1},{2},{3}},{{0,2},{1,3}},
			{{0,1}, {1,2},{2,3}, {3,0}},
			{{0,1,2},{0,1,3},{0,2,3},{1,2,3}},{{0,1,2,3}}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctv[cnt++] = new Camera(i, j, map[i][j]);
				}
			}
		}
		min = N * M;
		combi(0, map);
		System.out.println(min);

	}
	private static void combi(int sel, int[][] copy) {
		if(sel == cnt) {
			min = Math.min(min, calzero(copy));
			return;
		}
		int x = cctv[sel].x;
		int y = cctv[sel].y;
		int num = cctv[sel].num;
		int tmp1 = mode[num].length;
		for(int i = 0; i < tmp1; ++i) {
			int[][] copymap = new int[N][M];
			for(int j = 0; j < N; ++j) {
				copymap[j] = copy[j].clone();
			}
			int tmp2 = mode[num][i].length;
			for(int j = 0; j < tmp2; ++j) {
				int dir = mode[num][i][j];
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				while(true) {
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
						break;
					}
					if(copymap[nx][ny] == 6)
						break;
					copymap[nx][ny] = -1;
					nx += dx[dir];
					ny += dy[dir];
				}
				
			}
			combi(sel + 1,  copymap);
		}
	}
	private static int calzero(int[][] copy) {
		int sum = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(copy[i][j] == 0)
					++sum;
			}
		}
		return sum;
	}

}