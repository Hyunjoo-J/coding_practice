import java.io.*;
import java.util.*;

public class Main {
	static long arr[];	
	static long tree[];	
	static long init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];	
		}else {	
			int mid = (start+end)>>1;
			int nn = node << 1;
			return tree[node] = init(nn, start, mid) + init(nn+1, mid+1, end);
		}
		
	}
	static long sum(int node, int start, int end, int left, int right) {
		if(left > end || right < start) {	//구간 합을 구할 범위 밖
			return 0;
		}
		if(left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start+end)>>1;
		int nn = node<<1;
		return sum(nn, start, mid, left, right) + sum(nn+1, mid+1, end, left, right);
		
	}
	
	static void update (int node, int start, int end, int index, long value) {
		if(index < start || index > end)
			return;
		if (start == end) {
			tree[node] = value;
		} else {
			int mid = (start + end)>>1;
			update(node<<1, start, mid, index, value);
			update((node<<1) + 1, mid + 1, end, index, value);
			tree[node] = tree[node<<1] + tree[(node<<1) + 1];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		tree = new long[N<<2];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}
		init(1, 0, N-1);
		for (int i = 0, end = M+K;i < end; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if(command == 1) {
				update(1, 0 , N - 1, a - 1, b);
			}else {
				out.write(sum(1, 0, N - 1, a - 1, (int)b - 1)+"\n");
			}
		}
		in.close();
		out.close();
	}

}