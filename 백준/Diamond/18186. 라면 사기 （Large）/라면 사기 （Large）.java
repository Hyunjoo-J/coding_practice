import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		int[] arr = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		long ans = 0;
		if(B <= C) {
			for(int i = 0; i < N; ++i)
				ans += arr[i] * B;
			bw.write(ans+"\n");
			bw.flush();
			return;
		}
		long mul1 = B + C;
		long mul2 = B + 2 * C;
		for(int i = 0; i < N;++i) {
			if(arr[i + 1] > arr[i + 2]) {
				int num = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
				ans += num * mul1;
				arr[i] -= num;
				arr[i + 1] -= num;
				num = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				ans += num * mul2;
				arr[i] -= num;
				arr[i + 1] -= num;
				arr[i + 2] -= num;
				
			}else {
				//위에서 i + 1, i + 2 안의 값이 바꼈기 때문에 항상 i + 2가 작다고 생각할 수 없음
				int num = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				ans += num * mul2;
				arr[i] -= num;
				arr[i + 1] -= num;
				arr[i + 2] -= num;
				num = Math.min(arr[i], arr[i + 1]);
				ans += num * mul1;
				arr[i] -= num;
				arr[i + 1] -= num;
			}
			ans += arr[i] * B;
		}
		bw.write(ans+"\n");
		bw.flush();
	}
}