import java.util.*;
import java.io.*;

public class Main {
	static class Node{
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u, v, w;

		public Edge(int u, int v, int w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static int N, M;
	static int[][] parent;
	static int[] depth;
	static int[] root;
	static int[][] max;
	static List<List<Node>> graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[M];
		int u, v, w;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u, v, w);
		}
		depth = new int[N + 1];
		parent = new int[N + 1][19];		
		max = new int[N + 1][19];		
		graph = new ArrayList<>(N + 1);
		for(int i = 0; i <= N; ++i) {
			graph.add(new ArrayList<>());
		}
		
		long res = kruskal(edges);		
		getDep(1,1);
		getParent();
		
		for(Edge e : edges) {
			sb.append(res - lca(e.u, e.v) + e.w).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static long lca(int a, int b) {
		if(depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		long res = 0;
		for(int i = 18; i >= 0; --i) {
			if(depth[a] - (1 << i) >= depth[b]) {
				res = Math.max(res, max[a][i]);
				a = parent[a][i];
			}
		}
		if(a != b) {
			for(int i = 18; i >= 0; --i) {
				if(parent[a][i] != parent[b][i]) {
					res = Math.max(res, max[a][i]);
                    res = Math.max(res, max[b][i]);
					a = parent[a][i];
					b = parent[b][i];
				}
			}
			res = Math.max(res, max[a][0]);
			res = Math.max(res, max[b][0]);
		}
		return res;
	}

	private static void getParent() {
		for(int i = 1; i <= 18; ++i) {
			for(int j = 1; j <= N; ++j) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
				max[j][i] = Math.max(max[j][i - 1], max[parent[j][i - 1]][i - 1]);
			}
		}
		
	}

	private static void getDep(int cur, int dep) {
		depth[cur] = dep;
		for(Node next : graph.get(cur)) {
			if (depth[next.v] > 0)
				continue;
			depth[next.v] = depth[cur] + 1;
			parent[next.v][0] = cur;
			max[next.v][0] = next.w;
			getDep(next.v, dep + 1);
		}
		
	}

	private static long kruskal(Edge[] edges) {
		Edge[] tmp = edges.clone();
		Arrays.sort(tmp);
		
		root = new int[N + 1];
		for(int i = 0; i < N; ++i) {
			root[i] = i;
		}
		
		long res = 0;
		int cnt = 0;
		for(Edge e : tmp) {
			if(union(e.u, e.v)) {
				graph.get(e.u).add(new Node(e.v, e.w));
				graph.get(e.v).add(new Node(e.u, e.w));
				res += e.w;
                if(++cnt == N - 1) 
                	break;
			}
			
		}
		return res;
	}
	
	private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot==bRoot) return false;
        root[bRoot] = aRoot;
        return true;
    }
	
    private static int findSet(int v) {
        if(root[v]==v) return v;
        return root[v] = findSet(root[v]);
    }

}