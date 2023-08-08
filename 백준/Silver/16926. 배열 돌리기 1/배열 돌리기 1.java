import java.io.*;
import java.util.*;

public class Main {
	static int n, m, rot, mid;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rot = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(n > m)
			mid = m >> 1;
		else
			mid = n >> 1;
		for(int i = 0; i < rot; ++i) {
			rotation();
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void rotation() {
		int tmp;
		for(int i = 0; i < mid; ++i) {
			tmp = arr[i][i];
			for(int j = i + 1; j < m - i; ++j)
				arr[i][j - 1] = arr[i][j];
			
			for(int j = i + 1; j < n - i; ++j)
				arr[j - 1][m - 1 - i] = arr[j][m - 1 - i];
			
			for(int j = m - 2 - i; j >= i; --j)
				arr[n - 1 - i][j+1] = arr[n - 1 - i][j];
			
			for(int j = n - 2 - i; j >= i; --j)
				arr[j + 1][i] = arr[j][i];
			arr[i+1][i] = tmp;
		}
		
	}
}