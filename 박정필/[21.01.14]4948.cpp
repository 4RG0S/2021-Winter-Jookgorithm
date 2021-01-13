#include <cmath>
#include <iostream>

int main() {
  while (1) {
    int n;
    std::cin >> n;
    if (n == 0) break;

    int count = 0;
    int i, j;
    bool *arr = new bool[n * 2 + 1];
    std::fill_n(arr, n * 2 + 1, 1);
    arr[0] = false;
    arr[1] = false;

    for (i = 2; i <= sqrt(2 * n); i++) {
      if (arr[i]) {
        for (j = i + i; j <= 2 * n; j += i) arr[j] = false;
      }
    }
    for (i = n+1; i <= 2 * n; i++) {
      if (arr[i]) count++;
    }
    std::cout << count << '\n';
  }
  return 0;
}