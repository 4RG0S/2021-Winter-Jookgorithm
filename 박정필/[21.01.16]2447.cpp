#include <iostream>

void printStar(int i, int j, int n) { 
  if ((i / n) % 3 == 1 && (j / n) % 3 == 1) std::cout << " ";
  else {
    if (n / 3 == 0)
      std::cout << "*";
    else
      printStar(i, j, n / 3);
  }
}

int main() {
  int n;
  std::cin >> n;
  
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      printStar(i, j, n);
    }
      std::cout << '\n';
  }

  return 0;
}