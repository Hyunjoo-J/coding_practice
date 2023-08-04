import java.io.*;
import java.util.*;

public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i < n + 1;i++) {
			q.add(i);
		}
		int tmp;
		while(q.size() != 1) {
			q.remove();
			tmp = q.poll();
			q.add(tmp);
		}
		System.out.println(q.poll());
	}
	
}