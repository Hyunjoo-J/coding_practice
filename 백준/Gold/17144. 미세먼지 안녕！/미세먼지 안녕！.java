import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T;
	static int air_r, air_c;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air_r = i;
					air_c = j;
				}
			}
		}
		while(T-- > 0) {
			map = spread(map);
			run();
		}
		int sum = 0;
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				sum += map[i][j];
			}
		}
		System.out.println(sum + 2);

	}
	private static void run() {
		int r = air_r - 1;
		int c = air_c;
		int d = 3;
		int cur = map[r][c];
		int next;
		while(true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= air_r || nc >= C) {
				d = ((d + 1) % 4);
				continue;
			}
			next = map[nr][nc];
			map[nr][nc] = cur;
			cur = next;
			r = nr;
			c = nc;
			if(r == air_r - 1 && c == air_c)
				break;
		}
		map[air_r - 1][air_c] = -1;
		d = 3;
		r = air_r;
		c = air_c;
		while(true) {
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < air_r || nc < 0 || nr >= R || nc >= C) {
				--d;
				continue;
			}
			next = map[nr][nc];
			map[nr][nc] = cur;
			cur = next;
			r = nr;
			c = nc;
			if(r == air_r && c == air_c)
				break;
		}
		map[air_r][air_c] = -1;		
	}
	
	private static int[][] spread(int[][] map) {
		int[][] copy = new int[R][C];
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				if(map[i][j] == -1 || map[i][j] == 0)
					continue;
				int s = map[i][j] / 5;
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					if(map[nr][nc] == -1)
						continue;
					copy[nr][nc] += s;
					map[i][j] -= s;
				}
				copy[i][j] += map[i][j];
			}
		}
		return copy;
	}
}