import java.util.*;
import java.io.*;

public class Solution {
	static int N, M;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];
			for(int i = 1; i <= N; ++i) {
				parent[i] = i;
			}
			
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				union(from, to);
			}
			for(int i = 1; i <= N; ++i) {
				if(parent[i] == i)
					++ans;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb.toString());
	}
	private static int find(int x) {
		if(parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

}