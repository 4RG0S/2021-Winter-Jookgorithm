#include <iostream>

void Move(int n, int first, int second, int third) {
  if (n == 1) {
    std::printf("%d %d\n", first, third);
  } else {
    Move(n - 1, first, third, second);
    std::printf("%d %d\n", first, third);
    Move(n - 1, second, first, third);
  }
}

void Num(int n) { 
  int count = 1;
  while (--n) {
    count = count * 2 + 1;
  }
  std::printf("%d\n", count);
}

int main() {
  int n;
  std::cin >> n;

  Num(n);
  Move(n, 1, 2, 3);
  return 0;
}