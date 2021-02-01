import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    li = []
    for i in range(n):
        a, b = sys.stdin.readline().split()
        li.append([int(b),a])
    li = sorted(li)
    print(li.pop()[1])