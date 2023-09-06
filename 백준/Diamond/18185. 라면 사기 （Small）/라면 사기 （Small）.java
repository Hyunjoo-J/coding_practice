import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i = 0; i < N;++i) {
			if(arr[i + 1] > arr[i + 2]) {
				int num = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
				ans += num * 5;
				arr[i] -= num;
				arr[i + 1] -= num;
				num = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				ans += num * 7;
				arr[i] -= num;
				arr[i + 1] -= num;
				arr[i + 2] -= num;
				
			}else {
				//위에서 i + 1, i + 2 안의 값이 바꼈기 때문에 항상 i + 2가 작다고 생각할 수 없음
				int num = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				ans += num * 7;
				arr[i] -= num;
				arr[i + 1] -= num;
				arr[i + 2] -= num;
				num = Math.min(arr[i], arr[i + 1]);
				ans += num * 5;
				arr[i] -= num;
				arr[i + 1] -= num;
			}
			ans += arr[i] * 3;
		}
		bw.write(ans+"\n");
		bw.flush();
	}

}