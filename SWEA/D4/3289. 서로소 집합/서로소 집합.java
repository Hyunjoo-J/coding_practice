import java.util.*;
import java.io.*;
public class Solution {
	static int N, M;
	static int[] set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make();
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());				
				int b = Integer.parseInt(st.nextToken());				
				int c = Integer.parseInt(st.nextToken());
				if(a == 0) {
					union(b, c);
				}else {
					int bRoot = find(b);
					int cRoot = find(c);
					if(bRoot == cRoot)
						sb.append("1");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void make() {
		set = new int[N + 1];
		for(int i = 0; i <= N; ++i) {
			set[i] = i;
		}
	}
	
	private static int find(int v) {
		if(v == set[v]) return v;
		return set[v] = find(set[v]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		set[bRoot] = aRoot;
		return true;
	}

}