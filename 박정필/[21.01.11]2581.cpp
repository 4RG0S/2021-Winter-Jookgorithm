#include <iostream>
#include <vector>

int main() {
  int x, y;
  long long sum = 0;
  int min = -1;
  std::cin >> x >> y;
  std::vector<bool> erato(y + 1);

  for (int i = 2; i <= y; ++i) {
    if (erato[i] == false && i >= x) {
      if (sum == 0) min = i;
      sum += i;
    }

    for (int j = i; j <= y; j += i) {
      erato[j] = true;
    }
  }
  if (min != -1)
    std::cout << sum << std::endl;
  std::cout << min << std::endl;
  return 0;
}