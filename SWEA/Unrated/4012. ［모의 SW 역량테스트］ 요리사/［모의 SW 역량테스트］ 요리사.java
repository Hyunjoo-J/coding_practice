import java.util.*;
import java.io.*;

class Solution {
	static boolean[] team;
	static int n, size, min;
	static int[][] food = new int[16][16];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			size = n / 2;
			team = new boolean[n];
			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			team[0] = true;
			combi(0, 1);
			sb.append("#"+test_case+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int start) {
		if(min == 0)
			return;
		if (cnt == size - 1) {
			int syn = synergy();
			min = Math.min(min, syn);
			return;
		}
		for (int i = start; i < n; ++i) {
			team[i] = true;
			combi(cnt + 1, i + 1);
			team[i] = false;
		}
	}

	private static int synergy() {
		int team1 = 0, team2 = 0;
		for (int i = 0; i < n - 1; i++) {
			if (team[i]) {
				for (int j = i + 1; j < n; j++) {
					if (team[j]) {
						team1 += food[i][j];
						team1 += food[j][i];
					}
				}
			}else {
				for(int j = i + 1; j < n; j++) {
					if(team[j] == false) {
						team2 += food[i][j];
						team2 += food[j][i];
					}
				}
			}
		}
		return Math.abs(team1-team2);
	}
}