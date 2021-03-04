#include <iostream>
#include <stack>
#include <string>

int main() {
  while (true) {
    std::string str;
    std::stack<char> s;
    getline(std::cin, str);
    if (str == ".") break;
    bool flag = false;

    for (int i = 0; i < str.size();i++) {
      char c = str[i];
      if (c == '(' || c == '[')
        s.push(c);

      else if (c == ')') {
        if (s.empty() || s.top() != '(') {
          flag = true;
          break;
        }
        s.pop();
      } else if (c == ']') {
        if (s.empty() || s.top() != '[') {
          flag = true;
          break;
        }
        s.pop();
      }
    }
    if (flag || !s.empty())
      std::cout << "no" << '\n';
    else
      std::cout << "yes" << '\n';
  }
  return 0;
}