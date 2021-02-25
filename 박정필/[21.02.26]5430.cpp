#include <deque>
#include <iostream>
#include <string>

int main() {
  int t, n;
  std::cin >> t;
  std::string s, arr;
  std::deque<int> dq;
  for (int i = 0; i < t; i++) {
    std::cin >> s;
    std::cin >> n;
    std::cin >> arr;
    std::string temp;
    for (int j = 0; j < arr.length(); j++) {
      if (arr[j] == '[')
        continue;
      else if ('0' <= arr[j] && arr[j] <= '9')
        temp += arr[j];
      else if (arr[j] == ',' || arr[j] == ']') {
        if (!temp.empty()) {
          dq.push_back(std::stoi(temp));
          temp.clear();
        }
      }
    }
    int len = s.length();
    bool reverse = false;
    bool error = false;
    for (int j = 0; j < len; j++) {
      if (s[j] == 'R') {
        reverse = !reverse;
      } else {
        if (dq.empty()) {
          error = true;
          std::cout << "error" << '\n';
          break;
        } else {
          if (!reverse)
            dq.pop_front();
          else
            dq.pop_back();
        }
      }
    }
    if (!error) {
      if (reverse) {
      std::cout << "[";
        while (!dq.empty()) {
          std::cout << dq.back();
          dq.pop_back();
          if (!dq.empty()) std::cout << ",";
        }
        std::cout << "]" << '\n';
      } else {
        std::cout << "[";
        while (!dq.empty()) {
          std::cout << dq.front();
          dq.pop_front();
          if (!dq.empty()) std::cout << ",";
        }
        std::cout << "]" << '\n';
      }
      
    }
  }
}