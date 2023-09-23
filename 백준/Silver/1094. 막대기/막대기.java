import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int length = 64, cur = 64, answer = 1;
        if(X == 64)
            bw.write("1");
        else{
            while(true){
                cur = cur >> 1;
                length -= cur;
                if(length < X){
                    answer++;
                    length += cur;
                }else if(length == X)
                    break;
            }
            bw.write(answer + "");
        }
        bw.flush();	
        bw.close();
        br.close();
    }
}