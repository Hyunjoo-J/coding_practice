import java.util.*;
import java.io.*;

public class Main {
	static int r, c, ans;
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new boolean[r][c];
		char tmp;
		for(int i = 0; i < r; ++i) {
			String line = br.readLine();
			for(int j = 0; j < c; ++j) {
				tmp = line.charAt(j);
				if(tmp == 'x')
					map[i][j] = true;
			}
		}
		for(int i = 0; i < r; ++i) {
			if(map[r - 1][c - 1] == true)
				break;
			dfs(i, 0);
		}
		System.out.println(ans);
	}
	private static boolean dfs(int x, int y) {
		map[x][y] = true;
		if(y == c - 1) {
			++ans;
			return true;
		}
		if(x -1  >= 0 && y + 1 < c && !map[x - 1][y + 1]) {
			if(dfs(x - 1, y + 1))
				return true;
		}if(y + 1 < c && !map[x][y+1]) {
			if(dfs(x, y + 1))
				return true;
		}
		if(x + 1 < r && y + 1 < c && !map[x + 1][y + 1]) {
			if(dfs(x + 1, y + 1))
				return true;
		}
		return false;
	}
}