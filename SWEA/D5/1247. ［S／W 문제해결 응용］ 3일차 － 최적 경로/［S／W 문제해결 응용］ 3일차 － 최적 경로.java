import java.util.*;
import java.io.*;;

class Solution
{
	static int[][] cus = new int[10][2];
	static int[][] dis = new int[10][10];
	static int[] company = new int[10];
	static int[] home = new int[10];
	static int[] sel = new int[2];
	static int n;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int cx = 0, cy = 0, hx = 0, hy = 0;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0, size = n + 1; i < size; ++i) {
				if(i == 0) {
					cx = Integer.parseInt(st.nextToken());
					cy = Integer.parseInt(st.nextToken());
					hx = Integer.parseInt(st.nextToken());
					hy = Integer.parseInt(st.nextToken());
				}else {
				cus[i-1][0] = Integer.parseInt(st.nextToken());
				cus[i-1][1] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; ++i) {
				company[i] = Math.abs(cx - cus[i][0]) + Math.abs(cy - cus[i][1]);
				home[i] = Math.abs(hx - cus[i][0]) + Math.abs(hy - cus[i][1]);
			}
			combi(0, 0);
			
			int[] arr = new int[n];
			for(int i = 0; i < n; ++i) {
				arr[i] = i;
			}
			int min = 0;
			long ans = Long.MAX_VALUE;
			do {
				min = company[arr[0]];
				for(int i = 0; i < n - 1; ++i) {
					min += dis[arr[i]][arr[i+1]];
				}
				min += home[arr[n - 1]];
				ans = Math.min(min, ans);
			}while(np(arr));
			sb.append("#"+test_case+" "+ans+"\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void combi(int cnt, int start) {
		if(cnt == 2) {
			getdist();
			return;
		}
		for(int i = start; i < n; ++i) {
			sel[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	
	private static void getdist() {
		int n1 = sel[0];
		int n2 = sel[1];
		int d = Math.abs(cus[n1][0] - cus[n2][0]) + Math.abs(cus[n1][1] - cus[n2][1]);
		dis[n1][n2] = d;
		dis[n2][n1] = d;
		
	}
	
	private static boolean np(int[] p) {
		int N = p.length;
		int i = N - 1;
		while(i > 0 && p[i - 1] >= p[i]) --i;
		if(i == 0) return false;
		int j = N - 1;
		while(p[i - 1] >= p[j]) --j;
		swap(p, i - 1, j);
		int k = N - 1;
		while(i < k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] p, int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;

	}
}