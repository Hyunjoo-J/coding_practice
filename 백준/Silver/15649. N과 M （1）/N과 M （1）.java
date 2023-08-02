import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		arr = new int[m];
		perm(0);
		System.out.println(sb.toString());
	}
	
	private static void perm(int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = i+1;
			perm(cnt+1);
			visited[i] = false;
		}
		
	}
}