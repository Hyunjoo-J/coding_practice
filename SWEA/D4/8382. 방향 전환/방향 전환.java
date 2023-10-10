import java.io.*;
import java.util.*;

public class Solution {
	static class Node {
		int x, y, d, cnt;

		public Node(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 1; i <= T; ++i) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int dx = Math.abs(x2 - x1);
			int dy = Math.abs(y2 - y1);
			int result;
			if ((dx + dy) % 2 == 0) {
				result = Math.max(dx, dy) * 2;
			} else {
				result = Math.max(dx, dy) * 2 - 1;
			}
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}
}