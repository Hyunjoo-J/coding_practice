import java.io.*;
import java.util.*;

public class Main {
	static int n, k;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			list.add(i+1);
		}
		sb.append("<");
		int del = k;
		int idx;
		int size;
		while(list.size() != 0) {
			size = list.size();
			idx = (del - 1 + size) % size;
			sb.append(list.get(idx));
			if(size == 1) {
				sb.append(">");
			}else {
				sb.append(", ");
			}
			list.remove(idx);
			if(list.size() != 0)
				del = (idx + k) % list.size();
		}
		System.out.println(sb.toString());
	}
}