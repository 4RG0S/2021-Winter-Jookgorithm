#include <algorithm>
#include <iostream>
#include <vector>

int gcd(int a, int b) {
  while (b != 0) {
    int r = a % b;
    a = b;
    b = r;
  }
  return a;
}

int main() {
  int n;
  std::vector<long long> v;
  std::cin >> n;
  long long *arr = new long long[n];
  for (int i = 0; i < n; i++) std::cin >> arr[i];
  std::sort(arr, arr + n);
  long long g = arr[1] - arr[0];
  for (int i = 2; i < n; i++) {
    long long r = arr[i] - arr[i - 1];
    g = gcd(g, r);
  }

  for (int i = 1; i * i <= g; i++) {
    if (g % i == 0) {
      v.push_back(i);
      if (i != g / i) v.push_back(g / i);
    }
  }

  std::sort(v.begin(), v.end());
  for (int i = 0; i < v.size(); i++) {
    if (v[i] != 1) std::cout << v[i] << ' ';
  }

}