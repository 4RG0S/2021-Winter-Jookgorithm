#include <iostream>
#include <deque>
#include <string>

int main() {
  int n;
  std::deque<int> d;
  std::string s;
  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> s;
    if (s == "push_front") {
      int num;
      std::cin >> num;
      d.push_front(num);
    } else if (s == "push_back") {
      int num;
      std::cin >> num;
      d.push_back(num);
    } else if (s == "pop_front") {
      if (d.empty()) std::cout << "-1" << '\n';
      else {
        std::cout << d.front() << '\n';
        d.pop_front();
      }
    } else if (s == "pop_back") {
      if (d.empty()) std::cout << "-1" << '\n';
      else {
        std::cout << d.back() << '\n';
        d.pop_back();
      }
    } else if (s == "size") {
      std::cout << d.size() << '\n';
    } else if (s == "empty") {
      if (d.empty())
        std::cout << "1" << '\n';
      else
        std::cout << "0" << '\n';
    } else if (s == "front") {
      if (d.empty())
        std::cout << "-1" << '\n';
      else
        std::cout << d.front() << '\n';
    } else if (s == "back") {
      if (d.empty())
        std::cout << "-1" << '\n';
      else
        std::cout << d.back() << '\n';
    }
  }
  return 0;
}