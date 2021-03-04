n = int(input())


dp = [1, 2, 4]


for i in range(3, 11):
    dp.append(dp[i - 3] + dp[i - 2] + dp[i - 1])

for _ in range(n):
    print(dp[int(input()) - 1])