import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int max;
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
	static int[][] player;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		player = new int[N][9];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; ++j) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		do {
			baseball();
		} while (np(arr));
		System.out.println(max);
	}

	private static boolean np(int[] p) {
		int i = 7;
		while (i > 0 && p[i - 1] > p[i])
			--i;
		if (i == 0)
			return false;
		int j = 7;
		while (p[i - 1] > p[j])
			--j;
		swap(p, i - 1, j);
		int k = 7;
		while (i < k)
			swap(p, i++, k--);
		return true;
	}

	private static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}

	private static void baseball() {
		int[] turn = new int[9];
		int tmp = 0;
		for (int i = 0; i < 9; ++i) {
			if (i == 3)
				continue;
			turn[i] = arr[tmp];
			tmp++;
		}
		tmp = 0;
		int score = 0;
		for (int i = 0; i < N; ++i) {
			int[] base = new int[3];
			int out = 0;
			while (out < 3) {
				int idx = turn[tmp];
				tmp = (tmp + 1) % 9;
				if (player[i][idx] == 4) {
					++score;
					for (int k = 0; k < 3; ++k) {
						if (base[k] == 1)
							++score;
						base[k] = 0;
					}
					continue;
				}
				if (player[i][idx] == 0) {
					++out;
					continue;
				}
				for (int j = 2; j >= 0; --j) {
					if (j + player[i][idx] > 2) {
						if (base[j] == 1) {
							base[j] = 0;
							++score;
						}
					} else {
						base[j + player[i][idx]] = base[j];
						base[j] = 0;
					}
				}
				base[player[i][idx] - 1] = 1;
			}

		}
		max = Math.max(max, score);

	}

}