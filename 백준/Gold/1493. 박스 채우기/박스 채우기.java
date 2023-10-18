import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[] box, cube;
	static long fullV;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		box = new int[3];
		fullV = 1;
		for(int i=0; i<3; i++) {
			box[i] = Integer.parseInt(st.nextToken());
			fullV *= box[i];
		}
		int n = Integer.parseInt(br.readLine());
		
		cube = new int[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(n-1, 0, 0));
	}
	
	static long solve(int blockSize, long fill, long cnt) {
		long totalV = 1;
		for(int i=0; i<3; i++) {
			totalV *= box[i] >> blockSize;
		}
		
		int curCube = cube[blockSize];
		totalV -= fill;
		long fillCube = Math.min(curCube, totalV);
		if(blockSize == 0) {
			if((fill + fillCube) != fullV) {
				return -1;
			}
			return cnt+fillCube;
		}else {
			return solve(blockSize-1, fill+fillCube<<3, cnt+fillCube);	
		}
	}
}