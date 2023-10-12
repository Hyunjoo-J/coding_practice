import java.util.*;
import java.io.*;

public class Main {
	private static long[] sum = new long[101];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		sum[0] = 0;
		sum[1] = 1;
		sum[2] = 1;
		sum[3] = 1;
		for(int i = 0; i < T; ++i) {
			sb.append(cal(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static long cal(int n) {
		if(sum[n] == 0) {
			sum[n] = cal(n - 2) + cal(n - 3);
		}
		return sum[n];
	}

}