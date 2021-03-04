#include <iostream>
#include <queue>
#include <stack>

int main() {
  int n, i, j;
  std::cin >> n;
  int *arr = new int[n];
  std::stack<int> st;
  std::queue<char> q;
  for (i = 0; i < n; i++) std::cin >> arr[i];
  i = 0;
  j = 1;
  while (i < n) {
    if (!st.empty() && st.top() == arr[i]) {
      st.pop();
      i++;
      q.push('-');
    } else if (j <= arr[i]) {
      st.push(j++);
      q.push('+');
    } else {
      std::cout << "NO" << '\n';
      return 0;
    }
  }
  while (!q.empty()) {
    std::cout << q.front() << '\n';
    q.pop();
  }
  return 0;
}