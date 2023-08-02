import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[m];
		combi(0,0);
		System.out.println(sb.toString());
	}
	private static void combi(int cnt, int start) {
		if(cnt == m) {
			for(int n : num) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < n; i++) {
			num[cnt] = i + 1;
			combi(cnt+1, i + 1);
		}
	}
}