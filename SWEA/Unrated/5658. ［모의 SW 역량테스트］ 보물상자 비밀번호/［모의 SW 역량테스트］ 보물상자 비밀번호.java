import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N, K;
		char[] arr = new char[56];
		int[] ans = new int[28];
		String line;
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			line = br.readLine();
			for(int i = 0; i < N; ++i) {
				arr[i] = arr[i + N] = line.charAt(i);
			}
			int turn = N / 4;
			Arrays.fill(ans, -1);
			
			Set<Integer> set = new HashSet<Integer>();
			int idx = 0;
			for(int i = 0; i < turn; ++i) {
				for(int j = 0; j < 4; ++j) {
					String str = "";
					for(int k = 0; k < turn; ++k) {
						str += arr[i + j * turn + k];
					}
					int dec = Integer.parseInt(str, 16);
					if(!set.contains(dec)) {
						ans[idx++] = dec;
						set.add(dec);
					}
				}
			}
			Arrays.sort(ans);
			sb.append("#"+test_case+" "+ans[28 - K]+"\n");
		}
		System.out.println(sb.toString());
	}

}