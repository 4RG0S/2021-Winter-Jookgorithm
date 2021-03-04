#include <iostream>

long long pow(int a, int b, int c) {
  if (b == 0) return 1;
  long long n = pow(a, b / 2, c);
  long long tmp = n * n % c;

  if (b % 2 == 0)
    return tmp;
  else
    return a * tmp % c;
}

int main() {
  int a, b, c;
  std::cin >> a >> b >> c;
  std::cout << pow(a, b, c) << '\n';
}