#include <deque>
#include <iostream>

int main() {
  int n, m, fc = 0, bc = 0, count = 0;
  std::cin >> n >> m;
  std::deque<int> fd;
  std::deque<int> bd;
  for (int i = 1; i <= n; i++) {
    fd.push_back(i);
    bd.push_back(i);
  }
  for (int i = 0; i < m; i++) {
    int k;
    std::cin >> k;
    // 오른쪽 이동
    while (k != fd.front()) {
      fd.push_front(fd.back());
      fd.pop_back();
      fc++;
    }
    // 왼쪽 이동
    while (k != bd.front()) {
      bd.push_back(bd.front());
      bd.pop_front();
      bc++;
    }
    if (fc > bc) {
      count += bc;
      std::deque fd(bd);
    } else {
      count += fc;
      std::deque bd(fd);
    }
    bd.pop_front();
    fd.pop_front();
    fc = bc = 0;
  }
  std::cout << count << '\n';
  return 0;
}