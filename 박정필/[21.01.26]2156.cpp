#include <iostream>

int Max(int a, int b, int c) {
  return a > b ? (a > c) ? a : c : (b > c) ? b : c;
}

int main() {
  int n;
  std::cin >> n;
  int *arr = new int[n+1];
  int *dp = new int[n+1];
  for (int i = 1; i <= n; i++)
    std::cin >> arr[i];
  arr[0] = dp[0] = 0;
  dp[1] = arr[1];
  if (n > 1) {
    dp[2] = arr[1] + arr[2];
  }
  if (n > 2) {
    for (int i = 3; i <= n; i++) {
      dp[i] =
          Max(dp[i - 1], dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
    }
  }
  std::cout << dp[n] << '\n';
  return 0;
}