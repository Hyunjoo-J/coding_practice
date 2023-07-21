import java.util.Random;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[1001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 1;
        for (int i = 4; i <= n; i++){
            arr[i] = Math.min(arr[i - 1], arr[i - 3]) + 1;
        }
        if (arr[n] % 2 == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
