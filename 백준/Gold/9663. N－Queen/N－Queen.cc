#include <iostream>

using namespace std;

int n, ans = 0;
int col[15];

bool promising(int r){
    for (int i = 0; i < r; i++){
        if (col[i] == col[r] || abs(col[r] - col[i]) == (r - i) )
            return false;
    }
    return true;
}
void nqueen(int x){
    if (x == n)
        ans++;
    else{
        for (int i = 0; i < n; i++){
            col[x] = i;
            if (promising(x)){
                nqueen(x + 1);
            }
        }
    }
}
int main(){
    cin >> n;
    nqueen(0);
    cout << ans;
    return (0);
}