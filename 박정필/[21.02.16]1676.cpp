#include <iostream>

int min(int a, int b) { return a < b ? a : b; }

int main() {
  int n;
  std::cin >> n;

  int tmp, two = 0, five = 0;
  for (int i = 1; i <= n; i++) {
    tmp = i;
    while (tmp) {
      if (tmp % 2 == 0) {
        two++;
        tmp /= 2;
      } else
        break;
    }
    tmp = i;
    while (tmp) {
      if (tmp % 5 == 0) {
        five++;
        tmp /= 5;
      } else
        break;
    }
  }
  std::cout << min(two, five) << '\n';
  return 0;
}