import sys

n, m = map(int, sys.stdin.readline().split())
l = [[0 for i in range(n+1)]]
for i in range(n):
    l.append([0] + list(map(int, sys.stdin.readline().split())))
s = [[0 for i in range(n+1)] for j in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        s[i][j] = l[i][j] + s[i-1][j] + s[i][j-1] - s[i-1][j-1]
for i in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    print(s[x2][y2]+s[x1-1][y1-1]-s[x1-1][y2]-s[x2][y1-1])