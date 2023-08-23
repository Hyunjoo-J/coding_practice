import java.util.*;
import java.io.*;
public class Main {
	static int N, diff = Integer.MAX_VALUE;
	static int[] area;
	static boolean[] sel;
	static boolean[][] graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		area = new int[N];
		for(int i = 0; i < N; ++i) {
			area[i] = Integer.parseInt(st.nextToken());
		}
		graph = new boolean[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			for(int j = 0; j < tmp; ++j) {
				int a = Integer.parseInt(st.nextToken()) - 1;
				graph[i][a] = true;
			}
		}
		sel = new boolean[N];
		subset(0);
		if(diff == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(diff);
	}
	private static void subset(int dep) {
		if(dep == N) {
			LinkedList<Integer> t = new LinkedList<Integer>();
			LinkedList<Integer> f = new LinkedList<Integer>();
			for(int i = 0; i < N; ++i) {
				if(sel[i] == true)
					t.add(i);
				else
					f.add(i);
			}
			int sum1 = cal(t);
			int sum2 = cal(f);
			if(sum1 == 0 || sum2 ==0)
				return;
			diff = Math.min(diff, Math.abs(sum1 - sum2));
			return;
		}
		sel[dep] = true;
		subset(dep + 1);
		sel[dep] = false;
		subset(dep + 1);
	}
	private static int cal(LinkedList<Integer> list) {
		if(list.size() == 0)
			return 0;
		boolean[] visited = new boolean[list.size()];
		Queue<Integer> q = new LinkedList<>();
		q.offer(list.get(0));
		visited[0] = true;
		int sum = area[list.get(0)];
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i = 0; i < list.size(); ++i) {
				int ad = list.get(i);
				if(!visited[i] && graph[tmp][ad] == true) {
					visited[i] = true;;
					q.offer(ad);
					sum += area[ad];
				}
			}
		}
		for(int i = 0; i < list.size();++i) {
			if(visited[i] == false)
				return 0;
		}
		return sum;
		
	}
}