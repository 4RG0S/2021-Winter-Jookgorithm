from collections import deque
import sys

input = sys.stdin.readline

n, k = map(int, input().split())

queue = deque()
queue.append(n)
time = [0] * 100001
while queue:
    tmp = queue.popleft()
    if tmp == k:
        print(time[tmp])
        sys.exit(0)
    for i in (tmp - 1, tmp + 1, 2 * tmp):
        if 0 <= i < 100001 and time[i] == 0:
            time[i] = time[tmp] + 1
            queue.append(i)