#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

int main() {
  int n, mode, range, median, mean = 0;
  int max_count = -9999;
  bool not_first = false;
  std::cin >> n;
  std::vector<int> arr;
  int counting[8001] = {
      0,
  };
  for (int i = 0; i < n; i++) {
    int tmp;
    std::cin >> tmp;
    arr.push_back(tmp);
    mean += tmp;
    counting[tmp + 4000]++;
  }
  std::sort(arr.begin(), arr.end());

  for (int i = 0; i <= 8000; i++) {
    if (counting[i] == 0) continue;
    if (counting[i] == max_count) {
      if (not_first) {
        mode = i - 4000;
        not_first = false;
      }
    }
    if (counting[i] > max_count) {
      max_count = counting[i];
      mode = i - 4000;
      not_first = true;
    }
  }
  median = arr[arr.size()/2];
  mean = round((float)mean / n);
  range = arr.back() - arr.front();
  std::cout << mean << '\n';
  std::cout << median << '\n';
  std::cout << mode << '\n';
  std::cout << range << '\n';
  return 0;
}