import sys

n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))
dp = []
for i in range(n):
    dp.append(li[i])
    for j in range(i):
        if dp[i] > dp[j] + dp[i-j-1]:
            dp[i] = dp[j] + dp[i-j-1]
print(dp[n-1])