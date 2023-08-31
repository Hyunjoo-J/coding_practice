import java.util.*;
import java.io.*;

public class Main {
	static class Star{
		double x, y;

		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static class Vertex implements Comparable<Vertex>{
		int no;
		double weight;
		public Vertex(int no, double weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Star[] star = new Star[N];
		boolean[] visited = new boolean[N];
		double[] minEdge = new double[N];
		ArrayList<Vertex>[] prim = new ArrayList[N];
		for(int i = 0; i < N; ++i) {
			minEdge[i] = Double.MAX_VALUE;
			prim[i] = new ArrayList<Vertex>();
		}
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			star[i] = new Star(x, y);
			for(int j = 0; j < i; ++j) {
				double weight = Math.sqrt(Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2));
				prim[i].add(new Vertex(j, weight));
				prim[j].add(new Vertex(i, weight));
			}
		}
		double res = 0, min = 0;
		int cnt = 0, minV = 0;
		minEdge[0] = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0, 0));
		while(!pq.isEmpty()) {
			Vertex cur = pq.poll();
			minV = cur.no;
			min = cur.weight;
			if(visited[minV])
				continue;
			visited[minV] = true;
			res += min;
			if(++cnt == N)
				break;
			for(Vertex i : prim[minV]) {
				if(visited[i.no])
					continue;
				if(i.weight < minEdge[i.no]) {
					minEdge[i.no] = i.weight;
					pq.add(new Vertex(i.no, i.weight));
				}
			}			
		}
		System.out.printf("%.2f",res);
	}

}