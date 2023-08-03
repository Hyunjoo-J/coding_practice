import java.io.*;
import java.util.*;

public class Main {
	static int[] lim = new int[3];
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		lim[0] = Integer.parseInt(st.nextToken());
		lim[1] = Integer.parseInt(st.nextToken());
		lim[2] = Integer.parseInt(st.nextToken());

		check = new boolean[lim[2] + 1]; // A가 비었을 때 C값 저장
		check[lim[2]] = true;
		;
		// water : A,B,C 각각이 갖는 값이 중복되지 않는지 확인하는 배열, 재탐색방지 목적
		boolean[][][] water = new boolean[lim[0] + 1][lim[1] + 1][lim[2] + 1];
		water[0][0][lim[2]] = true; // 시작
		Queue<int[]> q = new LinkedList<>(); // bfs
		q.offer(new int[] { 0, 0, lim[2] });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0] == 0) {
				check[now[2]] = true;
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j)
						continue;
					int[] next = move(now, i, j);
					if (!water[next[0]][next[1]][next[2]]) {
						water[next[0]][next[1]][next[2]] = true;
						q.offer(next);
					}
				}
			}
		}
		for (int i = 0; i < lim[2]; i++) {
			if (check[i] == true) 
				sb.append(i).append(" ");
		}
		sb.append(lim[2]);
		System.out.println(sb.toString());

	}

	// i에 담겨있는 물을 j로 옮김
	public static int[] move(int[] now, int i, int j) {
		if (now[i] == 0 || now[j] == lim[j]) // i가 0이라 옮길게 없음
			return now;
		int[] next = { now[0], now[1], now[2] };
		int tmp = lim[j] - now[j];
		if (now[i] > tmp) {
			next[j] += tmp;
			next[i] -= tmp;
		} else {
			next[j] += now[i];
			next[i] = 0;
		}
		return next;
	}
}