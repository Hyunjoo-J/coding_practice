import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	private static int N, K, ans = Integer.MIN_VALUE;
	private static String[] strs;
	private static boolean[] alpha = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		strs = new String[N];
		for(int i = 0; i <N;i++) {
			strs[i] = br.readLine();
		}
		if(K < 5) {
			System.out.println("0");
			return ;
		}
		alpha['a' - 'a'] = true;
		alpha['c' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
		antatica(5, 0);
		System.out.println(ans);
	}

	private static void antatica(int cnt, int start) {
		if (cnt == K) {
			ans = Math.max(ans, compare());
			return;
		}
		for (int i = start; i < 26; i++) {
			if (alpha[i])
				continue;
			alpha[i] = true;
			antatica(cnt + 1, i + 1);
			alpha[i] = false;
		}
	}

	private static int compare() {
		int tmp = 0;
		for (String str : strs) {
			boolean flag = true;
			for (int j = 4; j < str.length() - 4; j++) {
				if (alpha[str.charAt(j) - 'a'] == false) {
					flag = false;
					break;
				}
			}
			if (flag == true)
				tmp++;
		}
		return tmp;
	}

}