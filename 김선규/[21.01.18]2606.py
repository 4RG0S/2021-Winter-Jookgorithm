import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
g = [[0 for i in range(n+1)] for j in range(n+1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    g[a][b] = 1
    g[b][a] = 1

c = -1
v = [0 for i in range(n+1)]
q = deque()
q.append(1)
while q:
    k = q.popleft()
    if v[k] == 0:
        v[k] = 1
        c += 1
        for i in range(n+1):
            if g[k][i] == 1:
                q.append(i)
print(c)