#include <cmath>
#include <iostream>

int main() {
  int t;
  std::cin >> t;
  for (int k = 0; k < t; k++) {
    int x1, x2, y1, y2, r1, r2;
    std::cin >> x1 >> y1 >> r1;
    std::cin >> x2 >> y2 >> r2;
    int d, longer, shorter;
    d = pow(x1 - x2, 2) + pow(y1 - y2, 2);
    longer = pow(r1 + r2, 2);
    shorter = pow(r1 - r2, 2);

    int result = 0;

    if (d == 0) {
      if (r1 == r2)
        std::cout << "-1" << '\n';
      else
        std::cout << "0" << '\n';
    } else {
      if (d == longer || d == shorter)
        std::cout << "1" << '\n';
      else if (d < longer && d > shorter)
        std::cout << "2" << '\n';
      else
        std::cout << "0" << '\n';
    }
  }
  return 0;
}