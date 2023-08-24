import java.util.*;
import java.io.*;
public class Solution {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double weight;
		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	static int N;
	static double cost;
	static int[][] map;
	static Edge[] edge;
	static int[] parents;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][2];
			st = new StringTokenizer(br.readLine());			
			for(int i = 0; i < N; ++i) 
				map[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());			
			for(int i = 0; i < N; ++i) 
				map[i][1] = Integer.parseInt(st.nextToken());
			cost = Double.parseDouble(br.readLine());
			edge = new Edge[N*(N - 1)/2];
			int cnt = 0;
			for(int i = 0; i < N; ++i) {
				int x = map[i][0];
				int y = map[i][1];
				for(int j = i + 1; j < N; ++j) {
					long dx = Math.abs(map[j][0] - x);
					long dy = Math.abs(map[j][1] - y);
					edge[cnt++] = new Edge(i, j, dx*dx + dy*dy);
				}
			}
			make();
			Arrays.sort(edge);
			long res = 0;
			int num = 0;
			for(int i = 0; i < cnt; ++i) {
				Edge tmp = edge[i];
				if(union(tmp.from, tmp.to)) {
					res += tmp.weight;
					if(++num == N - 1)
						break;
				}
			}
			sb.append("#"+tc+" "+Math.round(res*cost)+"\n");
		}
		System.out.printf(sb.toString());
	}
	
	private static void make() {
		parents = new int[N];
		for(int i = 0; i < N; ++i) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

}