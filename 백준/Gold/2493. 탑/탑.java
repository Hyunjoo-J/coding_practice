import java.util.*;
import java.io.*;

class Main
{
	static int n;
	static int[] arr;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; ++i) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[n];
        int idx;
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; --i) {
        	while(!stack.isEmpty()) {
        		idx = stack.peek();
        		if(arr[i] >= arr[idx]) {
        			res[idx] = i + 1;
        			stack.pop();
        		}else
        			break;
        	}
        	stack.push(i);
        }
        for(int i = 0; i < n; ++i) {
        	sb.append(res[i]).append(" ");
        }
		System.out.println(sb.toString());
	}
}