import sys

input = sys.stdin.readline

n = int(input())
w = list(map(int, input().split()))
w.sort()

ans = 1
for i in range(n):
    if ans < w[i]:
        break
    ans += w[i]
print(ans)