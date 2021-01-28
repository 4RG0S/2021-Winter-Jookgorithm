#include <iostream>
#include <vector>
#include <math.h>

int main() {
  std::vector<int> v;
  int n, x, length = 0;
  std::cin >> n;
  v.push_back(-INFINITY);
  for (int i = 0; i < n; i++) {
    std::cin >> x;
    if (v.back() < x) {
      v.push_back(x);
      length++;
    } else {
      auto it = std::lower_bound(v.begin(), v.end(), x);
      *it = x;
    }
  }
  std::cout << length << '\n';
}