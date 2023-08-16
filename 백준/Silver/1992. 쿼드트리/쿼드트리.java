import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		String line;
		for(int i = 0; i < n; ++i) {
			line = br.readLine();
			for(int j = 0; j < n; ++j) {
				char tmp = line.charAt(j);
				if(tmp == '0')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}
		divide(0,0,n);
		System.out.println(sb.toString());
	}
	private static void divide(int x, int y, int size) {
		if(zip(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}
		int nsize = size/2;
		sb.append("(");
		divide(x, y, nsize);
		divide(x, y+nsize, nsize);
		divide(x+nsize, y, nsize);
		divide(x+nsize, y+nsize, nsize);
		sb.append(")");
	}
	private static boolean zip(int x, int y, int size) {
		int tmp = map[x][y];
		for(int i = x; i < x + size; ++i) {
			for(int j = y; j < y + size; ++j) {
				if(map[i][j] != tmp)
					return false;
			}
		}
		return true;
	}

}