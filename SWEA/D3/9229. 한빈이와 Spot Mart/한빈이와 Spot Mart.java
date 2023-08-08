import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i < n; ++i)
                arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if(arr[0] + arr[1] > m) {
            	sb.append("#"+tc+" -1\n");
            	continue;
            }
            int start = 0;
            int end = n - 1;
            int ans = -1;
            int now;
            while(start!=end) {
				int add =arr[start]+arr[end];
				if(add > m) 
					end--;
				else {
					now = arr[start]+arr[end];
					ans = ans > now ? ans : now;
					start++;
				}
			}
            sb.append("#"+tc+" "+ans+"\n");
		}
        System.out.println(sb.toString());
	}
}