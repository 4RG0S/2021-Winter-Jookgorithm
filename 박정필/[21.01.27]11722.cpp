#include <iostream>

int Max(int a, int b) { return a > b ? a : b; }

int main() {
  int n, max = 0;
  std::cin >> n;
  int *arr = new int[n + 1];
  int *dp = new int[n + 1];

  for (int i = 1; i <= n; i++)
    std::cin >> arr[i];
  for (int i = 1; i <= n; i++) {
    dp[i] = 1;
    for (int j = 1; j < i; j++) {
      if (arr[i] < arr[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
    }
    if (max < dp[i]) max = dp[i];
  }
  std::cout << max << '\n';
  return 0;
}