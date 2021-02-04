import sys

n = int(sys.stdin.readline())
li = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
li = sorted(li, key=lambda x:(x[1],x[0]))
for i in li:
    print(*i)