#include <cmath>
#include <iostream>

int main() {
  int x, y;
  int i, j;
  std::cin >> x >> y;
  bool *arr;
  arr = new bool[y + 1];
  std::fill_n(arr, y + 1, 1);
  arr[0] = false;
  arr[1] = false;

  for (i = 2; i <= sqrt(y); ++i) {
    if (arr[i]) {
      for (j = i+i; j <= y; j += i) {
        arr[j] = false;
      }
    }
  }

  for (i = x; i <= y; i++) {
    if (arr[i]) std::cout << i << '\n';
  }

  return 0;
}