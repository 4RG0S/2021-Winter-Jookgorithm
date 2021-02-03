#include <iostream>
#include <string>
using namespace std;

int main() {
  string str;
  cin >> str;
  int res = 0;
  string s = "";
  bool sub = false;
  for (int i = 0; i <= str.size(); i++) {
    if (str[i] == '+' || str[i] == '-' || str[i] == '\0') {
      if (sub)
        res -= stoi(s);
      else
        res += stoi(s);
      s = "";
      if (str[i] == '-') sub = true;
      continue;
    }
    s += str[i];
  }
  cout << res << '\n';
}