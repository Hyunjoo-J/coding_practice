#include <iostream>

using namespace std;

int main(){
    int N, M;
    int cnt = 0,sum = 0;
    int left = 0,right = 0;
    cin >> N >> M;
    int arr[N];
    for (int i = 0; i < N; i++)
        cin >> arr[i];
    while (1){
        if (sum >= M)
            sum -= arr[left++];
        else if (right == N)
            break;
        else
            sum += arr[right++];
        if (sum == M) cnt++;
    }
    cout << cnt << endl;
    return 0;
}