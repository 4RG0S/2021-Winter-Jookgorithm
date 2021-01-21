#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

bool compare(std::string x, std::string y) {
  if (x.length() != y.length())
    return x.length() < y.length();
  else
    return x < y;
}

int main() {
  int n;
  std::cin >> n;
  std::vector<std::string> v;

  for (int i = 0; i < n; i++) {
    std::string tmp;
    std::cin >> tmp;
    if (find(v.begin(), v.end(), tmp) == v.end())
      v.push_back(tmp);
  }
  sort(v.begin(), v.end(), compare);
  int size = v.size();
  for (int i = 0; i < size; i++) {
      std::cout << v[i] << '\n';
  }

  return 0;
}