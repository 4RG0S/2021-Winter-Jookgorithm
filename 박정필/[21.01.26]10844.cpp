#include <iostream>
#define ten_billion 1000000000

int main() {
  int n, res = 0;
  std::cin >> n;
  int dp[101][10];
  for (int i = 0; i < 10; i++) dp[1][i] = 1;
  for (int i = 2; i <= n; i++) {
    for (int j = 0; j < 10; j++) {
      if (j == 0) {
        dp[i][0] = dp[i - 1][1] % ten_billion;
      } else if (j == 9) {
        dp[i][9] = dp[i - 1][8] % ten_billion;
      } else {
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % ten_billion;
      }
    }
  }
  for (int i = 1; i < 10; i++) res = (res + dp[n][i]) % ten_billion;
  std::cout << res << '\n';
  return 0;
}