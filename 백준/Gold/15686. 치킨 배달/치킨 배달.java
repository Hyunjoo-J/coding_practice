import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int n,m,idx;
	static int[][] arr;
	static int[] sel;
	static int[][] chicken;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		sel = new int[m];
		idx = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					idx++;
				}
			}
		}
		chicken = new int[idx][2];
		idx = 0;
		for(int i= 0; i < n;i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 2) {
					chicken[idx][0] = i;
					chicken[idx++][1] = j;
				}
			}
		}
		comb(0,0);
		System.out.println(ans);
	}
	
	private static int dist(int x1, int y1, int x2, int y2) {
		int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		return dis;
	}
	
	private static void cal() {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int min = Integer.MAX_VALUE;
				if(arr[i][j] == 1) {
					for(int k = 0; k < m; k++) {
						min = Math.min(min, dist(i, j, chicken[sel[k]][0], chicken[sel[k]][1]));
					}
					sum += min;		
				}
			}
		}
		ans = Math.min(sum, ans);	
	}
	private static void comb(int cnt, int start) {
		if(cnt == m) {
			cal();
			return;
		}
		for(int i = start; i < idx; i++) {
			sel[cnt] = i; //i번째 치킨집이 사라짐
			comb(cnt+1, i + 1);
		}
	}
}