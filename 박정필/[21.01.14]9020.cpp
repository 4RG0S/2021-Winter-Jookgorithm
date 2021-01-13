#include <cmath>
#include <iostream>

int main() {
  int t;
  std::cin >> t;

  for (int k = 0; k < t; k++) {
    int n, i, j;
    std::cin >> n;
    bool *arr = new bool[n + 1];
    std::fill_n(arr, n + 1, 1);
    arr[0] = false;
    arr[1] = false;

    for (i = 2; i <= sqrt(n); i++) {
      if (arr[i]) {
        for (j = i + i; j <= n; j += i) {
          arr[j] = false;
        }
      }
    }
    int x, y;
    for (i = n / 2; i >= 2; i--) {
      x = i;
      y = n - i;
      if (arr[x] && arr[y]) {
        std::cout << x << " " << y << '\n';
        break;
      }
    }
  }
}