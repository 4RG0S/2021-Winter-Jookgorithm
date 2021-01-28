#include <iostream>

int Min(int a, int b) { return a < b ? a : b; }

int main() {
  int n;
  std::cin >> n;
  int arr[3];
  int drr[1001][3];
  drr[0][0] = drr[0][1] = drr[0][2] = 0;
  for (int i = 1; i <= n; i++) {
    std::cin >> arr[0] >> arr[1] >> arr[2];
    drr[i][0] = Min(drr[i - 1][1], drr[i - 1][2]) + arr[0];
    drr[i][1] = Min(drr[i - 1][0], drr[i - 1][2]) + arr[1];
    drr[i][2] = Min(drr[i - 1][0], drr[i - 1][1]) + arr[2];
  }
  std::cout << Min(Min(drr[n][0], drr[n][1]), drr[n][2]) << '\n';
  return 0;
}