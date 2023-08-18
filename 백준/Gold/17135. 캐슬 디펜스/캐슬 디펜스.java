import java.util.*;
import java.io.*;

public class Main {
	static int n, m, d;
	static int enemy, ans;
	static int[][] map;
	static int[] bow = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(0, 0);
		System.out.println(ans);
	}

	private static void combi(int cnt, int start) {
		if (cnt == 3) {
			int[][] tmp = new int[n][m];
			for(int i = 0; i < n; ++i) {
				tmp[i] = map[i].clone();
			}
			ans = Math.max(ans, attack(tmp));
			return;
		}
		for (int i = start; i < m; ++i) {
			bow[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	private static int attack(int[][] map) {
		int sum = 0;
		int[][] info = new int[3][3];
		for (int turn = 0; turn < n; ++turn) {
			info[0][0] = -1;
			info[1][0] = -1;
			info[2][0] = -1;
			info[0][2] = Integer.MAX_VALUE;
			info[1][2] = Integer.MAX_VALUE;
			info[2][2] = Integer.MAX_VALUE;
			for (int i = 0; i < n - turn; ++i) {
				for (int j = 0; j < m; ++j) {
					if (map[i][j] == 1) {
						for (int k = 0; k < 3; ++k) {
							int dis = Math.abs((n - turn) - i) + Math.abs(bow[k] - j);
							if (dis <= d) {
								if (dis < info[k][2]) {
									info[k][0] = i;
									info[k][1] = j;
									info[k][2] = dis;
								}else if(dis == info[k][2] && j < info[k][1]) {
									info[k][0] = i;
									info[k][1] = j;
								}
							}
						}
					}
				}
			}
			for(int k = 0; k < 3; ++k) {
				if(info[k][0] != -1 && map[info[k][0]][info[k][1]] == 1) {
					map[info[k][0]][info[k][1]] = 0;
					++sum;
				}	
			}
		}
		return sum;
	}

}