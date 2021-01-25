#include <iostream>

int Max(int a, int b) { return a > b ? a : b; }

int main() {
  int n;
  std::cin >> n;
  int *arr = new int[n];
  for (int i = 0; i < n; i++) {
    std::cin >> arr[i];
  }
  int *dp = new int[n + 1];
  dp[0] = arr[0];
  dp[1] = Max(arr[0] + arr[1], arr[1]);
  dp[2] = Max(arr[0] + arr[2], arr[1] + arr[2]);
  for (int i = 3; i <= n; i++) {
    dp[i] = Max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
  }
  std::cout << dp[n-1] << '\n';
  return 0;
}