import sys

n = int(input())

score = list()
for _ in range(n):
    score.append(int(input()))

if n == 1:
    print(score[0])
    sys.exit(0)
if n == 2:
    print(score[0] + score[1])
    sys.exit(0)

dp = [0] * n

dp[0] = score[0]
dp[1] = score[0] + score[1]
dp[2] = max(score[0] + score[2], score[1] + score[2])
for i in range(3, n):
    dp[i] = max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i])

print(dp[n - 1])