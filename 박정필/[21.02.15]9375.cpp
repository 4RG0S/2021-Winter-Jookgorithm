#include <iostream>
#include <map>
#include <string>

int main() {
  int n;
  std::cin >> n;
  for (int i = 0; i < n; i++) {
    int t;
    std::cin >> t;
    std::map<std::string, int> m;
    for (int j = 0; j < t; j++) {
      std::string key, value;
      std::cin >> key >> value;
      if (m.find(value) == m.end()) {
        m.insert({value, 1});
      } else {
        m[value]++;
      }
    }
    int count = 1;
    for (auto value : m) {
      count *= (value.second + 1);
    }
    count -= 1;
    std::cout << count << '\n';
  }
  return 0;
}