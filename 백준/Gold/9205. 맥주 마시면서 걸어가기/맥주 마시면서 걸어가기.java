import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N;
	static final int MAX = Integer.MAX_VALUE >> 2;
	static Pair[] map;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new Pair[N + 2];
			for (int i = 0; i < N + 2; ++i) {
				st = new StringTokenizer(br.readLine());
				map[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			dist = new int[N + 2][N + 2];
			for(int i = 0; i < N + 1; ++i) {
				for(int j = i + 1; j < N + 2; ++j) {
					dist[i][j] = dist[j][i] = MAX;
					int d = Math.abs(map[i].y - map[j].y) + Math.abs(map[i].x - map[j].x);
					if(d <= 1000)
						dist[i][j] = dist[j][i] = 1;
				}
			}
			for(int k = 0; k < N + 2; ++k) {
				for(int i = 0; i < N + 2; ++i) {
					for(int j = 0; j < N + 2; ++j) {
						if(dist[i][j] > dist[i][k] + dist[k][j]) {
	                        dist[i][j] = dist[i][k] + dist[k][j];
	                    }
					}
				}
			}
			if(dist[0][N + 1] > 0 && dist[0][N + 1] < MAX)
				sb.append("happy\n");
			else{
				sb.append("sad\n");
			}
		}
		System.out.print(sb);
	}
}