#include <iostream>
#include <vector>
#include <algorithm>

int main() {
  int n;
  std::cin >> n;
  std::vector<std::pair<int, int>> meeting;
  int start, end;
  for (int i = 0; i < n; i++) {
    std::cin >> start >> end;
    meeting.push_back(std::make_pair(end, start));
  }
  sort(meeting.begin(), meeting.end());
  int count = 0, time = 0;
  for (int i = 0; i < meeting.size(); i++) {
    int meetStart = meeting[i].second;
    int meetEnd = meeting[i].first;
    if (time <= meetStart) {
      time = meetEnd;
      count++;
    }
  }
  std::cout << count << '\n';
}