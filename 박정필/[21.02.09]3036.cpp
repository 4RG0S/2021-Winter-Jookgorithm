#include <iostream>

int gcd(int a, int b) {
  while (b != 0) {
    int r = a % b;
    a = b;
    b = r;
  }
  return a;
}

void circle(int one, int etc) {
  int r = gcd(one, etc);
  int child = one / r;
  int parent = etc / r;
  std::cout << child << "/" << parent <<'\n';
}

int main() {
  int n;
  std::cin >> n;
  int *arr = new int[n];
  for (int i = 0; i < n; i++) std::cin >> arr[i];
  for (int i = 1; i < n; i++) circle(arr[0], arr[i]);
  return 0;
}