#include <iostream>
#include <string>
#include <algorithm>

std::string Whight[8] = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
                         "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};

std::string Black[8] = {
    "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
    "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
};

std::string chese[50];

int FirstW(int x, int y) {
  int count = 0;
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
      if (chese[x + i][y + j] != Whight[i][j]) count++;
    }
  }
  return count;
}

int FirstB(int x, int y) {
  int count = 0;
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
      if (chese[x + i][y + j] != Black[i][j]) count++;
    }
  }
  return count;
}

int main() {
  int n, m;
  int min_move = 99999;
  std::cin >> n >> m;
  for (int i = 0; i < n; i++) {
    std::cin >> chese[i];
  }
  for (int i = 0; i + 8 <= n; i++) {
    for (int j = 0; j + 8 <= m; j++) {
      int tmp;
      tmp = std::min(FirstW(i, j), FirstB(i, j));
      if (tmp < min_move) min_move = tmp;
    }
  }
  std::printf("%d", min_move);
  return 0;
}