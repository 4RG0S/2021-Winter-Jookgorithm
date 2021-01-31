#include <iostream>

int Max(int a, int b) { return a > b ? a : b; }

int main() {
  int n, res = 0;
  std::cin >> n;
  int *arr = new int[n + 1];
  int *dp_l = new int[n + 1];
  int *dp_r = new int[n + 1];

  for (int i = 1; i <= n; i++) std::cin >> arr[i];
  for (int i = 1; i <= n; i++) {
    dp_l[i] = 1;
    for (int k = 1; k < i; k++) {
      if (arr[i] > arr[k]) dp_l[i] = Max(dp_l[i], dp_l[k] + 1);
    }
  }
  for (int i = n; i >= 1; i--) {
    dp_r[i] = 1;
    for (int j = n; j >= i; j--) {
      if (arr[i] > arr[j] && dp_r[i] < dp_r[j] + 1) dp_r[i] = dp_r[j] + 1;
    }
  }
  for (int i = 0; i <= n; i++) {
    res = Max(res, dp_l[i] + dp_r[i] - 1);
  }
  std::cout << res << '\n';
}