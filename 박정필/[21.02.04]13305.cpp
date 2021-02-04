#include <iostream>

int main() {
  int n;
  std::cin >> n;
  long long *road = new long long[n];
  long long *price = new long long[n+1];
  for (int i = 1; i < n; i++) std::cin >> road[i];
  for (int i = 1; i <= n; i++) std::cin >> price[i];
  int min = price[1];
  long long res = min * road[1];
  for (int i = 2; i < n; i++) {
    if (min > price[i]) min = price[i];
    res += min * road[i];
  }
  std::cout << res << '\n';
  return 0;
}