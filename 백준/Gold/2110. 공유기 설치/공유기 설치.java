import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        bw.write(binarySearch(1, arr[arr.length - 1]));
        bw.flush();

        bw.close();
        br.close();
    }

    private static String binarySearch(int start, int end){
        int answer = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            if(canInstall(mid) < c){
                end = mid - 1;
            }else{
                answer = mid;
                start = mid + 1;
            }
        }
        return String.valueOf(answer);
    }

    private static int canInstall(int dist){
        int count = 1; //시작하는 집 무조건 설치
        int lastInstall = arr[0];

        for(int i = 1; i< arr.length; i++){
            int toLocate = arr[i];

            if(toLocate - lastInstall >= dist){
                count += 1;
                lastInstall = toLocate;
            }
        }
        return count;
    }
}