#include <bits/stdc++.h>
#define int long long

using namespace std;
int n, m;
int32_t flavor[100000], spiciness[100000];

int get_flavor(int spice) {
    int ret = 0, tmp = 0;
    for (int i = 0; i < n; i++) {
        if (spiciness[i] <= spice) {
            tmp += flavor[i];
            ret = max(ret, tmp);
        } else tmp = 0;
    }
    return ret;
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> flavor[i] >> spiciness[i];
    int start = 0, end = 1e9;
    while (true) {
        if (start >= end) break;
        int mid = (start + end) / 2;
        if (get_flavor(mid) >= m) end = mid;
        else start = mid + 1;
    } cout << end;
    return 0;
}