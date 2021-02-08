// https://www.acmicpc.net/problem/4485

#include <bits/stdc++.h>

#define int long long

/**************************************
 * 결과   : 
 * 시간   : 
 * 공간   :
 * ************************************
 * 정답 풀이
 * ------------------------------------
 * 
 * 
 * 오답 노트
 * ------------------------------------
 * 
 * ************************************/

using namespace std;
typedef pair<int, int> pii;
int n;
int t = 0;
int field[125][125];
int dist[125][125];

bool solve() {
    cin >> n;
    if (n == 0) return false;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> field[i][j];
            dist[i][j] = INT_MAX;
        }
    }
    priority_queue<pair<int, pii>> pq;
    dist[0][0] = field[0][0];
    pq.push({-dist[0][0], {0, 0}});
    while (!pq.empty()) {
        int cost = -pq.top().first;
        pii here = pq.top().second;

        pq.pop();
        vector<pii> delta = {{1, 0},
                             {0, 1}};
        for (auto d: delta) {
            int x = here.first + d.first;
            int y = here.second + d.second;
            if (x < n and y < n) {
                if (cost + field[y][x] < dist[y][x]) {
                    dist[y][x] = cost + field[y][x];
                    pq.push({-dist[y][x], {x, y}});
                }
            }
        }
    }
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//            cout << dist[i][j] << '\t';
//        }
//        cout << '\n';
//    }
    cout << "Problem " << ++t << ": " << dist[n - 1][n - 1] << "\n";
    return true;
}

int32_t main() {
#ifndef ONLINE_JUDGE
    freopen("../input.txt", "r", stdin);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    while (true) if (not solve()) break;
    return 0;
}