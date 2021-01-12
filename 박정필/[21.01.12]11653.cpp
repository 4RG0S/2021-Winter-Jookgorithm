#include <iostream>

int main() {
  int n;
  int i = 2;
  std::cin >> n;

  while (n >= i || n == 0) {
    if (n % i == 0) {
      n /= i;
      std::cout << i << std::endl;
    } else {
      i++;
    }
  }

  return 0;
}