import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] ingre;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int flag = 0;
		ingre = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				ingre[i][j] = Integer.parseInt(st.nextToken());
			}
			if(ingre[i][0] == ingre[i][1])
				flag = 1;
		}
		if(flag == 1) {
			System.out.println("0");
			return;
		}
		sub(0,1,0);
		System.out.println(min);
	}
	private static void sub(int cnt, int sour, int bitter) {
		if(cnt == n) {
			if(bitter != 0) {
				min = Math.min(Math.abs(sour-bitter), min);
			}
			return;
		}
		sub(cnt+1, sour * ingre[cnt][0], bitter + ingre[cnt][1]);
		sub(cnt+1, sour, bitter);		
	}

}