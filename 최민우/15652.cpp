#include <bits/stdc++.h>

#define int long long
using namespace std;

#define GCD(x, y) __gcd(x, y)
#define LCM(x, y) (x * y) / __gcd(x, y)

int sum() { return 0; }

template<typename T, typename... Args>
auto sum(T a, Args... args) { return a + sum(args...); }

#define error(args...) { string _s = #args; replace(_s.begin(), _s.end(), ',', ' '); stringstream _ss(_s); istream_iterator<string> _it(_ss); err(_it, args); }

void err(istream_iterator<string> it) {}

template<typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
    cerr << *it << " = " << a << endl;
    err(++it, args...);
}

void Solve(int n, int max, int depth, string pre) {
    if (depth == 1) {
        for (int i = n; i <= max; i++)
            cout << pre << i << '\n';
        return;
    }
    for (int i = n; i <= max; i++) {
        Solve(i, max, depth - 1, pre + to_string(i) + " ");
    }
}

int n, m;

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    Solve(1, n, m, "");
    return 0;
}