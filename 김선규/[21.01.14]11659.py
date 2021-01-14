import sys

n, m = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))
s = [0]
for i in range(n):
    s.append(s[i]+li[i])
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    print(s[b]-s[a-1])