import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	private static int N, K, ans = Integer.MIN_VALUE;
	private static String[] strs;
	private static int[] bits;
	private static int alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		strs = new String[N];
		bits = new int[N];
		for(int i = 0; i < N;i++) {
			strs[i] = br.readLine();
			for(int j = 0, size = strs[i].length(); j < size; j++) {
				bits[i] |= (1 << (strs[i].charAt(j) - 'a'));
			}
		}
		if(K < 5) {
			System.out.println("0");
			return ;
		}
		alpha |=1 << ('a' - 'a');
		alpha |=1 << ('c' - 'a');
		alpha |=1 << ('i' - 'a');
		alpha |=1 << ('n' - 'a');
		alpha |=1 << ('t' - 'a');
		antatica(5, 0 , alpha);
		System.out.println(ans);
	}

	private static void antatica(int cnt, int start, int alpha) {
		if (cnt == K) {
			ans = Math.max(ans, compare(alpha));
			return;
		}
		for (int i = start; i < 26; i++) {
			if ((alpha & (1 << i)) != 0)
				continue;
			antatica(cnt + 1, i + 1, alpha | (1 << i));
		}
	}

	private static int compare(int alpha) {
		int tmp = 0;
		for (int bit : bits) {
			if((bit & alpha) == bit)
				tmp++;
		}
		return tmp;
	}

}