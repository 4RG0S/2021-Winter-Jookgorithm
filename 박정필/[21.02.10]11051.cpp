#include <iostream>

int dp[1000][1000];

int binomial(int n, int k) {
  if (k == 0 || n == k) return 1;
  if (dp[n][k] == 0)
    dp[n][k] = (binomial(n - 1, k - 1) + binomial(n - 1, k)) % 10007;
  return dp[n][k];
}

int main() {
  int n, k;
  std::cin >> n >> k;
  std::cout << binomial(n, k) << '\n';
  return 0;
}