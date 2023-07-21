#include <string>
#include <iostream>
#include <algorithm>
#include <set>

#define Max 1000001
using namespace std;

int k, m;
int ans;
set<string> check[11];

void BFS(string s, int cnt){
    string ch = s;
    int x = stoi(s);
    
    if (cnt == k){
        ans = max(ans, x);
        return ;
    }
    for (int i = 0; i < m - 1; i++){
        for (int j = i + 1; j < m; j++)
        {
            if (i == 0 && ch[j] == '0')
                continue;
            swap(ch[i], ch[j]);
            
            if (!check[cnt].count(ch)){//만약 n번 실행 했을 때, 동일한 값이 나오면 한 번만 실행하기 위함
                check[cnt].insert(ch);
                BFS(ch, cnt + 1);
            }
            swap(ch[i], ch[j]);
        }
    }
}

int main(){
    string s;
    cin >> s >> k;
    m = s.length();
    if (m == 1 || (m == 2 && s[1] == '0'))
        cout<<"-1"<<endl;
    else{
        BFS(s, 0);
        cout << ans;
    }
    return (0);
}