import java.util.*;
import java.io.*;
public class Main {
    static int length, width, height;
    static long[] cube;
    static int[] box;
    static long ans = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        box = new int[3];
        for(int i=0; i<3; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            ans *= box[i];
        }
        int N = Integer.parseInt(br.readLine());
        cube = new long[N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
//        ans = length * width * height;
        System.out.println(fillBox(0, 0, N - 1));
    }

    private static long fillBox(long cnt, long used, int size) {
        long num = 1;
        for(int i = 0; i < 3; ++i)
            num *= box[i] >> size;
        num -= used;
        long possibility =  Math.min(cube[size], num);
        used += possibility;
        cnt += possibility;
        if(size == 0){
            if(used == ans)
                return cnt;
            else
                return -1;
        }else
            return fillBox(cnt, used << 3, size - 1);
    }
}