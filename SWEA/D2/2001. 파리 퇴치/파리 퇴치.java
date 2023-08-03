import java.util.*;
import java.io.*;
import java.math.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n, m;
		for(int tc = 1; tc <= T; ++tc){
            int max = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n+1][n+1];
            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= n; j++){
                	arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + Integer.parseInt(st.nextToken());
                }
            }
            for(int i = n; i >= m; --i){
            	for(int j = n; j >= m; --j){
                	max = Math.max(max, arr[i][j] - arr[i-m][j] - arr[i][j-m] + arr[i-m][j-m]);
                }
            }
            sb.append("#"+tc+" "+max+"\n");
		}
        System.out.println(sb.toString());
	}
}