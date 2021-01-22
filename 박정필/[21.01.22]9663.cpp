#include <iostream>

int chese[15];
int n, count = 0;

bool isQueen(int x) {
  for (int i = 0; i < x; i++) {
    if (chese[i] == chese[x] || abs(chese[x] - chese[i]) == x - i)
      return false;
  }
  return true;
}

void cntqueen(int c) {
  if (c == n) {
    count++;
  } else {
    for (int i = 0; i < n; i++) {
      chese[c] = i;
      if (isQueen(c)) {
        cntqueen(c + 1);
      }
    }
  }
}

int main() {
  std::cin >> n;
  cntqueen(0);
  std::cout << count << '\n';
}