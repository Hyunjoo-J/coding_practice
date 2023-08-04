import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            Queue<Integer> q = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 8;i++){
            	q.add(Integer.parseInt(st.nextToken()));
            }
            int idx = 1;
            int tmp;
            while(true){
                tmp = q.poll();
                if(tmp - idx <= 0){
                    q.add(0);
                    break;
                }
                q.add(tmp - idx++);
                if(idx == 6)
                	idx =1;
            }
            sb.append("#").append(test_case).append(" ");
            for(int i = 0; i < 8; i++){
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}