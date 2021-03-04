import sys

n = int(input())
wine = list()
for _ in range(n):
    wine.append(int(input()))

if n == 1:
    print(wine[0])
    sys.exit(0)

if n == 2:
    print(wine[0] + wine[1])
    sys.exit(0)

dp = [0] * n
dp[0] = wine[0]
dp[1] = wine[0] + wine[1]
dp[2] = max(wine[0] + wine[2], wine[1] + wine[2], wine[0] + wine[1])

for i in range(3, n):
    dp[i] = max(dp[i - 1], dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i])

print(dp[n - 1])