import java.io.*;
import java.util.*;

public class Main {
	static int[] num;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		num = new int[7];
		combi(0, 0, 0);
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int n : num) {
					sb.append(n).append("\n");
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			num[cnt] = arr[i];
			combi(cnt + 1, i + 1, sum + arr[i]);
		}
	}
}