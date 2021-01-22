import sys

dp = [[0 for j in range(30)] for i in range(30)]
for i in range(30):
    dp[1][i] = i
    dp[i][i] = 1
for i in range(3, 30):
    for j in range(2, i):
        dp[j][i] = dp[j-1][i-1] + dp[j][i-1]
t = int(sys.stdin.readline())
for i in range(t):
    n, m = map(int, sys.stdin.readline().split())
    print(dp[n][m])