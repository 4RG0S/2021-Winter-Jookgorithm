import sys

n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))
sum = [0]
for i in range(n):
    sum.append(sum[i]+li[i])
m = int(sys.stdin.readline())
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    print(sum[b] - sum[a-1])