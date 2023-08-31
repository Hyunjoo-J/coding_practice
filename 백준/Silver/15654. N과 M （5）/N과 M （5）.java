import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] res, num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		res = new int[M];
		per(0, 0);
		System.out.println(sb.toString());
	}
	private static void per(int cnt, int flag) {
		if(cnt == M) {
			for(int i = 0; i < M; ++i) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; ++i) {
			if((flag & 1 << i) != 0)
				continue;
			res[cnt] = num[i];
			per(cnt + 1, flag | 1 << i);
		}
	}

}