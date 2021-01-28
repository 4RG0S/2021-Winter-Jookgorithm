#include <iostream>

int result[100][100][100];

int w(int a, int b, int c) {
  if (a <= 0 || b <= 0 || c <= 0) return 1;
  if (a > 20 || b > 20 || c > 20) return result[a][b][c] = w(20, 20, 20);
  if (result[a][b][c] != 0) return result[a][b][c];
  if (a < b && b < c)
    return result[a][b][c] =
               w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
  else
    return result[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) +
                             w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
}

int main() {
  while (true) {
    int a, b, c;
    std::cin >> a >> b >> c;
    if (a == -1 && b == -1 && c == -1) break;
    std::cout << "w(" << a << ", " << b << ", " << c << ") = " << w(a, b, c)
              << '\n';
  }
  return 0;
}