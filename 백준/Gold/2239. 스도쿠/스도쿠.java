import java.io.*;
public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; ++i){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < 9; ++j){
                sudoku[i][j] = c[j] - '0';
            }
        }

        dfs(0);
        for(int[] item : sudoku){
            for(int a : item){
                sb.append(a);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int dep) {
        if(dep == 81){ //사전 순 배열이기에 처음 찾은 게 무조건 정답
            flag = true;
            return;
        }
        int r = dep / 9;
        int c = dep % 9;
        if(sudoku[r][c] != 0)
            dfs(dep + 1);
        else{
            for(int i = 1; i < 10; ++i){
                if(!isPromising(r, c, i))
                    continue;
                sudoku[r][c] = i;
                dfs(dep + 1);
                if(flag)
                    return;
                sudoku[r][c] = 0;

            }
        }
    }

    private static boolean isPromising(int r, int c, int n) {
        for(int i = 0; i < 9; ++i){
            if(sudoku[i][c] == n || sudoku[r][i] == n)
                return false;
            int nr = r/3 * 3;
            int nc = c - c % 3;
            for(int j = nr; j < nr + 3; ++j) {
                for (int k = nc; k < nc + 3; ++k) {
                    if (sudoku[j][k] == n)
                        return false;
                }
            }
        }
        return true;
    }
}