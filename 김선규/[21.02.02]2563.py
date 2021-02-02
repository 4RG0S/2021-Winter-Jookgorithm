import sys

n = int(sys.stdin.readline())
p = [[0 for j in range(101)]for i in range(101)]
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    if a+10< 101:
        if b+10 < 101:
            for i in range(a,a+10):
                for j in range(b, b+10):
                    p[i][j] = 1
        else:
            for i in range(a, a+10):
                for j in range(b, 101):
                    p[i][j] = 1
    else:
        if b+10 < 101:
            for i in range(a,101):
                for j in range(b, b+10):
                    p[i][j] = 1
        else:
            for i in range(a, 101):
                for j in range(b, 101):
                    p[i][j] = 1
c = 0
for i in range(101):
    for j in range(101):
        if p[i][j] == 1:
            c += 1
print(c)