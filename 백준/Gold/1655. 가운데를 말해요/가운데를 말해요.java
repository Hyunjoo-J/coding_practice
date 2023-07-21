import java.io.*;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			if (max.size() == min.size())
				max.offer(n);
			else
				min.offer(n);

			if (!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek()) {
				min.offer(max.poll());
				max.offer(min.poll());
			}

			bw.write(max.peek() + "\n");
		}
		bw.flush();

	}

}