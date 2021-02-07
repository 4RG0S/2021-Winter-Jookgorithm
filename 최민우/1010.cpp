// https://www.acmicpc.net/problem/1010.cpp

#include <bits/stdc++.h>

#define int long long

using namespace std;
typedef pair<int, int> pii;
int t, n, r;
int C[31][31];

void solve() {
    cin >> r >> n;
    cout << C[n][r] << '\n';
}

int32_t main() {
#ifndef ONLINE_JUDGE
    freopen("../input.txt", "r", stdin);
#endif
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> t;
    for (n = 0; n <= 30; n++) {
        for (r = 0; r <= n; r++) {
            if (r == 0 or r == n) C[n][r] = 1;
            else C[n][r] = C[n - 1][r] + C[n - 1][r - 1];
        }
    }
    while (t--) solve();
    return 0;
}