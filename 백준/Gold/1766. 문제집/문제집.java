import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] degree = new int[N + 1];
		List<List<Integer>> graph = new ArrayList<>(N+1);
		for(int i = 0; i <=N; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			++degree[to];
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 1; i <= N; ++i) {
			if(degree[i] == 0)
				q.offer(i);
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for(int tmp : graph.get(cur)) {
				if(--degree[tmp] == 0)
					q.offer(tmp);
			}
		}
		System.out.println(sb.toString());
	}

}